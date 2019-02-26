package jeicam;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Collection;

public interface Sorter<T extends Comparable> {
    /**
     * creates new collection same as passed as argument, which is sorted and returned
     * displays both sorting time and the new collection
     * collection passed as an argument does not change
     *
     * if fieldName equals null method returns default collection
     *
     * @param collection collection to be sorted
     * @param fieldName object's property used to compare elements while sorting
     * @return new sorted collection
     */
    Collection<T> sort(@NotNull Collection<T> collection, String fieldName);

    /**
     * method checks if the object's class implements Comparable interface
     * if not, returns null
     * otherwise field's value is casted to Comparable and returned
     *
     * @param object object from collections which is going to be sorted
     * @param fieldName object's property used to compare elements while sorting
     * @return field's value casted to Comparable
     */

    default Comparable getFieldValue(@NotNull T object, String fieldName) {

        if (object instanceof Comparable) {
            Field field = null;
            try {
                field = object.getClass().getDeclaredField(fieldName);
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            }
            field.setAccessible(true);
            try {
                return (Comparable) field.get(object);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return null;
            }
        } else {
            throw new IllegalArgumentException("object's class does not implement Comparable");
        }

    }
}

