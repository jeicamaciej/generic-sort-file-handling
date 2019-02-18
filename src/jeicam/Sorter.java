package jeicam;

import java.util.Collection;

public interface Sorter<T extends Comparable>{
    Collection<T> sort(Collection<T> collection);
}
