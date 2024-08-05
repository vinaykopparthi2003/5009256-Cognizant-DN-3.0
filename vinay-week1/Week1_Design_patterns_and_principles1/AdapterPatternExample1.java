"4"

// Define Target Interface
interface PaymentProcessor {
    void processPayment(double amount);
}

// Implement Adaptee Classes

// PayPal payment gateway with its own method
class PayPal {
    public void sendPayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

// Stripe payment gateway with its own method
class Stripe {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

// Square payment gateway with its own method
class Square {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Square.");
    }
}

// Implement the Adapter Class

// PayPal Adapter
class PayPalAdapter implements PaymentProcessor {
    private PayPal payPal;

    public PayPalAdapter(PayPal payPal) {
        this.payPal = payPal;
    }

    @Override
    public void processPayment(double amount) {
        payPal.sendPayment(amount);
    }
}

// Stripe Adapter
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.makePayment(amount);
    }
}

// Square Adapter
class SquareAdapter implements PaymentProcessor {
    private Square square;

    public SquareAdapter(Square square) {
        this.square = square;
    }

    @Override
    public void processPayment(double amount) {
        square.pay(amount);
    }
}

// Test the Adapter Implementation
public class AdapterPatternExample1 {
    public static void main(String[] args) {
        // Creating instances of the adaptees
        PayPal payPal = new PayPal();
        Stripe stripe = new Stripe();
        Square square = new Square();

        // Creating adapters for each payment gateway
        PaymentProcessor payPalProcessor = new PayPalAdapter(payPal);
        PaymentProcessor stripeProcessor = new StripeAdapter(stripe);
        PaymentProcessor squareProcessor = new SquareAdapter(square);

        // Processing payments using the adapters
        payPalProcessor.processPayment(100.00);
        stripeProcessor.processPayment(200.00);
        squareProcessor.processPayment(300.00);
    }
}