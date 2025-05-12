import static org.junit.Assert.*;
import org.junit.Test;

public class CustomerTestStudent {

    @Test
    public void testGetters() {
        Customer customer = new Customer("Sara", 19);
        assertEquals("Sara", customer.getName());
        assertEquals(19, customer.getAge());
    }

    @Test
    public void testSetters() {
        Customer customer = new Customer("Tom", 30);
        customer.setName("Ali");
        customer.setAge(21);
        assertEquals("Ali", customer.getName());
        assertEquals(21, customer.getAge());
    }

    @Test
    public void testCopyConstructor() {
        Customer original = new Customer("Lena", 25);
        Customer copy = new Customer(original);
        assertEquals(original.getName(), copy.getName());
        assertEquals(original.getAge(), copy.getAge());
        assertNotSame(original, copy); // ensure it's not the same object
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Ray", 40);
        assertTrue(customer.toString().contains("Ray"));
        assertTrue(customer.toString().contains("40"));
    }
}
