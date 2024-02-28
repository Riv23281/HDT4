import java.util.List;

/**
 * Clase abstracta que proporciona una implementación básica de la interfaz IStack.
 * Se encarga de manejar la estructura de datos de la pila.
 * @param <T> Tipo de elemento que se almacenará en la pila.
 */
/**
 * An abstract implementation of the IStack interface.
 * Provides common functionality for stack implementations.
 *
 * @param <T> the type of elements in the stack
 */
public abstract class AbstractStack<T> implements IStack<T> {
    protected List<T> stack;

    /**
     * Constructs an empty AbstractStack.
     */
    public AbstractStack() {
        stack = new java.util.ArrayList<>();
    }

    /**
     * Returns the number of elements in the stack.
     *
     * @return the number of elements in the stack
     */
    @Override
    public int count() {
        return stack.size();
    }

    /**
     * Checks if the stack is empty.
     *
     * @return true if the stack is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    /**
     * Pushes a value onto the top of the stack.
     *
     * @param value the value to push onto the stack
     */
    @Override
    public void push(T value) {
        stack.add(value);
    }

    /**
     * Removes and returns the value at the top of the stack.
     *
     * @return the value at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            throw new IllegalStateException("ERROR: Stack Vacio");
        }
    }

    /**
     * Returns the value at the top of the stack without removing it.
     *
     * @return the value at the top of the stack
     * @throws IllegalStateException if the stack is empty
     */
    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        } else {
            throw new IllegalStateException("ERROR: Stack Vacio");
        }
    }
}
