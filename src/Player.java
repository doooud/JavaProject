import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Timer;

/**
 * Created by user on 18/05/2017.
 */



public class Player {

    public String name;
    public String color;
    public float posx;
    public float posy;
    public int vie;
    public int rangeBomb = 3;
    private int imageValue = 1;
    public int bombNum;

    public ArrayList<Bomb> bombArray = new ArrayList();
    Timer timer = new Timer();

    public int getBombNum() {
        return bombNum;
    }

    public void setBombNum(int bombNum) {
        this.bombNum = bombNum;
    }

    public int getRangeBomb() {
        return rangeBomb;
    }

    public void setRangeBomb(int rangeBomb) {
        this.rangeBomb = rangeBomb;
    }

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

    public void drawPlayer(String c) {

        if (c == "RED") {
            //StdDraw.setPenColor(StdDraw.RED);

            imageValue ++;

            if(imageValue<=30){
                //System.out.print(imageValue);
                StdDraw.picture(this.posx, this.posy, "image/running-metroid/m"+imageValue+".png", 1.2,1.2);


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

        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledSquare(posx, posy, 0.5);

    }

    public void replacePlayerBomb(){
        StdDraw.setPenColor(StdDraw.GREEN);
        StdDraw.filledSquare(posx, posy, 0.5);
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(posx, posy, 0.20);

    }


    public void movePlayer(String c, GUI g1) {

        if (c == "RED") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 3) {
                            if(g1.getBoard()[(int) getPosx()][(int)getPosy()] == 3){
                                replacePlayerBomb();

                            }
                            else{
                                replacePlayer();
                            }
                            setPosy(getPosy() + 1);
                            drawPlayer(c);
                    }

                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0) { // down
                if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 4){
                            if(g1.getBoard()[(int) getPosx()][(int)getPosy()] == 3){
                                replacePlayerBomb();

                            }
                            else{
                                replacePlayer();
                            }
                            setPosy(getPosy() - 1);
                            drawPlayer(c);

                        }
                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) (getPosx() + 1)][(int) (getPosy())] != 4){
                            if(g1.getBoard()[(int) getPosx()][(int)getPosy()] == 3){
                                replacePlayerBomb();

                            }
                            else{
                                replacePlayer();
                            }
                            setPosx(getPosx() + 1);
                            drawPlayer(c);
                        }
                    }
                }
            } else if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) getPosx() - 1][(int) (getPosy())] != 0) {
                if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 1) {
                    if (StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 3) {
                        if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) (getPosx() - 1)][(int) (getPosy())] != 3){
                            if(g1.getBoard()[(int) getPosx()][(int)getPosy()] == 3){
                                replacePlayerBomb();

                            }
                            else{
                                replacePlayer();
                            }
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

    public int getVie() {
        return vie;
    }

    public void playerBomb(GUI g1){

        int indexBomb;

        if(StdDraw.isKeyPressed(KeyEvent.VK_F) && g1.getBoard()[(int) getPosx()][(int) getPosy()] != 3){
            bombArray.add(new Bomb(getPosx(), getPosy(),0, getRangeBomb()));
            System.out.print("Array size player" + bombArray.size());
            indexBomb = bombArray.size() - 1;
            bombArray.get(indexBomb).putBomb(5, getPosx(), getPosy(), getRangeBomb(), g1, bombArray, 0); //ajouter fonction explosion

        }

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



}