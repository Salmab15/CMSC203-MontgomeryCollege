public abstract class Beverage {
    private String name;
    private Type type;
    private Size size;
    public static final double BASE_PRICE = 2.0;
    public static final double SIZE_PRICE = 0.5;

    public Beverage(String name, Type type, Size size) {
        this.name = name;
        this.type = type;
        this.size = size;
    }

    public double addSizePrice() {
        switch (size) {
            case MEDIUM: return BASE_PRICE + SIZE_PRICE;
            case LARGE: return BASE_PRICE + 2 * SIZE_PRICE;
            default: return BASE_PRICE;
        }
    }

    public abstract double calcPrice();

    public String toString() {
        return name + ", " + size;
    }

    public boolean equals(Object o) {
        if (o instanceof Beverage) {
            Beverage other = (Beverage) o;
            return name.equals(other.name) && type == other.type && size == other.size;
        }
        return false;
    }

    public String getName() { 
        return name; 
    }
    public Type getType() { 
        return type; 
    }
    public Size getSize() { 
        return size; 
    }
}
