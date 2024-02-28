/**
 * This class represents a stack data structure implemented using an array.
 * It extends the AbstractStack class and provides methods to push, pop, and peek elements in the stack.
 *
 * @param <T> the type of elements stored in the stack
 */
public class ArrayStack<T> extends AbstractStack<T> {
    public ArrayStack() {
        super();
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
