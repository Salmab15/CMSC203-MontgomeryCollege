import static org.junit.Assert.*;
import org.junit.Test;

public class AlcoholTestStudent {

    @Test
    public void testCalcPrice_Weekend() {
        Alcohol drink = new Alcohol("Wine", Size.LARGE, true);
        assertEquals(3.6, drink.calcPrice(), 0.01); // 2.0 + 0.5 + 0.5 + 0.6
    }

    @Test
    public void testCalcPrice_Weekday() {
        Alcohol drink = new Alcohol("Beer", Size.MEDIUM, false);
        assertEquals(2.5, drink.calcPrice(), 0.01); // 2.0 + 0.5
    }

    @Test
    public void testEquals_True() {
        Alcohol a1 = new Alcohol("Beer", Size.MEDIUM, false);
        Alcohol a2 = new Alcohol("Beer", Size.MEDIUM, false);
        assertTrue(a1.equals(a2));
    }

    @Test
    public void testEquals_False() {
        Alcohol a1 = new Alcohol("Beer", Size.SMALL, false);
        Alcohol a2 = new Alcohol("Wine", Size.SMALL, false);
        assertFalse(a1.equals(a2));
    }
}
