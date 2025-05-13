public class MultiThreadingThings extends Thread {

    private int threadNumber;

    public MultiThreadingThings(int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1000);
            } catch(InterruptedException e){
                }
        }
    }
}
