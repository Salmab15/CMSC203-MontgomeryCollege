import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PlotStudentTest {

    @Test
    public void testDefaultConstructor() {
        Plot p = new Plot();
        assertEquals(0, p.getX());
        assertEquals(0, p.getY());
        assertEquals(1, p.getWidth());
        assertEquals(1, p.getDepth());
    }

    @Test
    public void testFullConstructor() {
        Plot p = new Plot(2, 3, 4, 5);
        assertEquals(2, p.getX());
        assertEquals(3, p.getY());
        assertEquals(4, p.getWidth());
        assertEquals(5, p.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot original = new Plot(1, 2, 3, 4);
        Plot copy = new Plot(original);
        assertEquals(1, copy.getX());
        assertEquals(2, copy.getY());
        assertEquals(3, copy.getWidth());
        assertEquals(4, copy.getDepth());
    }

    @Test
    public void testToString() {
        Plot p = new Plot(5, 6, 7, 8);
        assertEquals("Upper left: (5,6); Width: 7 Depth: 8", p.toString());
    }

    @Test
    public void testOverlapsAndEncompasses() {
        Plot outer = new Plot(2, 2, 6, 6);
        Plot inner = new Plot(3, 3, 2, 2);
        Plot edgeTouching = new Plot(8, 2, 2, 6);

        assertTrue(outer.overlaps(inner));
        assertTrue(outer.encompasses(inner));
        assertFalse(outer.overlaps(edgeTouching)); 
    }
}
