package jeicam.sort;

import jeicam.Sorter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


public class BubbleSort <T extends Comparable> implements Sorter <T>  {

    @Override
    public Collection<T> sort(Collection<T> collection) {
        List <T> newlist = new ArrayList<>(collection);

        for (int i=0;i<newlist.size();i++) {
            //newlist.get(i).compareTo(i+1);
        }

        return newlist;
    }
}



