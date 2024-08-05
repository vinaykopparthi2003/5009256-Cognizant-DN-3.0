"5" 

// Define Component Interface
interface Notifier {
    void send(String message);
}

// Implement Concrete Component
class EmailNotifier implements Notifier {
    @Override
    public void send(String message) {
        System.out.println("Sending email notification: " + message);
    }
}

// Implement Decorator Classes

// Abstract Decorator Class
abstract class NotifierDecorator implements Notifier {
    protected Notifier wrappedNotifier;

    public NotifierDecorator(Notifier notifier) {
        this.wrappedNotifier = notifier;
    }

    @Override
    public void send(String message) {
        wrappedNotifier.send(message);
    }
}

// SMS Notifier Decorator
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSMSNotification(message);
    }

    private void sendSMSNotification(String message) {
        System.out.println("Sending SMS notification: " + message);
    }
}

// Slack Notifier Decorator
class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier notifier) {
        super(notifier);
    }

    @Override
    public void send(String message) {
        super.send(message);
        sendSlackNotification(message);
    }

    private void sendSlackNotification(String message) {
        System.out.println("Sending Slack notification: " + message);
    }
}

// Test the Decorator Implementation
public class DecoratorPatternExample1 {
    public static void main(String[] args) {
        // Create the base notifier
        Notifier notifier = new EmailNotifier();

        // Decorate with SMS functionality
        notifier = new SMSNotifierDecorator(notifier);

        // Decorate with Slack functionality
        notifier = new SlackNotifierDecorator(notifier);

        // Send a notification
        notifier.send("Hello, you have a new message!");
    }
}