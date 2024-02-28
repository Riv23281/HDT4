import static org.junit.Assert.*;
import org.junit.Test;

public class StackFactoryTest {
    
    @Test
    public void testCreateLinkedStack() {
        IStack<Integer> stack = StackFactory.createStack("linked");
        assertNotNull(stack);
        assertTrue(stack instanceof LinkedStack);
    }
    
    @Test
    public void testCreateArrayStack() {
        IStack<String> stack = StackFactory.createStack("array");
        assertNotNull(stack);
        assertTrue(stack instanceof ArrayStack);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidStack() {
        StackFactory.createStack("invalid");
    }
}