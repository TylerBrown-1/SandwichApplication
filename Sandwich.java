

public class Sandwich extends Product {

    private String breadType;
    private String size;
    private List<Topping> toppings;
    private boolean isToasted;

    // Constructor to create a new sandwich
    public Sandwich(String breadType, String size) {
        this.breadType = breadType;
        this.size = size;
        this.toppings = new ArrayList<>();
        this.isToasted = false;
        setPrice();
    }
    // Adds a topping to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
        setPrice(); // Recalculate price based on added topping
    }

    // Set the price based on size and toppings
    private void setPrice() {
        switch (size) {
            case "4\"":
                price = 5.50;
                break;
            case "8\"":
                price = 7.00;
                break;
            case "12\"":
                price = 8.50;
                break;
        }
        for (Topping topping : toppings) {
            price += topping.getPrice();
        }
    }
    public String getDescription() {
        StringBuilder description = new StringBuilder();
        description.append("Sandwich (" + size + "): " + breadType + " bread\n");
        for (Topping topping : toppings) {
            description.append("- " + topping.getDescription() + "\n");
        }
        if (isToasted) {
            description.append("Toasted\n");
        }
        return description.toString();
    }

    // Method to toast the sandwich
    public void toast() {
        isToasted = true;
    }
}
