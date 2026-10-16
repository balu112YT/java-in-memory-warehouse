package loader;

import model.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomDataLoader {

    private static final String[] CATEGORIES = {"Laptop", "Phone", "Monitor", "Keyboard", "Mouse", "Headset"};

    // Generate a list of random products for stress testing
    public static List<Product> generateRandomProducts(int count) {
        List<Product> products = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            String id = "RND-" + String.format("%04d", i);
            String name = CATEGORIES[random.nextInt(CATEGORIES.length)] + " Model-" + i;
            double price = 5000 + (500000 - 5000) * random.nextDouble();
            int quantity = random.nextInt(100) + 1;

            products.add(new Product(id, name, Math.round(price * 100.0) / 100.0, quantity));
        }

        return products;
    }
}