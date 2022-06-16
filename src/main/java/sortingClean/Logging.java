package sortingClean;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

import java.util.*;

@Aspect
public class Logging {

    static int timeAllSort=0;
    Map<String, Integer> runMap = new HashMap<String, Integer>();
    Map<String, Integer> timeMap = new HashMap<String, Integer>();
    @Pointcut("execution(* *.*.run*(..))")
    private void selectSort(){}

    @After("selectSort()")
    public void beforeSort(JoinPoint jp){
        System.out.println(
                "Total time of running all sort functions was "+timeAllSort+" ms\n" +
                "In detail:");
        for (Map.Entry<String, Integer> e : runMap.entrySet())
            System.out.println("Function sort in "+e.getKey()+" ran "+ e.getValue() +
                    " times and took in total "+timeMap.get(e.getKey())+" ms");



    }


    @Around("execution(void *.BubbleSort.sort(*))  && !within(TimerAspect)")
    public void BubblSort(ProceedingJoinPoint pjp) throws Throwable{
       long startTime = System.nanoTime();
        Object result = pjp.proceed();
        long time= (System.nanoTime() - startTime) / 1000000;
        timeAllSort+=time;

        if( !runMap.containsKey("BubbleSort"))
        {
         ;  timeMap.put("BubbleSort",(int) time);
            runMap.put("BubbleSort", 1);
        }
        else {
            timeMap.computeIfPresent("BubbleSort", (k, v) -> v + (int) time);
            runMap.computeIfPresent("BubbleSort", (k, v) -> v + 1);
        }

    }
    @Around("execution(void *.InsertionSort.sort(*))  && !within(TimerAspect)")
    public void insort(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.nanoTime();
        Object result = pjp.proceed();
        long time= (System.nanoTime() - startTime) / 1000000;
        timeAllSort+=time;

        if( !runMap.containsKey("InsertionSort"))
        {
            ;  timeMap.put("InsertionSort",(int) time);
            runMap.put("InsertionSort", 1);
        }
        else {
            timeMap.computeIfPresent("InsertionSort", (k, v) -> v + (int) time);
            runMap.computeIfPresent("InsertionSort", (k, v) -> v + 1);
        }
    }
    @Around("execution(void *.QuickSort.sort(*))  && !within(TimerAspect)")
    public void qSort(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.nanoTime();
        Object result = pjp.proceed();
        long time= (System.nanoTime() - startTime) / 1000000;
        timeAllSort+=time;

        if( !runMap.containsKey("QuickSort"))
        {
            ;  timeMap.put("QuickSort",(int) time);
            runMap.put("QuickSort", 1);
        }
        else {
            timeMap.computeIfPresent("QuickSort", (k, v) -> v + (int) time);
            runMap.computeIfPresent("QuickSort", (k, v) -> v + 1);
        }
    }
    @Around("execution(void *.MergeSort.sort(*))  && !within(TimerAspect)")
    public void mdSort(ProceedingJoinPoint pjp) throws Throwable{
        long startTime = System.nanoTime();
        Object result = pjp.proceed();
        long time= (System.nanoTime() - startTime) / 1000000;
        timeAllSort+=time;

        if( !runMap.containsKey("MergeSort"))
        {
            ;  timeMap.put("MergeSort",(int) time);
            runMap.put("MergeSort", 1);
        }
        else {
            timeMap.computeIfPresent("MergeSort", (k, v) -> v + (int) time);
            runMap.computeIfPresent("MergeSort", (k, v) -> v + 1);
        }
    }



}

