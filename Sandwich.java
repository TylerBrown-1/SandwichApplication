import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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
    // Method to display and add toppings to the sandwich (including premium toppings and extras)
    public void addToppingsMenu(Scanner scanner) {
        // Add meat toppings
        System.out.println("Select meat: steak, ham, salami, roast beef, chicken, bacon");
        String meat = scanner.nextLine();
        if (isValidMeat(meat)) {
            addTopping(new Topping(meat, getMeatPrice(meat), "meat"));
        }

        // Add extra meat if needed
        System.out.println("Would you like to add extra meat? (Y/N)");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            addTopping(new Topping(meat, getExtraMeatPrice(meat), "extra meat"));
        }

        // Add cheese toppings
        System.out.println("Select cheese topping: american, provolone, cheddar, provolone, swiss");
        String cheese = scanner.nextLine();
        if (isValidCheese(cheese)) {
            addTopping(new Topping(cheese, getCheesePrice(cheese), "cheese"));
        }

        // Add extra cheese if needed
        System.out.println("Would you like to add extra cheese? (Y/N)");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            addTopping(new Topping(cheese, getExtraCheesePrice(cheese), "extra cheese"));
        }

        // Add regular toppings
        String[] regularToppings = {"lettuce", "peppers", "onions", "tomatoes", "jalapenos", "cucumbers", "pickles", "guacamole", "mushrooms"};
        for (String topping : regularToppings) {
            System.out.println("Would you like to add " + topping + "? (Y/N)");
            if (scanner.nextLine().equalsIgnoreCase("Y")) {
                addTopping(new Topping(topping, 0.0, "regular topping"));
            }
        }

        // Add sauces (mayo, mustard, ketchup, etc.)
        String[] sauces = {"mayo", "mustard", "ketchup", "ranch", "thousand island", "vinaigrette"};
        System.out.println("Select sauces: mayo, mustard, ketchup, ranch, thousand island" +
                " (comma-separated, no spaces):");
        String sauceChoice = scanner.nextLine();
        for (String sauce : sauces) {
            if (sauceChoice.contains(sauce)) {
                addTopping(new Topping(sauce, 0.0, "sauce"));
            }
        }
    }

    private boolean isValidMeat(String meat) {
        return meat.equals("steak") || meat.equals("ham") || meat.equals("salami") || meat.equals("roast beef") || meat.equals("chicken") || meat.equals("bacon");
    }

    private boolean isValidCheese(String cheese) {
        return cheese.equals("american") || cheese.equals("provolone") || cheese.equals("cheddar") || cheese.equals("swiss");
    }

    private double getMeatPrice(String meat) {
        switch (meat) {
            case "steak":
                return 1.00;
            case "ham":
                return 2.00;
            case "salami":
                return 3.00;
            case "roast beef":
                return 1.50;
            case "chicken":
                return 1.25;
            case "bacon":
                return 2.00;
            default:
                return 0.0;
        }
    }

    private double getExtraMeatPrice(String meat) {
        switch (meat) {
            case "steak":
                return 0.50;
            case "ham":
                return 1.00;
            case "salami":
                return 1.50;
            case "roast beef":
                return 0.75;
            case "chicken":
                return 0.50;
            case "bacon":
                return 1.00;
            default:
                return 0.0;
        }
    }

    private double getCheesePrice(String cheese) {
        switch (cheese) {
            case "american":
                return 0.75;
            case "provolone":
                return 1.50;
            case "cheddar":
                return 2.25;
            case "swiss":
                return 2.00;
            default:
                return 0.0;
        }
    }

    private double getExtraCheesePrice(String cheese) {
        switch (cheese) {
            case "american":
                return 0.30;
            case "provolone":
                return 0.60;
            case "cheddar":
                return 0.90;
            case "swiss":
                return 0.60;
            default:
                return 0.0;
        }
    }
}