import edu.princeton.cs.introcs.StdDraw;

import java.util.Timer;

/**
 * Created by user on 05/06/2017.
 */
public class Bomberman {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(21 * 50, 17 * 50);
        StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
        StdDraw.enableDoubleBuffering();


        Player p1 = new Player("p1", "RED", 0, 0, 3);
        Player p2 = new Player("p2", "BLUE", 0, 0, 3);

        GUI g1 = new GUI();




        while(true){
            StdDraw.clear();
            g1.generate();
            g1.guiCheckBomb();
            p2.movePlayer(p2.color, g1);
            p1.movePlayer(p1.color, g1);
            p1.drawPlayer(p1.color);
            p2.drawPlayer(p2.color);
            p1.playerBomb(g1);
            StdDraw.show(60);


        }
    }



}
