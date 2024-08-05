import java.util.Arrays;

class Product {
    private int productId;
    private String productName;
    private String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

class SearchAlgorithms {

    // Linear Search
    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null; // Product not found
    }

    // Binary Search
    public static Product binarySearch(Product[] products, int productId) {
        int low = 0;
        int high = products.length - 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (products[mid].getProductId() == productId) {
                return products[mid];
            } else if (products[mid].getProductId() < productId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null; // Product not found
    }
}

public class ECommerceSearchDemo {

    public static void main(String[] args) {
        // Create an array of Product objects
        Product[] products = {
            new Product(1, "Laptop", "Electronics"),
            new Product(2, "Headphones", "Accessories"),
            new Product(3, "Coffee Maker", "Home Appliances"),
            new Product(4, "Smartphone", "Electronics"),
            new Product(5, "Blender", "Home Appliances")
        };

        // Sort products by productId for binary search
        Arrays.sort(products, (p1, p2) -> Integer.compare(p1.getProductId(), p2.getProductId()));

        // Search using Linear Search
        System.out.println("Searching using Linear Search:");
        Product linearResult = SearchAlgorithms.linearSearch(products, 3);
        System.out.println(linearResult != null ? linearResult : "Product not found");

        // Search using Binary Search
        System.out.println("\nSearching using Binary Search:");
        Product binaryResult = SearchAlgorithms.binarySearch(products, 3);
        System.out.println(binaryResult != null ? binaryResult : "Product not found");
    }
}
