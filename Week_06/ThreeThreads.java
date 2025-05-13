package Week_06;

public class ThreeThreads extends Thread {
    private int threadNumber;

    public ThreeThreads(int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        for (int i = 0; i < 9; i++) {
            System.out.println("Thread " + threadNumber + ":" + threadNumber + "x" + i + "=" + (threadNumber * i));
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
            }
        }
    }
}
