package Week_09;

public class BankAccountMain {
    public static void main(String[] args) {
        BankAccountWithLock account = new BankAccountWithLock(1000);


        Thread reader = new Thread(() -> {
            for (int i = 0; i < 3; i++) {
                account.getBalance();
                try {
                    Thread.sleep(100);
                    } catch (InterruptedException e) {}
            }
        }, "Reader");


        Thread depositor = new Thread(() -> {
            account.deposit(150);
            try {
                Thread.sleep(100);
                } catch (InterruptedException e) {}
                     account.deposit(250);
        }, "Depositor");


        Thread withdrawer = new Thread(() -> {
            account.withdraw(100);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
                account.withdraw(1200);
        }, "Withdrawer");

        reader.start();
        depositor.start();
        withdrawer.start();

        try {
            reader.join();
            depositor.join();
            withdrawer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
