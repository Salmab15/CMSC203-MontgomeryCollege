import static org.junit.Assert.*;
import org.junit.Test;

public class BevShopTestStudent {

    @Test
    public void testStartNewOrderAndProcessOrders() {
        BevShop shop = new BevShop();

        shop.startNewOrder(10, Day.TUESDAY, "Lina", 25);
        shop.processCoffeeOrder("Latte", Size.MEDIUM, true, false);
        shop.processSmoothieOrder("Tropical", Size.SMALL, 2, true);
        shop.processAlcoholOrder("Wine", Size.SMALL);

        Order current = shop.getCurrentOrder();
        assertEquals(3, current.getTotalItems());
        assertEquals("Lina", current.getCustomer().getName());
    }

    @Test
    public void testEligibilityChecks() {
        BevShop shop = new BevShop();

        assertTrue(shop.isValidTime(9));
        assertFalse(shop.isValidTime(7));
        assertTrue(shop.isValidAge(21));
        assertFalse(shop.isValidAge(18));
        assertTrue(shop.isMaxFruit(6));
        assertFalse(shop.isMaxFruit(3));
    }

    @Test
    public void testAlcoholLimit() {
        BevShop shop = new BevShop();
        shop.startNewOrder(12, Day.SATURDAY, "Ali", 30);

        shop.processAlcoholOrder("Beer", Size.SMALL);
        shop.processAlcoholOrder("Wine", Size.MEDIUM);
        shop.processAlcoholOrder("Vodka", Size.LARGE);

        assertFalse(shop.isEligibleForMore()); // should be false after 3
    }

    @Test
    public void testTotalMonthlySale() {
        BevShop shop = new BevShop();

        shop.startNewOrder(11, Day.MONDAY, "John", 40);
        shop.processCoffeeOrder("Espresso", Size.SMALL, false, false);

        shop.startNewOrder(13, Day.TUESDAY, "Sara", 22);
        shop.processSmoothieOrder("Fruit Mix", Size.LARGE, 2, false);

        assertTrue(shop.totalMonthlySale() > 0);
        assertEquals(2, shop.totalNumOfMonthlyOrders());
    }
}
