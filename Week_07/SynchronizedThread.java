package Week_07;

public class SynchronizedThread extends Thread{
    private static final Object lock = new Object();

    @Override
    public void run() {
        synchronized (lock) {
            int count = 0;
            for (int i = 0; i < 100_000; i++) {
                count++;
            }
        }
    }
}
