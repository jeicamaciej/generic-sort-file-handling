package main.java.jeicam.sort;

import main.java.jeicam.Sorter;
import main.java.jeicam.TimeValueFormatter;

import java.util.ArrayList;
import java.util.List;

public class InsertionSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public List<T> sort(List<T> collection, String fieldName) {

        final long startTime = System.nanoTime();
        final List<T> sortedList = new ArrayList<>(collection);

        for (int j = sortedList.size() - 2; j >= 0; j--) {
            T tempObject = sortedList.get(j);
            int i = j + 1;
            while ((i < sortedList.size()) && (getFieldValue(tempObject, fieldName).compareTo(getFieldValue(sortedList.get(i), fieldName))) > 0) {
                sortedList.set(i - 1, sortedList.get(i));
                i++;
            }
            sortedList.set(i - 1, tempObject);
        }

        final long endTime = System.nanoTime();
        for (T element : sortedList) {
            System.out.println(element);
        }
        System.out.println("Insertion sort took: " + (TimeValueFormatter.nsToMsValue(endTime - startTime)) + " ms");

        return sortedList;
    }
}
