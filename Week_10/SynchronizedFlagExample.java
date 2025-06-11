package Week_10;

public class SynchronizedFlagExample {

    private static boolean running =  true;

    private static synchronized boolean isRunning(){
        return running;
    }

    private static void stopRunning(){
        running = false;
    }

    public static void main(String [] args) {
        Thread worker = new Thread(() -> {
            System.out.println("Worker thread started...");
            while (isRunning()) {
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
