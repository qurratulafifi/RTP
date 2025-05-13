package Week_07;

import java.util.concurrent.atomic.AtomicInteger; //new modification

public class TestAtomicInteger1p {
    public static void main(String [] args) throws InterruptedException {

        CountProblem pt = new CountProblem();
        Thread t1 = new Thread(pt, "t1");
        Thread t2 = new Thread(pt, "t2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("Count = " + pt.getCount());
    }
}

class CountProblem implements Runnable {

    private AtomicInteger count = new AtomicInteger();//new modification

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++){
            processSomething(i);
            count.incrementAndGet(); //new modification
        }
    }
    public int getCount(){
        return this.count.get();
    }
    private void processSomething(int i) {
        try {
            Thread.sleep(i * 200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
