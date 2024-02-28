/**
 * The StackFactory class provides a static method to create different types of stacks.
 */
public class StackFactory {
    /**
     * Creates a stack based on the specified type.
     *
     * @param type the type of stack to create ("linked" for LinkedStack, "array" for ArrayStack)
     * @param <T> the type of elements in the stack
     * @return an instance of the specified stack type
     * @throws IllegalArgumentException if the specified type is not valid
     */
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
