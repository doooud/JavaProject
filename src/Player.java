import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by user on 18/05/2017.
 */



public class Player {

    public String name;
    public String color;
    public float posx;
    public float posy;


    public Player(String n, String c, float x, float y) {

        this.name = n;
        this.color = c;
        this.posx = x;
        this.posy = y;


        if (c == "RED") {
            this.posx = 1.5f;
            this.posy = 1.5f;
        } else {
            this.posx = 19.5f;
            this.posy = 15.5f;
        }


    }

    public float getPosx() {
        return posx;
    }

    public void setPosx(float x) {
        this.posx = x;
    }

    public float getPosy() {
        return posy;
    }

    public void setPosy(float y) {
        this.posy = y;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String c) {
        this.color = color;
    }

    public void drawPlayer(String c) {

        if (c == "RED") {
            /*StdDraw.setPenColor(StdDraw.RED);*/

            double posx = 1;
            double posy = 1;
            double xi = 1;
            double yi = 1;
            StdDraw.picture(this.posx,this.posy,"images/Metroid_Samus_Boule.png", xi, yi );
        } else if (c == "BLUE") {
            StdDraw.setPenColor(StdDraw.BLUE);
        }

        /*StdDraw.filledCircle(this.posx, this.posy, 0.45);*/
    }

    public void replacePlayer(){
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledSquare(getPosx(), getPosy(), 0.5);
    }

    public void movePlayer(String c) {

        drawPlayer(c);
        GUI g1 = new GUI();
        // rajouter condition si 1 alors blogué aussi

        if (c == "RED") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0) {
                replacePlayer();
                setPosy(getPosy() + 1);
                drawPlayer(c);

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0) {
                replacePlayer();
                setPosy(getPosy() - 1);
                drawPlayer(c);

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) getPosx() + 1][(int) (getPosy())] != 0) {
                replacePlayer();
                setPosx(getPosx() + 1);
                drawPlayer(c);
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) getPosx() - 1][(int) (getPosy())] != 0) {
                replacePlayer();
                setPosx(getPosx() - 1);
                drawPlayer(c);
            }
        } else if (c == "BLUE") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_Z) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0) {
                replacePlayer();
                setPosy(getPosy() + 1);
                drawPlayer(c);

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_S) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0) {
                replacePlayer();
                setPosy(getPosy() - 1);
                drawPlayer(c);

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_D) && g1.getBoard()[(int) getPosx() + 1][(int) (getPosy())] != 0) {
                replacePlayer();
                setPosx(getPosx() + 1);
                drawPlayer(c);

            } else if (StdDraw.isKeyPressed(KeyEvent.VK_Q) && g1.getBoard()[(int) getPosx() - 1][(int) (getPosy())] != 0) {
                replacePlayer();
                setPosx(getPosx() - 1);
                drawPlayer(c);

            }
        }

    }

    public void putBomb(){
            StdDraw.setPenColor(StdDraw.BLACK);
            StdDraw.filledCircle(getPosx(), getPosy(), 0.20);
    }

    public void bombPlayer(String c) {

        // rajouter condition si orange alors blogué aussi

            if (c == "RED") {
                if (StdDraw.isKeyPressed(KeyEvent.VK_F)){ //rajouter condition stack de bombe
                    putBomb();
                }
            }
            else if (c == "BLUE") {
                if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE) ) {
                    putBomb();
                }
            }

    }
}