public class Topping implements OrderItem{
        private String name;
        private double price;
        private String type; // "meat", "cheese", "sauce" or "regular"

        public Topping(String name, double price, String type) {
            this.name = name;
            this.price = price;
            this.type = type;
        }

        // Return the description of the topping
        public String getDescription() {
            return name + " (" + type + ")";
        }

        // Return the price of the topping
        public double getPrice() {
            return price;
        }
    }

