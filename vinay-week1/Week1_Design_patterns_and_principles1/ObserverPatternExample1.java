

import java.util.ArrayList;
import java.util.List;

// Define Subject Interface
interface Stock {
    void registerObserver(Observer o);
    void deregisterObserver(Observer o);
    void notifyObservers();
}

// Define Observer Interface
interface Observer {
    void update(String stockSymbol, double stockPrice);
}

// Implement Concrete Subject
class StockMarket implements Stock {
    private List<Observer> observers;
    private String stockSymbol;
    private double stockPrice;

    public StockMarket() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregisterObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockSymbol, stockPrice);
        }
    }

    public void setStockPrice(String stockSymbol, double stockPrice) {
        this.stockSymbol = stockSymbol;
        this.stockPrice = stockPrice;
        notifyObservers();
    }
}

// Implement Concrete Observers
class MobileApp implements Observer {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(appName + " received stock update: " + stockSymbol + " is now $" + stockPrice);
    }
}

class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockSymbol, double stockPrice) {
        System.out.println(appName + " received stock update: " + stockSymbol + " is now $" + stockPrice);
    }
}

// Test the Observer Implementation
public class ObserverPatternExample1 {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp("MobileApp");
        Observer webApp = new WebApp("