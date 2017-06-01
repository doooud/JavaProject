import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;

/**
 * Created by user on 18/05/2017.
 */


public class Bomb{


    public String color;
    public float posx;
    public float posy;

    public Bomb(String c,float x, float y) { // c pour la couleur permettant d'identifier la personne posant la bombe

        this.color = c;

        if (color == "RED") {
            this.posx = x;
            this.posy = y;
        } else {
            this.posx = x;
            this.posy = y;
        }

    }
/*
    public void putBomb(){
        if(StdDraw.isKeyPressed(KeyEvent.VK_SHIFT)){
            StdDraw.filledCircle(this.posx, this.posy, 0.35);
        }

    }


    public static void bombTime(){
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                System.out.print("Hey");

            }
        }, 3*1000); // millisecondes


    }
*/
}


