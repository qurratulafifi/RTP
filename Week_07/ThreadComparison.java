package Week_07;

public class ThreadComparison {
    public static void main(String[] args) throws InterruptedException {

        long startNormal = System.nanoTime();
        Thread[] normalThread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            normalThread[i] = new NormalThread();
            normalThread[i].start();
        }
        for (int i = 0; i < 10; i++) {
            normalThread[i].join();
        }
        long endNormal = System.nanoTime();
        double NormalTime = (endNormal - startNormal) / 1000000000.0;
        System.out.printf("Normal Thread : %.8f seconds\n", NormalTime);


        long startSync = System.nanoTime();
        Thread[] syncThread = new Thread[10];
        for (int i = 0; i < 10; i++) {
            syncThread[i] = new SynchronizedThread();
            syncThread[i].start();
        }
        for (int i = 0; i < 10; i++) {
            syncThread[i].join();
        }
        long endSync = System.nanoTime();
        double SyncTime = (endSync - startSync) / 1000000000.0;
        System.out.printf("Synchronized Thread : %.8f seconds\n", SyncTime);
    }
}


