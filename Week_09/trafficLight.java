package Week_09;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class trafficLight {

    public static void main(String[] args) {
        TrafficLightController controller = new TrafficLightController();
        controller.startSystem();
    }
}
class TrafficLightController {

    private final Lock lock = new ReentrantLock();
    private final Condition greenCondition = lock.newCondition();
    private int currentGreen = 0;

    class TrafficLight extends Thread {
        int id;
        String name;

        TrafficLight(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public void run() {
            while (true) {
                lock.lock();
                try {
                    while (currentGreen != id) {
                        try {
                            greenCondition.await();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    System.out.println("[ " + name + " ]: GREEN");
                    Thread.sleep(4000);

                    System.out.println("[ " + name + " ]: YELLOW");
                    Thread.sleep(2000);

                    System.out.println("[ " + name + " ]: RED");

                    currentGreen = (currentGreen + 1) % 4;
                    greenCondition.signalAll();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void startSystem() {
        String[] names = {
                "Junction A (North)",
                "Junction B (East)",
                "Junction C (South)",
                "Junction D (West)"
        };

        for (int i = 0; i < 4; i++) {
            new TrafficLight(i, names[i]).start();
        }
    }
}

