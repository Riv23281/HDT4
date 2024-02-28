/**
 * The ListFactory class provides a static method to create different types of lists.
 */
public class ListFactory {
    /**
     * Creates a list based on the given type.
     *
     * @param type the type of list to create ("linked", "array", or "doubleLinked")
     * @return the created list
     * @throws IllegalArgumentException if the given type is not valid
     */
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
