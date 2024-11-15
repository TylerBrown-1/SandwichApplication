

abstract class Product implements OrderItem{
    protected double price;

    // Abstract method for description specific to the product
    public abstract String getDescription();

    // Common method for getting the price
    public double getPrice() {
        return price;
    }
}
