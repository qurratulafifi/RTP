package org.example;

public class MyThreadThread extends Thread{
    public static void main(String[] args) {
        new Thread(new MySleep()).start();
        new Thread(new MySleep()).start();
    }
    @Override
    public void run() {
        try {
            for (int x = 0; x < 10; x++) {
                System.out.println(x);
                sleep(2000);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
     }
    }
