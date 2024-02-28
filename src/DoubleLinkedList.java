/**
 * Represents a double linked list data structure.
 * @param <T> the type of elements stored in the list
 */
public class DoubleLinkedList<T> extends AbstractList<T> {
    private Node<T> head;
    private Node<T> tail;

    private static class Node<T> {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public DoubleLinkedList() {
        super();
        head = null;
        tail = null;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        list.add(value);
    }

    @Override
    public void remove(T value) {
        Node<T> current = head;

        while (current != null) {
            if (current.data.equals(value)) {
                if (current.prev != null) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }

                if (current.next != null) {
                    current.next.prev = current.prev;
                } else {
                    tail = current.prev;
                }

                list.remove(value);
                return;
            }

            current = current.next;
        }
    }

    @Override
    public T get(int index) {
        if (index >= 0 && index < size()) {
            Node<T> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        } else {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
    }
}
