public class Drink extends Product{
    private String size;
    private String flavor;

    // Constructor for the drink
    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
        setPrice();
    }

    // Set the price based on size
    private void setPrice() {
        if (size.equals("Small")) {
            price = 2.00;
        } else if (size.equals("Medium")) {
            price = 2.50;
        }else if (size.equals("Large")) {
            price = 3.00;
        }
    }

    // Description for the drink
    public String getDescription() {
        return "Drink (" + size + "): " + flavor;
    }
}
