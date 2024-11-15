import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

    // interface ensures that all items in an order can calculate their cost and give a description
   public interface OrderItem {
        double getPrice();
        String getDescription();
    }


