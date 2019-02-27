package main.java.jeicam.sort;

import main.java.jeicam.Sorter;
import main.java.jeicam.TimeValueFormatter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public List<T> sort(List<T> collection, String fieldName) {

        final long startTime = System.nanoTime();
        final List<T> sortedList = new ArrayList<>(collection);
        boolean isSwapped;

        for (int j = sortedList.size() - 1; j > 0; j++) {
            isSwapped = false;
            for (int i = 0; i < sortedList.size() - 1; i++) {
                if (getFieldValue(sortedList.get(i), fieldName).compareTo(getFieldValue(sortedList.get(i + 1), fieldName)) > 0) {

                    Collections.swap(sortedList, i, i + 1);
                    isSwapped = true;
                }
            }
            if (!isSwapped) {
                break;
            }
        }

        final long endTime = System.nanoTime();

        for (T element : sortedList) {
            System.out.println(element);
        }

        System.out.println("Bubble sort took: " + (TimeValueFormatter.nsToMsValue(endTime - startTime)) + " ms");
        return sortedList;
    }
}



