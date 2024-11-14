

public class Sandwich {

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
}