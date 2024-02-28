/**
 * This interface represents a generic list data structure.
 * It provides methods to manipulate and access elements in the list.
 *
 * @param <T> the type of elements in the list
 */
public interface IList<T> {
    /**
     * Returns the number of elements in the list.
     *
     * @return the number of elements in the list
     */
    int size();

    /**
     * Checks if the list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Adds an element to the list.
     *
     * @param value the element to be added
     */
    void add(T value);

    /**
     * Removes an element from the list.
     *
     * @param value the element to be removed
     */
    void remove(T value);

    /**
     * Returns the element at the specified index in the list.
     *
     * @param index the index of the element to be retrieved
     * @return the element at the specified index
     */
    T get(int index);
}
