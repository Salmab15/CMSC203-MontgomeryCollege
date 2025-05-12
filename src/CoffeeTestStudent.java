import static org.junit.Assert.*;
import org.junit.Test;

public class CoffeeTestStudent {

    @Test
    public void testCalcPrice_WithExtras() {
        Coffee coffee = new Coffee("Mocha", Size.LARGE, true, true);
        assertEquals(4.5, coffee.calcPrice(), 0.01); // 2.0 + 1.0 + 0.5 + 0.5
    }

    @Test
    public void testCalcPrice_NoExtras() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, false, false);
        assertEquals(2.0, coffee.calcPrice(), 0.01); // Base price
    }

    @Test
    public void testEquals_Same() {
        Coffee c1 = new Coffee("Espresso", Size.MEDIUM, false, true);
        Coffee c2 = new Coffee("Espresso", Size.MEDIUM, false, true);
        assertTrue(c1.equals(c2));
    }

    @Test
    public void testEquals_Different() {
        Coffee c1 = new Coffee("Espresso", Size.MEDIUM, false, false);
        Coffee c2 = new Coffee("Espresso", Size.MEDIUM, true, false);
        assertFalse(c1.equals(c2));
    }
}
