package sortingClean;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.enterprise.inject.Produces;
import javax.inject.Named;
import java.util.Random;


public class MainApp {
    static Weld weld = new Weld();
    static WeldContainer container = weld.initialize();
    public static void main(String[] args) {


        AlgorithmRunner algorithmRunner = container.select(AlgorithmRunner.class).get();
        algorithmRunner.setNumberOfElements(1000);
        algorithmRunner.runAlgorithms();
    }

    private static String makeRandomSortingAlgorithm() {
        Random random = new Random(System.currentTimeMillis());
        String kind="sort";
        switch (random.nextInt(4)) {
            case 0:
                kind="BubbleSort";
                break;
            case 1:
               kind="QuickSort";
               break;
            case 2:
                kind="InsertionSort";
                break;
            case 3:
                kind="MergeSort";
                break;
        }
        return kind;
    }

    @Produces
    public @Named("bubbleSort") SortingAlgorithm<Integer> quadraticAlgorithm() {

        return  container.select(BubbleSort.class).get();
    }
    @Produces
    public @Named("MergeSort") SortingAlgorithm<Integer> nLognAlgorithm() {

        return  container.select(MergeSort.class).get();
    }


    @Produces
    public  @Named("random") SortingAlgorithm<Integer> randomAlgorithm() {

        String kind = makeRandomSortingAlgorithm();
        switch (kind) {
            case "BubbleSort":
                return  container.select(BubbleSort.class).get();

            case "QuickSort":
                return  container.select(QuickSort.class).get();

            case "InsertionSort":
                return  container.select(InsertionSort.class).get();

            case "MergeSort":
                return  container.select(MergeSort.class).get();

        }

     return null;
    }
}

