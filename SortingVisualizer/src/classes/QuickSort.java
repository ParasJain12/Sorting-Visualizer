import java.util.ArrayList;
import java.util.Collections;

public class QuickSort {
    public static double increment = 0.05;

    public void sort(ArrayList<Integer> arr, int low, int high, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        if (low < high) {
            int pi = partition(arr, low, high, rectArr, vis);
            sort(arr, low, pi - 1, rectArr, vis);
            sort(arr, pi + 1, high, rectArr, vis);
            vis.comparisons.setText("No. of Comparisons: " + Visualizer.noOfComparisons);
        }
    }

    static int partition(ArrayList<Integer> arr, int low, int high, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            Visualizer.noOfComparisons++;
            if (arr.get(j) < pivot) {
                i++;
                Collections.swap(arr, i, j);
                Thread.sleep(30);
                rectArr.setArr(arr);
                rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
                vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
                increment = -increment;
            }
        }
        Collections.swap(arr, i + 1, high);
        Thread.sleep(30);
        rectArr.setArr(arr);
        rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
        vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
        increment = -increment;
        return i + 1;
    }
}

