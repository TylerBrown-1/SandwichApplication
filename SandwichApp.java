import java.util.Scanner;

public class SandwichApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to Tyler's Sandwich Stand!");
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (choice == 0) {
                System.out.println("Goodbye!");
                break;
            } else if (choice == 1) {
                Order order = new Order();
                boolean ordering = true;

                while (ordering) {
                    System.out.println("\nOrder Menu:");
                    System.out.println("1) Add Sandwich");
                    System.out.println("2) Add Drink");
                    System.out.println("3) Add Chips");
                    System.out.println("4) Checkout");
                    System.out.println("0) Cancel Order");
                    choice = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    switch (choice) {
                        case 1:
                            order.addItem(createSandwich());
                            break;
                        case 2:
                            order.addItem(createDrink());
                            break;
                        case 3:
                            order.addItem(createChips());
                            break;
                        case 4:
                            order.printOrderDetails();
                            System.out.println("Would you like to confirm the order? (Y/N)");
                            char confirm = scanner.next().charAt(0);
                            if (confirm == 'Y' || confirm == 'y') {
                                order.generateReceipt();
                                System.out.println("Receipt generated and saved to folder !");
                            }
                            ordering = false;
                            break;
                        case 0:
                            System.out.println("Order canceled.");
                            ordering = false;
                            break;
                    }
                }
            }
        }
    }

    // Method to create a sandwich with customization options
    private static Sandwich createSandwich() {
        System.out.println("Choose bread: white, wheat, rye, italian, wrap");
        String bread = scanner.nextLine();
        System.out.println("Choose size: 4\", 8\", 12\"");
        String size = scanner.nextLine();
        Sandwich sandwich = new Sandwich(bread, size);

        // Add toppings menu (meat, cheese, regular toppings, sauces, extra)
        sandwich.addToppingsMenu(scanner);

        // Toasting option
        System.out.println("Do you want the sandwich toasted? (Y/N)");
        if (scanner.nextLine().equalsIgnoreCase("Y")) {
            sandwich.toast();
        }

        return sandwich;
    }
    // Method to create a drink
    private static Drink createDrink() {
        System.out.println("Choose drink size: Small, Medium, Large");
        String size = scanner.nextLine();
        System.out.println("Choose drink flavor: sprite, lemonade, sweet tea, coke, hi-c");
        String flavor = scanner.nextLine();
        return new Drink(size, flavor);
    }
    // Method to create chips
    private static Chips createChips() {
        System.out.println("Choose chip type: regular, sour cream, bbq");
        String type = scanner.nextLine();
        return new Chips(type);
    }
}