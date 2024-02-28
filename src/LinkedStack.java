/**
 * This class represents a stack implemented using a linked list.
 * It extends the AbstractStack class and provides methods for
 * pushing, popping, and peeking elements in the stack.
 *
 * @param <T> the type of elements stored in the stack
 */
public class LinkedStack<T> extends AbstractStack<T> {
    private Node<T> top;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedStack() {
        super();
        top = null;
    }

    @Override
    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
    }

    @Override
    public T pop() {
        if (!isEmpty()) {
            T value = top.data;
            top = top.next;
            return value;
        } else {
            throw new IllegalStateException("ERROR: Stack Vacio");
        }
    }

    @Override
    public T peek() {
        if (!isEmpty()) {
            return top.data;
        } else {
            throw new IllegalStateException("ERROR: Stack Vacio");
        }
    }
}
