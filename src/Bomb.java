import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 18/05/2017.
 */
public class Bomb {


    public String color;
    public float posx;
    public float posy;

    public Bomb(String c) {

        this.color = c;

        if (color == "RED") {
            this.posx = 1.5f;
            this.posy = 1.5f;
        } else {
            this.posx = 19.5f;
            this.posy = 15.5f;
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
    }

}
