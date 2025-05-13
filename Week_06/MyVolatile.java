package Week_06;

import java.io.IOException;

class MyThread2 extends Thread {
    private volatile boolean running = true;

    public void run() {
        while (running) {
            System.out.println("HAVE A NICE DAY!"
            );
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
        public void shutdown() {
            running = false;
        }
    }

    public class MyVolatile {
        public static void main(String[] args) throws IOException {

            MyThread2 t = new MyThread2();
            t.start();
            System.out.println("Press ENTER to stop the thread...");
            System.in.read();
            t.shutdown();
        }
    }

