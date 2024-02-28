public class StackFactory {
    public static <T> IStack<T> createStack(String type) {
        if ("linked".equalsIgnoreCase(type)) {
            return new LinkedStack<>();
        } else if ("array".equalsIgnoreCase(type)) {
            return new ArrayStack<>();
        } else {
            throw new IllegalArgumentException("Tipo de pila no válido");
        }
    }
}
