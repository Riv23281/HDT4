public class ListFactory {
    public static <T> IList<T> createList(String type) {
        if ("linked".equalsIgnoreCase(type)) {
            return new LinkedList<>();
        } else if ("array".equalsIgnoreCase(type)) {
            return new ArrayList<>();
        } else if ("doubleLinked".equalsIgnoreCase(type)) {
            return new DoubleLinkedList<>();
        } else {
            throw new IllegalArgumentException("Tipo de lista no válido");
        }
    }
}
