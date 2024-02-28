/**
 * This class represents a linked list data structure.
 * It extends the AbstractList class and implements the List interface.
 * It provides methods to add, remove, and retrieve elements from the list.
 *
 * @param <T> the type of elements stored in the linked list
 */
public class LinkedList<T> extends AbstractList<T> {
    private Node<T> head;

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList() {
        super();
        head = null;
    }

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        list.add(value);
    }

    @Override
    public void remove(T value) {
        if (isEmpty()) {
            return;
        }

        if (head.data.equals(value)) {
            head = head.next;
            list.remove(value);
            return;
        }

        Node<T> current = head;
        while (current.next != null && !current.next.data.equals(value)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
            list.remove(value);
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
