package org.example;

public class MySleep extends Thread {
    public static void main(String[] args) {
        new Thread(new MySleep()).start();
    }
    @Override
    public void run() {
        try {
            for (int x = 0; x < 1000; x++) {
                System.out.println(x);
                sleep(2000);

            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

