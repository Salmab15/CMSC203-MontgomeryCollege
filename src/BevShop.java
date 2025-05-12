import java.util.ArrayList;

public class BevShop implements BevShopInterface {
    private int numOfAlcohol;
    private ArrayList<Order> orders;
    private Order currentOrder;

    public BevShop() {
        orders = new ArrayList<>();
    }

    public boolean isValidTime(int time) {
        return time >= MIN_TIME && time <= MAX_TIME;
    }

    public int getMaxNumOfFruits() {
        return MAX_FRUIT;
    }

    public int getMinAgeForAlcohol() {
        return MIN_AGE_FOR_ALCOHOL;
    }

    public boolean isMaxFruit(int numOfFruits) {
        return numOfFruits > MAX_FRUIT;
    }

    public int getMaxOrderForAlcohol() {
        return MAX_ORDER_FOR_ALCOHOL;
    }

    public boolean isEligibleForMore() {
        return numOfAlcohol < MAX_ORDER_FOR_ALCOHOL;
    }

    public int getNumOfAlcoholDrink() {
        return numOfAlcohol;
    }

    public boolean isValidAge(int age) {
        return age >= MIN_AGE_FOR_ALCOHOL;
    }

    public void startNewOrder(int time, Day day, String customerName, int customerAge) {
        Customer customer = new Customer(customerName, customerAge);
        currentOrder = new Order(time, day, customer);
        orders.add(currentOrder);
        numOfAlcohol = 0;
    }

    public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
    }

    public void processAlcoholOrder(String bevName, Size size) {
        if (isEligibleForMore()) {
            currentOrder.addNewBeverage(bevName, size);
            numOfAlcohol++;
        }
    }

    public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
        currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
    }

    public int findOrder(int orderNo) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getOrderNo() == orderNo) return i;
        }
        return -1;
    }

    public double totalOrderPrice(int orderNo) {
        int index = findOrder(orderNo);
        if (index != -1) {
            return orders.get(index).calcOrderTotal();
        }
        return 0.0;
    }

    public double totalMonthlySale() {
        double total = 0.0;
        for (int i = 0; i < orders.size(); i++) {
            total += orders.get(i).calcOrderTotal();
        }
        return total;
    }

    public int totalNumOfMonthlyOrders() {
        return orders.size();
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public Order getOrderAtIndex(int index) {
        return orders.get(index);
    }

    public void sortOrders() {
        for (int i = 0; i < orders.size() - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < orders.size(); j++) {
                if (orders.get(j).compareTo(orders.get(minIndex)) < 0) {
                    minIndex = j;
                }
            }
            Order temp = orders.get(i);
            orders.set(i, orders.get(minIndex));
            orders.set(minIndex, temp);
        }
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < orders.size(); i++) {
            result += orders.get(i).toString() + "\n";
        }
        result += "Total Monthly Sale: $" + totalMonthlySale();
        return result;
    }
}