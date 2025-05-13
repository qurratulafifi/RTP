package Week_07;

public class NormalThread extends Thread{
    @Override
    public void run() {
        int count = 0;
        for (int i = 0; i < 100_000; i++) {
            count++;
        }
    }
}
