public class MultiThreading {

    public static void main(String[] args){
     for(int i = 0; i < 5; i++) {
      MultiThreadingThings myThing = new MultiThreadingThings(i);
      myThing.start();
     }

 }
}
