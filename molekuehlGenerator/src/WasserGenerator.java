import java.util.Random;
import java.util.concurrent.Semaphore;

public class WasserGenerator extends Thread {
    String bez;
    int myDist;
    private int count;
    Semaphore wasserSem = new Semaphore(0);
    SauerstoffGenerator o;
    WasserstoffGenerator h;
    WasserGenerator(String bez, int myDist, SauerstoffGenerator o, WasserstoffGenerator h){
        this.bez=bez;
        this.myDist = myDist;
        this.o = o;
        this.h = h;
    }
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public void run(){
        while(true) {
            try {
                WasserstoffGenerator.wasserstoffSem.acquire();
                WasserstoffGenerator.wasserstoffSem.acquire();
                SauerstoffGenerator.sauerstoffSem.acquire();
                o.setCount(o.getCount()-1);
                h.setCount(h.getCount()-2);
                wasserSem.release();
                count++;
                //System.out.println(bez+ " exists"+" there are "+ count);
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

}
