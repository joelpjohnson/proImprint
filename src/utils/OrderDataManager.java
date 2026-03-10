package utils;

import java.io.*;

public class OrderDataManager {

    private static final String FILE_PATH = "order.txt";

    public static void saveOrderId(String orderId) {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            writer.write(orderId);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getOrderId() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}