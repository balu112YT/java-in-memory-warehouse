package manager;

import model.Product;
import java.util.*;
import java.util.stream.Collectors;

public class WarehouseManager {

    // In-memory storage and index for O(1) lookups
    private List<Product> products;
    private Map<String, Product> idIndex;

    public WarehouseManager() {
        this.products = new ArrayList<>();
        this.idIndex = new HashMap<>();
    }

    // Load a collection of products into memory
    public void loadProducts(List<Product> newProducts) {
        this.products.clear();
        this.idIndex.clear();
        for (Product p : newProducts) {
            addProduct(p);
        }
    }

    // Add a single product and update the index
    public void addProduct(Product p) {
        products.add(p);
        idIndex.put(p.getId(), p);
    }

    // Fast O(1) lookup by product ID
    public Product findById(String id) {
        return idIndex.get(id);
    }

    // Sort products alphabetically by name
    public List<Product> sortByName() {
        return products.stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    // Sort products by price (ascending or descending)
    public List<Product> sortByPrice(boolean ascending) {
        Comparator<Product> comparator = Comparator.comparing(Product::getPrice);
        if (!ascending) {
            comparator = comparator.reversed();
        }
        return products.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }

    public List<Product> getAllProducts() {
        return products;
    }
}