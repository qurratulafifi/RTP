package Assignment_1;

import java.io.File;

public class FileCounter {
    public static void main(String[] args) {

        String folderPath = "C:/sem 4/MainThread1/src/main/java/week_07";

        File file = new File(folderPath);
        if (!file.exists() || !file.isDirectory()) {
            System.out.println("invalid folder path!");
            return;
        }

        File[] files = file.listFiles();
        int fileCounter = 0;
        int issuesCounter = 0;

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File currentFile = files[i];
                if (currentFile.isFile() && currentFile.getName().endsWith(".java")) {
                    fileCounter++;
                    String name = currentFile.getName();
                    if (name.contains("Solved")){
                        issuesCounter++;
                    }
                }
            }
        }

        System.out.println("Number of files: " + fileCounter);
        System.out.println("Number of issues: " + issuesCounter);

    }
}
