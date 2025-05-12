public class Smoothie extends Beverage {
    private int numOfFruits;
    private boolean addProtein;
    public static final double PROTEIN_COST = 1.5;
    public static final double FRUIT_COST = 0.5;

    public Smoothie(String name, Size size, int numOfFruits, boolean addProtein) {
        super(name, Type.SMOOTHIE, size);
        this.numOfFruits = numOfFruits;
        this.addProtein = addProtein;
    }

    public double calcPrice() {
        double price = addSizePrice();
        price += numOfFruits * FRUIT_COST;
        if (addProtein) price += PROTEIN_COST;
        return price;
    }

    public String toString() {
        return super.toString() + ", Fruits: " + numOfFruits + ", Protein: " + addProtein + ", Price: $" + calcPrice();
    }

    public boolean equals(Object o) {
        if (!super.equals(o)) return false;
        Smoothie s = (Smoothie) o;
        return numOfFruits == s.numOfFruits && addProtein == s.addProtein;
    }
}