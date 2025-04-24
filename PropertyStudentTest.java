import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PropertyStudentTest {

    @Test
    public void testDefaultConstructor() {
        Property p = new Property();
        assertEquals("", p.getPropertyName());
        assertEquals("", p.getCity());
        assertEquals(0.0, p.getRentAmount());
        assertEquals("", p.getOwner());
        assertNotNull(p.getPlot());
    }

    @Test
    public void testParameterizedConstructorBasic() {
        Property p = new Property("Palm Gardens", "Miami", 2500.0, "John Smith");
        assertEquals("Palm Gardens", p.getPropertyName());
        assertEquals("Miami", p.getCity());
        assertEquals(2500.0, p.getRentAmount());
        assertEquals("John Smith", p.getOwner());
        assertNotNull(p.getPlot()); // default plot expected
    }

    @Test
    public void testParameterizedConstructorFull() {
        Property p = new Property("Skyline", "Dallas", 1800.0, "Jane Doe", 2, 3, 4, 5);
        assertEquals("Skyline", p.getPropertyName());
        assertEquals("Dallas", p.getCity());
        assertEquals(1800.0, p.getRentAmount());
        assertEquals("Jane Doe", p.getOwner());
        assertEquals(2, p.getPlot().getX());
        assertEquals(3, p.getPlot().getY());
        assertEquals(4, p.getPlot().getWidth());
        assertEquals(5, p.getPlot().getDepth());
    }

    @Test
    public void testToString() {
        Property p = new Property("Bayview", "Seattle", 3000.0, "Alice");
        String expected = "Property Name: Bayview\nLocated in Seattle\nBelonging to Alice\nRent Amount: 3000.0";
        assertEquals(expected, p.toString());
    }

    @Test
    public void testSettersAndGetters() {
        Property p = new Property();
        p.setPropertyName("Sunset Villas");
        p.setCity("Orlando");
        p.setRentAmount(2000.0);
        p.setOwner("Bob Builder");
        p.setPlot(1, 1, 3, 3);

        assertEquals("Sunset Villas", p.getPropertyName());
        assertEquals("Orlando", p.getCity());
        assertEquals(2000.0, p.getRentAmount());
        assertEquals("Bob Builder", p.getOwner());
        assertEquals(1, p.getPlot().getX());
        assertEquals(3, p.getPlot().getWidth());
    }
}
