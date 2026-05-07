package singleton;

import java.util.concurrent.atomic.AtomicInteger;

public class singleton {

    enum Counter {
        INSTANCE;

        private final AtomicInteger count = new AtomicInteger(0);

        public static Counter getInstance() {
            return INSTANCE;
        }

        public void increment() {
            count.incrementAndGet();
        }

        public int getCount() {
            return count.get();
        }
    }

    public class Main {
        public static void main(String[] args) {
            Counter c1 = Counter.getInstance();
            Counter c2 = Counter.getInstance();
            System.out.println("Same instance: " + (c1 == c2));
            for (int i = 0; i < 5; i++) {
                c1.increment();
            }
            System.out.println("Count after 5 increments: " + c1.getCount());
        }
    }
}
