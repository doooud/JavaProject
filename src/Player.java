import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.security.Key;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 18/05/2017.
 */



public class Player {

    public String name;
    public String color;
    public float posx;
    public float posy;

    public int vie;
    private int pressCount = 0;
    private int imageValue = 1;




    public Player(String n, String c, float x, float y, int life) {

        this.name = n;
        this.color = c;
        this.posx = x;
        this.posy = y;
        this.vie = life;

        if (c == "RED") {
            this.posx = 1.5f;
            this.posy = 1.5f;
        } else {
            this.posx = 19.5f;
            this.posy = 15.5f;
        }


    }
    public int getVie() {
        return vie;
    }

    public void setVie(int vie) {
        this.vie = vie;
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
            //StdDraw.setPenColor(StdDraw.RED);

            imageValue ++;

            if(imageValue<=30){
                StdDraw.picture(this.posx, this.posy, "image/running-metroid/m"+imageValue+".png", 1.2,1.2);
                //System.out.print(imageValue);

            }
            else{
                imageValue = 1;
            }
        }
        else if (c == "BLUE") {

            imageValue ++;

            if(imageValue<=12){
                StdDraw.picture(this.posx, this.posy, "image/vilain-metroid/v"+imageValue+".png", 1,1);
                //System.out.print(imageValue);

            }
            else{
                imageValue = 1;
            }
        }

        //StdDraw.filledCircle(this.posx, this.posy, 0.45);
    }


    public void replacePlayer() {
        //StdDraw.setPenColor(StdDraw.GREEN);
        //StdDraw.filledSquare(getPosx(), getPosy(), 0.5);
    }

    public void movePlayer(String c, GUI g1) {

        if (c == "RED") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 4){
                            replacePlayer();
                            setPosy(getPosy() + 1);
                            drawPlayer(c);
                        }
                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0) { // down
                if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 4){
                            replacePlayer();
                            setPosy(getPosy() - 1);
                            drawPlayer(c);
                        }
                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 4){
                            replacePlayer();
                            setPosx(getPosx() + 1);
                            drawPlayer(c);
                        }
                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) getPosx() - 1][(int) (getPosy())] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 3){
                            replacePlayer();
                            setPosx(getPosx() - 1);
                            drawPlayer(c);
                        }


                    }
                }
            }
        } else if (c == "BLUE") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_Z) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_Z) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_Z) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 3) {
                        replacePlayer();
                        setPosy(getPosy() + 1);
                        drawPlayer(c);

                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_S) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0) { // down
                if (StdDraw.isKeyPressed(KeyEvent.VK_S) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_S) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 3) {
                        replacePlayer();
                        setPosy(getPosy() - 1);
                        drawPlayer(c);

                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_D) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_D) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_D) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 3) {
                        replacePlayer();
                        setPosx(getPosx() + 1);
                        drawPlayer(c);

                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_Q) && g1.getBoard()[(int) getPosx() - 1][(int) (getPosy())] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_Q) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_Q) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 3) {
                        replacePlayer();
                        setPosx(getPosx() - 1);
                        drawPlayer(c);

                    }
                }
            }
        }
    }


    public void putBomb() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(getPosx(), getPosy(), 0.20);
    }

    public int getValue(int valPosx, int valPosy, int [][] board){
            int value;
            value = board[valPosx][valPosy];
            return value;
    }


}