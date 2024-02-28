import java.util.List;

/**
 * Clase abstracta que proporciona una implementación básica de la interfaz IStack.
 * Se encarga de manejar la estructura de datos de la pila.
 * @param <T> Tipo de elemento que se almacenará en la pila.
 */
public abstract class AbstractStack<T> implements IStack<T> {
    protected List<T> stack;

    public AbstractStack() {
        stack = new java.util.ArrayList<>();
    }

    @Override
    public int count() {
        return stack.size();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public void push(T value) {
        stack.add(value);
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            return stack.remove(stack.size() - 1);
        } else {
            throw new IllegalStateException("ERROR: Stack Vacio");
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return stack.get(stack.size() - 1);
        } else {
            throw new IllegalStateException("ERROR: Stack Vacio");
        }
    }
}
