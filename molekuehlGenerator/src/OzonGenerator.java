import java.util.concurrent.Semaphore;

//splashashley@gmail.com

public class OzonGenerator extends Thread {
    String bez;
    int myDist;
    private int count;
    Semaphore ozonstoffSem = new Semaphore(1);
    SauerstoffGenerator o;
    OzonGenerator(String bez, int myDist, SauerstoffGenerator o){
        this.bez=bez;
        this.myDist = myDist;
        this.o = o;
    }

    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }
    @Override
    public void run() {
        while (true) {
            try {
                SauerstoffGenerator.sauerstoffSem.acquire();
                SauerstoffGenerator.sauerstoffSem.acquire();
                SauerstoffGenerator.sauerstoffSem.acquire();
                o.setCount(o.getCount()-3);
                ozonstoffSem.release();
                count++;

               //System.out.println(bez + " exists"+" there are "+ count);
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


}
