package strategy;

public class StrategyPattern {

    // 1. Strategy Interface
    interface PaymentStrategy {
        void pay(double amount);
    }

    // 2. Concrete Strategies
    static class CreditCardPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using Credit Card");
        }
    }

    static class UpiPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using UPI");
        }
    }

    static class PaypalPayment implements PaymentStrategy {
        public void pay(double amount) {
            System.out.println("Paid " + amount + " using PayPal");
        }
    }

    // 3. Context Class
    static class PaymentService {

        private PaymentStrategy strategy;

        // Constructor
        public PaymentService(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        // Setter (change strategy at runtime)
        public void setStrategy(PaymentStrategy strategy) {
            this.strategy = strategy;
        }

        public void processPayment(double amount) {
            strategy.pay(amount);
        }
    }

    // 4. Client Code (main)
    public static void main(String[] args) {

        PaymentStrategy strategy = new CreditCardPayment();
        PaymentService service = new PaymentService(strategy);

        service.processPayment(1000);

        service.setStrategy(new UpiPayment());
        service.processPayment(500);

        service.setStrategy(new PaypalPayment());
        service.processPayment(2000);
    }
}
