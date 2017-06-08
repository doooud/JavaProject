import edu.princeton.cs.introcs.StdDraw;
import org.omg.CORBA.TIMEOUT;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
/**
 * Created by user on 18/05/2017.
 */


public class Bomb {

    public float posx;
    public float posy;
    public int pressCount;
    public int bombId;
    public int range;
    public int bombTime;
    public Player player;

    Timer timer = new Timer();

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public int getBombId() {
        return bombId;
    }

    public void setBombId(int bombId) {
        this.bombId = bombId;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getBombTime() {
        return bombTime;
    }

    public void setBombTime(int bombTime) {
        this.bombTime = bombTime;
    }

    public int getPressCount() {
        return pressCount;
    }

    public void setPressCount(int pressCount) {
        this.pressCount = pressCount;
    }

    public float getPosx() {
        return posx;
    }

    public void setPosx(float posx) {
        this.posx = posx;
    }

    public float getPosy() {
        return posy;
    }

    public void setPosy(float posy) {
        this.posy = posy;
    }

    public Bomb(float x, float y, int bombT, int rangeBomb) { // c pour la couleur permettant d'identifier la personne posant la bombe

        this.posx = x;
        this.posy = y;
        this.bombTime = bombT;
        this.range = rangeBomb;

    }

    public void putBomb(int bTime, float x, float y, int range, GUI g1, ArrayList<Bomb> bombArray, int laps){
        int i,j;
        setBombTime(bTime);
/*
        for( i = 0; i <= g1.getTransBoard().length - 1; i++) {
            for ( j = 0; j <= g1.getTransBoard()[1].length - 1; j++) {
                System.out.print(g1.getTransBoard()[i][j]);

            }
            System.out.println("");
        }
*/
        this.setRange(range);
        this.setPosx(x);
        this.setPosy(y);
        this.rangeBomb(g1, bombArray, laps);
    }



    public void rangeBomb(GUI g1, ArrayList<Bomb> bombArray, int laps){
        int i;
        int [][] g3;

        g3 = g1.getTransBoard(); //matrice d'avance
        //incrémentation sur l'axe de x positif donc vers la droite
        System.out.print("ArraySize range :"+bombArray.size());
        for (i = 0; i <= this.getRange(); i++) {

            if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 0) {
                break;
            }

            else if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 2) {
                g3[(int) getPosx() + i][(int) getPosy()] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx() + i, getPosy(), bombArray);

            }

            else if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 1) {
                g3[(int) getPosx() + i][(int) getPosy()] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx() + i, getPosy(), bombArray);
                break;
            }

        }

        for (i = 0; i <= getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 0) {
                break;
            }
            else if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 2) {
                g3[(int) getPosx() - i][(int) getPosy()] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx() - i, getPosy(), bombArray);
            }
            else if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 1) {
                g3[(int) getPosx() - i][(int) getPosy()] = 2;
                g1.setTransBoard(g3);

                exploBomb(g1,getPosx() - i, getPosy(), bombArray);
                break;
            }
        }

        for (i = 0; i <= getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()+i] == 0) {
                break;
            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy() + i] == 2) {
                g3[(int) getPosx()][(int) getPosy()+i] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx(), getPosy()+i, bombArray);


            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy() + i] == 1) {
                g3[(int) getPosx()][(int) getPosy()+i] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx(), getPosy()+i, bombArray);
                break;
            }
        }

        for (i = 0; i <= getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()-i] == 0) {

                break;
            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()-i] == 2) {
                g3[(int) getPosx()][(int) getPosy()-i] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx(), getPosy()-i, bombArray);
            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()-i] == 1) {
                g3[(int) getPosx()][(int) getPosy()-i] = 2;
                g1.setTransBoard(g3);
                exploBomb(g1,getPosx(), getPosy()-i, bombArray);
                break;
            }
        }
    }

    public void exploBomb( GUI g1,  float x, float y, ArrayList<Bomb> bombArray){

        int [][] g2;
        g2 = g1.getBoard();
        g2[(int) getPosx()][(int) getPosy()] = 3;
        g1.setBoard(g2);


        getTimer().schedule(new TimerTask() {
            public void run() {
                afterTimer(g2, x, y, g1, bombArray);
            }
        }, getBombTime() * 1000);  // millisecondes


    }


    public void explodeChain(GUI g1, ArrayList<Bomb> bombArray){
        int j,i;
        for (i = 0; i <= this.getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 0) {
                break;

            } else if (g1.getBoard()[(int) getPosx() + i][(int) getPosy()] == 3) {
                for (j = 0; j <= bombArray.size() - 1; j++) {
                    if(bombArray.get(j).getPosx() == getPosx() + i  && bombArray.get(j).getPosy() == getPosy()) {
                        /*bombArray.get(j).getTimer().cancel();
                        bombArray.add(j, new Bomb(getPosy()+i, getPosy(), 0, getRange()));
                        bombArray.get(j).putBomb(0,getPosx()+i, getPosy(), getRange(), g1, bombArray);
                           */
                        bombArray.get(j).getTimer().cancel();


                    }
                }

            }
        }
    }

    public void afterTimer(int [][] g2, float x, float y, GUI g1, ArrayList<Bomb> bombArray){
        g2[(int) x][(int) y] = 2;
        g1.setBoard(g2);
        explodeChain(g1, bombArray);

    }




}



