package Week_06;

public class MainThreeThreads {
    public static void main(String[] args){
        for(int i = 0; i < 3; i++) {
            ThreeThreads three = new ThreeThreads(i);
            three.start();
        }
    }
}
