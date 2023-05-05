import processing.core.PApplet;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main extends PApplet  {
    public static void main(String[] args) {
        PApplet.main(Main.class);
    }

    boolean state = false;
    WasserstoffGenerator h;
    SauerstoffGenerator o;
    WasserGenerator h2o;
    OzonGenerator o3;

    public void settings(){
        size(720,360);

        h = new WasserstoffGenerator("h");
        o = new SauerstoffGenerator("o");
        h2o = new WasserGenerator("h2o", 10, o, h);
        o3 = new OzonGenerator("o3", 10, o);

    }
    public void setup(){
        textSize(25);
        fill(0);


    }
    public void draw(){
        if (!state) {
            startSys();
            state = true;
        }
        clear();
        background(255);
        text("Anzahl Sauerstoffatome: "  + o.getCount(), 50, 50);
        text("Anzahl Wasserstoffatome: " + h.getCount(), 50, 75);
        text("Anzahl Ozonmoleküle: "     + o3.getCount(), 50, 100);
        text("Anzahl Wassermoleküle: "   + h2o.getCount(), 50, 126);
    }
    public void startSys(){
        h.start();
        o.start();
        h2o.start();
        o3.start();
    }

}

