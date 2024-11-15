import java.util.List;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;


public class Order {
    private List<OrderItem> items;

    // Constructor initializes the order with an empty list
    public Order() {
        items = new ArrayList<>();
    }

    // Add an item to the order
    public void addItem(OrderItem item) {
        items.add(item);
    }

    // Calculate the total price of the order
    public double calculateTotal() {
        double total = 0;
        for (OrderItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    // Generate a receipt for the order
    public void generateReceipt() {
        // Ensure the receipts folder exists
        File receiptsFolder = new File("receipts");
        if (!receiptsFolder.exists()) {
            receiptsFolder.mkdir();
        }

        String fileName = new SimpleDateFormat("yyyyMMdd-HHmmss").format(new Date()) + ".txt";
        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("Receipt for Order:\n");
            for (OrderItem item : items) {
                writer.write(item.getDescription());
            }
            writer.write("\nTotal: $" + calculateTotal());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Print the order details to the console
    public void printOrderDetails() {
        for (OrderItem item : items) {
            System.out.println(item.getDescription());
        }
        System.out.println("Total: $" + calculateTotal());
    }
}

