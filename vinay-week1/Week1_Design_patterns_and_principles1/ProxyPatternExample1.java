

// Define Subject Interface
interface Image {
    void display();
}

// Implement Real Subject Class
class RealImage implements Image {
    private String fileName;

    public RealImage(String fileName) {
        this.fileName = fileName;
        loadFromRemoteServer(fileName);
    }

    private void loadFromRemoteServer(String fileName) {
        System.out.println("Loading " + fileName + " from remote server...");
        // Simulate loading time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void display() {
        System.out.println("Displaying " + fileName);
    }
}

// Implement Proxy Class
class ProxyImage implements Image {
    private RealImage realImage;
    private String fileName;

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(fileName);
        } else {
            System.out.println("Loading " + fileName + " from cache...");
        }
        realImage.display();
    }
}

// Test the Proxy Implementation
public class ProxyPatternExample1 {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("image1.jpg");
        Image image2 = new ProxyImage("image2.jpg");

        // Load and display image1 for the first time
        image1.display();
        System.out.println();

        // Load and display image2 for the first time
        image2.display();
        System.out.println();

        // Display image1 again, should load from cache
        image1.display();
        System.out.println();

        // Display image2 again, should load from cache
        image2.display();
    }
}