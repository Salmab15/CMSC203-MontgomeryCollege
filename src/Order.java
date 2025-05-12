import java.util.*;

public class Order implements OrderInterface, Comparable<Order> {
    private int orderNo, orderTime;
    private Day orderDay;
    private Customer customer;
    private ArrayList<Beverage> beverages;

    public Order(int orderTime, Day orderDay, Customer customer) {
        this.orderNo = (int)(Math.random() * (90000 - 10000) + 10000);
        this.orderTime = orderTime;
        this.orderDay = orderDay;
        this.customer = new Customer(customer);
        beverages = new ArrayList<>();
    }

    public boolean isWeekend() {
        return orderDay == Day.SATURDAY || orderDay == Day.SUNDAY;
    }

    public Beverage getBeverage(int itemNo) {
        if (itemNo >= 0 && itemNo < beverages.size()) return beverages.get(itemNo);
        return null;
    }

    public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
        beverages.add(new Coffee(bevName, size, extraShot, extraSyrup));
    }

    public void addNewBeverage(String bevName, Size size) {
        beverages.add(new Alcohol(bevName, size, isWeekend()));
    }

    public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
        beverages.add(new Smoothie(bevName, size, numOfFruits, addProtein));
    }

    public double calcOrderTotal() {
        double total = 0.0;
        for (int i = 0; i < beverages.size(); i++) {
            total += beverages.get(i).calcPrice();
        }
        return total;
    }

    public int findNumOfBeveType(Type type) {
        int count = 0;
        for (int i = 0; i < beverages.size(); i++) {
            if (beverages.get(i).getType() == type) count++;
        }
        return count;
    }

    public int getTotalItems() {
        return beverages.size();
    }

    public int getOrderNo() { return orderNo; }
    public int getOrderTime() { return orderTime; }
    public Day getOrderDay() { return orderDay; }
    public Customer getCustomer() { return new Customer(customer); }

    public String toString() {
        String result = "Order #" + orderNo + " at " + orderTime + " on " + orderDay + "\n";
        result += "Customer: " + customer + "\n";
        for (int i = 0; i < beverages.size(); i++) {
            result += beverages.get(i).toString() + "\n";
        }
        return result;
    }

    public int compareTo(Order other) {
        return Integer.compare(this.orderNo, other.orderNo);
    }
}
