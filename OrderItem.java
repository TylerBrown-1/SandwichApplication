 // interface ensures that all items in an order can calculate their cost and give a description
   public interface OrderItem {
        double getPrice();
        String getDescription();
    }
