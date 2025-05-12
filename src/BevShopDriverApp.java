/* 

 * Class: CMSC203  

 * Instructor: Monshi

 * Description: Create a beverage shop app using emun and interfaces 

 * Due: 05/12/25

 * Platform/compiler: VS CODE

 * I pledge that I have completed the programming   

 * assignment independently. I have not copied the code  

 * from a student or any source. I have not given my code  

 * to any student. 

   Print your Name here: Salma Baig 

*/ 

 
public class BevShopDriverApp {
    public static void main(String[] args) {
        BevShop shop = new BevShop();
        shop.startNewOrder(9, Day.MONDAY, "John", 23);

        System.out.println("Start a new order...");
        System.out.println("Your Total Order for now is " + shop.getCurrentOrder().calcOrderTotal());

        shop.processAlcoholOrder("Beer", Size.SMALL);
        System.out.println("Total now: " + shop.getCurrentOrder().calcOrderTotal());

        shop.processAlcoholOrder("Wine", Size.MEDIUM);
        shop.processAlcoholOrder("Whiskey", Size.LARGE);

        shop.processCoffeeOrder("Latte", Size.LARGE, true, true);

        System.out.println("Current Order:");
        System.out.println(shop.getCurrentOrder());

        shop.startNewOrder(10, Day.SUNDAY, "Amy", 18);
        shop.processSmoothieOrder("Berry Blast", Size.LARGE, 5, true);
        shop.processCoffeeOrder("Espresso", Size.SMALL, false, true);
        shop.processAlcoholOrder("Vodka", Size.SMALL); // won't add since underage

        System.out.println("Second Order:");
        System.out.println(shop.getCurrentOrder());

        System.out.println("Total Monthly Sale: " + shop.totalMonthlySale());
    }
}
