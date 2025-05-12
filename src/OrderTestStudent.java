import static org.junit.Assert.*;
import org.junit.Test;

public class OrderTestStudent {

    @Test
    public void testAddBeveragesAndCount() {
        Order order = new Order(10, Day.WEDNESDAY, new Customer("Amir", 22));

        order.addNewBeverage("Espresso", Size.SMALL, false, false);
        order.addNewBeverage("Beer", Size.MEDIUM);
        order.addNewBeverage("Detox", Size.LARGE, 2, true);

        assertEquals(3, order.getTotalItems());
        assertEquals(Type.COFFEE, order.getBeverage(0).getType());
        assertEquals(Type.ALCOHOL, order.getBeverage(1).getType());
        assertEquals(Type.SMOOTHIE, order.getBeverage(2).getType());
    }

    @Test
    public void testCalcOrderTotal() {
        Order order = new Order(9, Day.MONDAY, new Customer("Nora", 30));

        order.addNewBeverage("Latte", Size.MEDIUM, false, true); // 2.5 + 0.5 = 3.0
        order.addNewBeverage("Whiskey", Size.SMALL); // 2.0
        order.addNewBeverage("Tropical", Size.SMALL, 3, false); // 2.0 + 1.5 = 3.5

        assertEquals(8.5, order.calcOrderTotal(), 0.01);
    }

    @Test
    public void testFindNumOfBeveType() {
        Order order = new Order(12, Day.FRIDAY, new Customer("Zaid", 28));

        order.addNewBeverage("Coffee", Size.SMALL, false, false);
        order.addNewBeverage("Smoothie", Size.SMALL, 2, false);
        order.addNewBeverage("Smoothie", Size.LARGE, 1, true);

        assertEquals(1, order.findNumOfBeveType(Type.COFFEE));
        assertEquals(2, order.findNumOfBeveType(Type.SMOOTHIE));
        assertEquals(0, order.findNumOfBeveType(Type.ALCOHOL));
    }

    @Test
    public void testCompareTo() {
        Order o1 = new Order(10, Day.MONDAY, new Customer("A", 25));
        Order o2 = new Order(10, Day.MONDAY, new Customer("A", 25));
        assertEquals(0, o1.compareTo(o2));
    }
}
