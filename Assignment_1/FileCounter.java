package Assignment_1;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

public class FileCounter {
    public static void main(String[] args) {

        String folderPath = "C:/sem 4/MainThread1/src/main/java/week_07";

        File file = new File(folderPath);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("Invalid folder path!");
            return;
        }

        File[] files = file.listFiles();
        AtomicInteger fileCounter = new AtomicInteger(0);
        AtomicInteger issuesCounter = new AtomicInteger(0);

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File currentFile = files[i];
                if (currentFile.isFile() && currentFile.getName().endsWith(".java")) {
                    fileCounter.incrementAndGet();

                    String name = currentFile.getName();
                    if (name.contains("Solved")) {
                        issuesCounter.incrementAndGet();
                    }
                }
            }
        }
        System.out.println("Number of files: " + fileCounter.get());
        System.out.println("Number of issues: " + issuesCounter.get());
    }
}

