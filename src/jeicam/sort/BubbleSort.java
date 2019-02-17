package jeicam.sort;

import jeicam.Sorter;

import java.util.*;


public class BubbleSort<T extends Comparable<T>> implements Sorter<T> {

    @Override
    public Collection<T> sort(Collection<T> collection) {

        List<T> newlist = new ArrayList<>(collection);
        boolean swap;
        long startTime = System.nanoTime();
        for (int j = newlist.size() - 1; j > 0; j++) {
            swap = false;
            for (int i = 0; i < newlist.size() - 1; i++) {
                if (newlist.get(i).compareTo(newlist.get(i + 1)) > 0) {
                    Collections.swap(newlist, i, i + 1);
                    swap = true;
                }
            }
            if (!swap) {
                break;
            }
        }
        long endTime = System.nanoTime();

        for (T element : newlist) {
            System.out.println(element);
        }

        System.out.println("Bubble sort took: " + (endTime - startTime) + " ns");

        return newlist;
    }

}



