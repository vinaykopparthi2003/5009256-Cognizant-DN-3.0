import java.util.Arrays;
import java.util.Comparator;

class Order {
    private int orderId;
    private String customerName;
    private double totalPrice;

    public Order(int orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerName='" + customerName + '\'' +
                ", totalPrice=" + totalPrice +
                '}';
    }
}

class SortingAlgorithms {

    // Bubble Sort
    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].getTotalPrice() > orders[j + 1].getTotalPrice()) {
                    // Swap orders[j] and orders[j + 1]
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    // Quick Sort
    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    private static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].getTotalPrice();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (orders[j].getTotalPrice() <= pivot) {
                i++;
                // Swap orders[i] and orders[j]
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        // Swap orders[i + 1] and orders[high] (or pivot)
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}

public class SortingCustomerOrdersDemo {

    public static void main(String[] args) {
        // Create an array of Order objects
        Order[] orders = {
            new Order(1, "Alice", 250.0),
            new Order(2, "Bob", 150.0),
            new Order(3, "Charlie", 300.0),
            new Order(4, "David", 200.0),
            new Order(5, "Eve", 100.0)
        };

        // Copy array for bubble sort
        Order[] ordersForBubbleSort = Arrays.copyOf(orders, orders.length);
        Order[] ordersForQuickSort = Arrays.copyOf(orders, orders.length);

        // Sort using Bubble Sort
        SortingAlgorithms.bubbleSort(ordersForBubbleSort);
        System.out.println("Orders Sorted by Bubble Sort:");
        for (Order order : ordersForBubbleSort) {
            System.out.println(order);
        }

        // Sort using Quick Sort
        SortingAlgorithms.quickSort(ordersForQuickSort, 0, ordersForQuickSort.length - 1);
        System.out.println("\nOrders Sorted by Quick Sort:");
        for (Order order : ordersForQuickSort) {
            System.out.println(order);
        }
    }
}
