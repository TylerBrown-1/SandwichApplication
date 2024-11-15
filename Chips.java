public class Chips extends Product{
    private String type;

    // Constructor for chips
    public Chips(String type) {
        this.type = type;
        price = 1.50; // Default price for chips
    }

    // Description for the chips
    public String getDescription() {
        return "Chips: " + type;
    }
}
