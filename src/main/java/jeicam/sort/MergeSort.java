/*package jeicam.sort;

import jeicam.Sortable;

import java.util.ArrayList;
import java.util.Collection;

public class MergeSort<T extends Comparable<T>> implements Sortable<T> {
    @Override
    public Collection<T> sort(Collection<T> collection) {
        ArrayList<T> sortedList = new ArrayList<>(collection);
        mergeSort(sortedList, 0, sortedList.size() - 1);
        //for (T element : sortedList) {
        //    System.out.println(element);
        //}
        return null;
    }

    private void merge(Collection<T> collection, int startIndex, int midIndex, int endIndex) {
        ArrayList<T> sortedList = new ArrayList<>(collection);
        ArrayList<T> tempArrayList = new ArrayList<>();

        int i = startIndex;
        int j = midIndex + 1;
        int k = 0;

        while (i <= midIndex && j <= endIndex) {
            if ((sortedList.get(i).compareTo(sortedList.get(j))) <= 0) {
                tempArrayList.add(k, sortedList.get(i));
                k++;
                i++;
            } else {
                tempArrayList.add(k, sortedList.get(j));
                k++;
                j++;
            }
        }
        while (i <= midIndex) {
            tempArrayList.add(k, sortedList.get(i));
            k++;
            i++;
        }
        while (j <= endIndex) {
            tempArrayList.add(k, sortedList.get(j));
            k++;
            j++;
        }

        for (T element : sortedList) {
            System.out.println(element);
        }

        for (int l = startIndex; l <= endIndex; l++) {
            sortedList.set(i, tempArrayList.get(i - startIndex));
        }

    }

    void mergeSort(Collection<T> collection, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            int midIndex = (startIndex + endIndex) / 2;
            mergeSort(collection, startIndex, midIndex);
            mergeSort(collection, midIndex + 1, endIndex);
            merge(collection, startIndex, midIndex, endIndex);
        }
    }

}*/
