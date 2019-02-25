package jeicam.sort;

import jeicam.Sorter;
import jeicam.TimeValueFormatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class QuickSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public Collection<T> sort(Collection<T> collection, String fieldName) {
        final long startTime = System.nanoTime();
        final List<T> sortedList = new ArrayList<>(collection);

        quickSort(sortedList, 0, sortedList.size() - 1, fieldName);
        final long endTime = System.nanoTime();


        for (T element : sortedList) {
            System.out.println(element);
        }

        System.out.println("Quick sort took: " + (TimeValueFormatter.nsToMsValue(endTime - startTime)) + " ms");
        return sortedList;
    }

    private int quickSortPartition(List<T> sortedList, int left, int right, String fieldName) {
        int smallerElementIndex = left - 1;

        for (int j = left; j <= right; j++) {
            if (getFieldValue(sortedList.get(j), fieldName).compareTo(getFieldValue(sortedList.get(right), fieldName)) < 0) {
                smallerElementIndex++;
                Collections.swap(sortedList, smallerElementIndex, j);
            }
        }
        Collections.swap(sortedList, smallerElementIndex + 1, right);
        return smallerElementIndex + 1;
    }

    private void quickSort(List<T> collection, int left, int right, String fieldName) {
        if (left < right) {
            int partitioningIndex = quickSortPartition(collection, left, right, fieldName);
            quickSort(collection, left, partitioningIndex - 1, fieldName);
            quickSort(collection, partitioningIndex + 1, right, fieldName);
        }
    }
}

