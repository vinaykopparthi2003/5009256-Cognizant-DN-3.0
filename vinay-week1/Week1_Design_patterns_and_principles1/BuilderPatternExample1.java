"3"


// Computer.java
public class Computer {
    // Attributes of the Computer
    private String CPU;
    private String RAM;
    private String storage;
    private String graphicsCard;
    private String motherboard;
    private String powerSupply;
    private String coolingSystem;

    // Private constructor to ensure object creation through Builder
    private Computer(Builder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.graphicsCard = builder.graphicsCard;
        this.motherboard = builder.motherboard;
        this.powerSupply = builder.powerSupply;
        this.coolingSystem = builder.coolingSystem;
    }

    // Static nested Builder class
    public static class Builder {
        private String CPU;
        private String RAM;
        private String storage;
        private String graphicsCard;
        private String motherboard;
        private String powerSupply;
        private String coolingSystem;

        // Setter methods for each attribute
        public Builder setCPU(String CPU) {
            this.CPU = CPU;
            return this;
        }

        public Builder setRAM(String RAM) {
            this.RAM = RAM;
            return this;
        }

        public Builder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder setGraphicsCard(String graphicsCard) {
            this.graphicsCard = graphicsCard;
            return this;
        }

        public Builder setMotherboard(String motherboard) {
            this.motherboard = motherboard;
            return this;
        }

        public Builder setPowerSupply(String powerSupply) {
            this.powerSupply = powerSupply;
            return this;
        }

        public Builder setCoolingSystem(String coolingSystem) {
            this.coolingSystem = coolingSystem;
            return this;
        }

        // Build method to create an instance of Computer
        public Computer build() {
            return new Computer(this);
        }
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", storage=" + storage +
               ", graphicsCard=" + graphicsCard + ", motherboard=" + motherboard +
               ", powerSupply=" + powerSupply + ", coolingSystem=" + coolingSystem + "]";
    }
}

// Test class to demonstrate the Builder Pattern
public class BuilderPatternExample1 {
    public static void main(String[] args) {
        // Creating different configurations of Computer using the Builder pattern

        Computer gamingPC = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 3080")
                .setMotherboard("ASUS ROG")
                .setPowerSupply("750W")
                .setCoolingSystem("Liquid Cooling")
                .build();

        Computer officePC = new Computer.Builder()
                .setCPU("Intel i5")
                .setRAM("16GB")
                .setStorage("512GB SSD")
                .setMotherboard("MSI Pro")
                .setPowerSupply("550W")
                .build();

        Computer budgetPC = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("8GB")
                .setStorage("256GB SSD")
                .setMotherboard("Gigabyte Basic")
                .setPowerSupply("450W")
                .build();

        // Display the configurations
        System.out.println(gamingPC);
        System.out.println(officePC);
        System.out.println(budgetPC);
    }
}