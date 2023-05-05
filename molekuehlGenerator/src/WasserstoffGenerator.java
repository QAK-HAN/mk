import java.util.Random;
import java.util.concurrent.Semaphore;

public class WasserstoffGenerator extends Thread {
    Random randi = new Random();
    String bez;
    int maxDist;
    private int count;
    public static Semaphore wasserstoffSem = new Semaphore(0);
    WasserstoffGenerator(String bez){
        this.bez=bez;
        maxDist = randi.nextInt(100);

    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public void run(){
        while (wasserstoffSem.availablePermits()<10) {
            try {
                wasserstoffSem.release();
                count++;
               // System.out.println(bez + " exists"+" there are "+ count);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

}

