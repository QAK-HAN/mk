import java.util.Random;
import java.util.concurrent.Semaphore;

public class SauerstoffGenerator extends Thread {
    Random randi = new Random();
    String bez;
    int maxDist;
    private int count;
    public static Semaphore sauerstoffSem = new Semaphore(0);
    SauerstoffGenerator(String bez){
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
        while (sauerstoffSem.availablePermits()<10) {
            try {
                sauerstoffSem.release();
                //System.out.println(bez + " exists"+" there are "+  count);
                count++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

