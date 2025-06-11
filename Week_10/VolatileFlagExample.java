package Week_10;

public class VolatileFlagExample {
    private static volatile boolean running =  true;

    public static void main(String [] args) {
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started...");
            while (running) {
            }
            System.out.println("Worker thread stopped.");
        });
        worker.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("Main thread stopping worker...");
        running = false;

    }
}
