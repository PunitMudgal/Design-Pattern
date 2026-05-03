package strategy;

public class Discount {

    interface DiscountStrategy {
        double applyDiscount(double amount);
    }

    static class NoDiscount implements DiscountStrategy {
        public double applyDiscount(double amount) {
            return amount;
        }
    }

    static class PercentageDiscount implements DiscountStrategy {
        private double percentage;

        public PercentageDiscount(double percentage) {
            this.percentage = percentage;
        }

        public double applyDiscount(double amount) {
            return amount - (amount * percentage / 100);
        }
    }

    static class FlatDiscount implements DiscountStrategy {
        private double flatAmount;

        public FlatDiscount(double flatAmount) {
            this.flatAmount = flatAmount;
        }

        public double applyDiscount(double amount) {
            return amount - flatAmount;
        }
    }

    static class FestivalDiscount implements DiscountStrategy {
        public double applyDiscount(double amount) {
            if (amount > 2000) {
                return amount - 100;
            }
            return amount;
        }
    }

    static class DiscountService {
        private DiscountStrategy strategy;

        public DiscountService(DiscountStrategy strategy) {
            this.strategy = strategy;
        }

        public void setStrategy(DiscountStrategy strategy) {
            this.strategy = strategy;
        }

        public void process(double amount) {
            double finalAmount = strategy.applyDiscount(amount);
            System.out.println("Final Amount: " + finalAmount);
        }
    }

    public static void main(String[] args) {

        DiscountService service = new DiscountService(new NoDiscount());
        service.process(5000);

        service.setStrategy(new PercentageDiscount(10));
        service.process(5000);

        service.setStrategy(new FlatDiscount(500));
        service.process(5000);

        service.setStrategy(new FestivalDiscount());
        service.process(1500);
    }
}