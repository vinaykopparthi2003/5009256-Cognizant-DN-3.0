

// Define Repository Interface
interface CustomerRepository {
    Customer findCustomerById(String id);
}

// Implement Concrete Repository
class CustomerRepositoryImpl implements CustomerRepository {
    @Override
    public Customer findCustomerById(String id) {
        // Simulate finding a customer in a database
        return new Customer(id, "John Doe");
    }
}

// Define Model Class
class Customer {
    private String id;
    private String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Customer{id='" + id + "', name='" + name + "'}";
    }
}

// Define Service Class
class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor Injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomerById(String id) {
        return customerRepository.findCustomerById(id);
    }
}

// Test the Dependency Injection Implementation
public class DependencyInjectionExample1 {
    public static void main(String[] args) {
        // Create a CustomerRepositoryImpl instance
        CustomerRepository customerRepository = new CustomerRepositoryImpl();

        // Inject the repository into CustomerService using constructor injection
        CustomerService customerService = new CustomerService(customerRepository);

        // Use the service to find a customer
        Customer customer = customerService.getCustomerById("12345");

        // Print the customer details
        System.out.println(customer);
    }
}