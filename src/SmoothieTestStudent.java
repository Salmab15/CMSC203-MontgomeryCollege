import static org.junit.Assert.*;
import org.junit.Test;

public class SmoothieTestStudent {

    @Test
    public void testCalcPrice_WithProteinAndFruits() {
        Smoothie smoothie = new Smoothie("Green Blend", Size.MEDIUM, 3, true);
        assertEquals(4.0 + 1.5 + 1.5, smoothie.calcPrice(), 0.01); // base + protein + 3 fruits
    }

    @Test
    public void testCalcPrice_NoProtein() {
        Smoothie smoothie = new Smoothie("Fruit Mix", Size.SMALL, 2, false);
        assertEquals(2.0 + 1.0, smoothie.calcPrice(), 0.01); // base + 2 fruits
    }

    @Test
    public void testEquals_True() {
        Smoothie s1 = new Smoothie("Detox", Size.LARGE, 2, true);
        Smoothie s2 = new Smoothie("Detox", Size.LARGE, 2, true);
        assertTrue(s1.equals(s2));
    }

    @Test
    public void testEquals_False() {
        Smoothie s1 = new Smoothie("Berry", Size.SMALL, 1, false);
        Smoothie s2 = new Smoothie("Berry", Size.SMALL, 2, false);
        assertFalse(s1.equals(s2));
    }
}
