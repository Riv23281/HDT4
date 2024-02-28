/**
 * This interface represents a generic stack data structure.
 * A stack is a Last-In-First-Out (LIFO) data structure where elements are added and removed from the top.
 * It provides operations to count the number of elements, check if the stack is empty, push an element onto the stack,
 * pop the top element from the stack, and peek at the top element without removing it.
 *
 * @param <T> the type of elements stored in the stack
 */
public interface IStack<T> {
    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    int count();

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Pushes an element onto the top of the stack.
     *
     * @param value the element to be pushed onto the stack
     */
    void push(T value);

    /**
     * Removes and returns the top element from the stack.
     *
     * @return the top element from the stack
     */
    T pop();

    /**
     * Returns the top element from the stack without removing it.
     *
     * @return the top element from the stack
     */
    T peek();
}
