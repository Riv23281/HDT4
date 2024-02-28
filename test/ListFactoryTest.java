import static org.junit.Assert.*;
import org.junit.Test;

public class ListFactoryTest {
    
    @Test
    public void testCreateLinkedList() {
        IList<Integer> list = ListFactory.createList("linked");
        assertNotNull(list);
        assertTrue(list instanceof LinkedList);
    }
    
    @Test
    public void testCreateArrayList() {
        IList<String> list = ListFactory.createList("array");
        assertNotNull(list);
        assertTrue(list instanceof ArrayList);
    }
    
    @Test
    public void testCreateDoubleLinkedList() {
        IList<Character> list = ListFactory.createList("doubleLinked");
        assertNotNull(list);
        assertTrue(list instanceof DoubleLinkedList);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testCreateInvalidList() {
        ListFactory.createList("invalid");
    }
}