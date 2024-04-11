import java.util.ArrayList;
import java.util.Collections;

public class SelectionSort {
    public static double increment = 0.05;

    public void sort(ArrayList<Integer> arr, DrawRect rectArr, Visualizer vis) throws InterruptedException {
        for (int i = 0; i < arr.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.size(); j++) {
                Visualizer.noOfComparisons++;
                if (arr.get(j) < arr.get(minIndex)) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Collections.swap(arr, i, minIndex);
                Thread.sleep(30);
                rectArr.setArr(arr);
                rectArr.paintImmediately(0, 230, Visualizer.WIDTH, 900);
                vis.setSize(Visualizer.WIDTH, (int) (Visualizer.HEIGHT + increment));
                increment = -increment;
            }
        }
        vis.comparisons.setText("No. of Comparisons: " + Visualizer.noOfComparisons);
        Visualizer.noOfComparisons = 0;
    }
}

