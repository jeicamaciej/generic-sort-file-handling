package jeicam.sort;

import jeicam.Sorter;
import jeicam.TimeValueFormatter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {
    @Override
    public Collection<T> sort(Collection<T> collection) {
        final long startTime = System.nanoTime();
        final List<T> sortedList = new ArrayList<>(collection);
        boolean swap;

        for (int j = sortedList.size() - 1; j > 0; j++) {
            swap = false;
            for (int i = 0; i < sortedList.size() - 1; i++) {
                if (sortedList.get(i).compareTo(sortedList.get(i + 1)) > 0) {
                    Collections.swap(sortedList, i, i + 1);
                    swap = true;
                }
            }
            if (!swap) {
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




