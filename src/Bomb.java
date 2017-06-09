import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;

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
    public int life;

    Timer timer = new Timer();

    public ArrayList<Float> arrayPosx = new ArrayList();
    public ArrayList<Float> arrayPosy = new ArrayList();
    public ArrayList<Float> arrayBonusPosx = new ArrayList();
    public ArrayList<Float> arrayBonusPosy = new ArrayList();

    public ArrayList<Float> getArrayPosx() {
        return arrayPosx;
    }

    public void setArrayPosx(ArrayList<Float> arrayPosx) {
        this.arrayPosx = arrayPosx;
    }

    public ArrayList<Float> getArrayPosy() {
        return arrayPosy;
    }

    public void setArrayPosy(ArrayList<Float> arrayPosy) {
        this.arrayPosy = arrayPosy;
    }

    public ArrayList<Float> getArrayBonusPosx() {
        return arrayBonusPosx;
    }

    public void setArrayBonusPosx(ArrayList<Float> arrayBonusPosx) {
        this.arrayBonusPosx = arrayBonusPosx;
    }

    public ArrayList<Float> getArrayBonusPosy() {
        return arrayBonusPosy;
    }

    public void setArrayBonusPosy(ArrayList<Float> arrayBonusPosy) {
        this.arrayBonusPosy = arrayBonusPosy;
    }

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

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }


    public Bomb(float x, float y, int bombT, int rangeBomb, int life) { // c pour la couleur permettant d'identifier la personne posant la bombe

        this.posx = x;
        this.posy = y;
        this.bombTime = bombT;
        this.range = rangeBomb;
        this.life = life;

    }

    public void putBomb(float x, float y, int range, GUI g1, ArrayList<Bomb> bombArray, int laps){
        int i,j;
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

        for (i = 0; i <= this.getRange(); i++) {

            if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 0) {
                break;
            }

            else if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 2) {
                g3[(int) getPosx()+i][(int) getPosy()]= 2;

                this.getArrayPosx().add(getPosx()+i);
                this.getArrayPosy().add(getPosy());

                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);

            }

            else if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 1) {
                g3[(int) getPosx()+i][(int) getPosy()]= 2;

                this.getArrayBonusPosx().add(getPosx()+i);
                this.getArrayBonusPosy().add(getPosy());

                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);
                break;
            }

        }

        for (i = 0; i <= getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 0) {
                break;
            }
            else if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 2) {
                g3[(int) getPosx()-i][(int) getPosy()]= 2;

                this.getArrayPosx().add(getPosx()-i);
                this.getArrayPosy().add(getPosy());

                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);
            }
            else if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 1) {
                g3[(int) getPosx()-i][(int) getPosy()]= 2;

                this.getArrayBonusPosx().add(getPosx()-i);
                this.getArrayBonusPosy().add(getPosy());

                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);
                break;
            }
        }

        for (i = 0; i <= getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()+i] == 0) {
                break;
            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy() + i] == 2) {
                g3[(int) getPosx()][(int) getPosy()+i] = 2;

                this.getArrayPosx().add(getPosx());
                this.getArrayPosy().add(getPosy()+i);

                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);


            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy() + i] == 1) {
                g3[(int) getPosx()][(int) getPosy()+i] = 2;
                this.getArrayBonusPosx().add(getPosx());
                this.getArrayBonusPosy().add(getPosy()+i);
                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);
                break;
            }
        }

        for (i = 0; i <= getRange(); i++) {
            if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()-i] == 0) {
                break;
            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()-i] == 2) {
                g3[(int) getPosx()][(int) getPosy()-i] = 2;
                this.getArrayPosx().add(getPosx());
                this.getArrayPosy().add(getPosy()-i);
                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);
            }
            else if (g1.getTransBoard()[(int) getPosx()][(int) getPosy()-i] == 1) {
                g3[(int) getPosx()][(int) getPosy()-i] = 2;
                this.getArrayBonusPosx().add(getPosx());
                this.getArrayBonusPosy().add(getPosy()-i);
                g1.setTransBoard(g3);
                exploBomb(g1, bombArray);
                break;
            }
        }
    }

    public void exploBomb( GUI g1, ArrayList<Bomb> bombArray){
        int [][] g2;
        g2 = g1.getBoard();
        g2[(int) getPosx()][(int) getPosy()] = 3;
        g1.setBoard(g2);


        getTimer().schedule(new TimerTask() {
            public void run() {
                explodeChain(g2, g1, bombArray);
                afterTimer(g1, getArrayPosx(), getArrayPosy(), getArrayBonusPosx(), getArrayBonusPosy());

            }
        }, getBombTime() * 1000);  // millisecondes


    }


    public void explodeChain(int [][] g2, GUI g1, ArrayList<Bomb> bombArray){
        int j,i,k;
        int indexBomb;

        ArrayList<Float> x1,y1,x2,y2; // récupération des futurs positions des zones vertes et des bonus

        for (i = 1; i <= this.getRange(); i++) {

            if (g1.getTransBoard()[(int) getPosx() + i][(int) getPosy()] == 0) {
                break;

            } else if (g1.getBoard()[(int) getPosx() + i][(int) getPosy()] == 3) {
                for (j = 0; j <= bombArray.size() - 1; j++) {
                    if(bombArray.get(j).getPosx() == getPosx() + i  && bombArray.get(j).getPosy() == getPosy()) { // recherche de la bombe concernée
                        // récupération des cases vertes et bonus que la bombe est censée détruire
                        x1 = bombArray.get(j).getArrayPosx();
                        x2 = bombArray.get(j).getArrayBonusPosx();
                        y1 = bombArray.get(j).getArrayPosy();
                        y2 = bombArray.get(j).getArrayBonusPosy();
                        //on arrête le timer de la bombe concernée
                        bombArray.get(j).getTimer().cancel();
                        bombArray.get(j).afterTimer(g1, x1, y1, x2, y2);
                        break;
                    }
                }
            }
        }
        for (i = 1; i <= this.getRange(); i++) {

            if (g1.getTransBoard()[(int) getPosx() - i][(int) getPosy()] == 0) {
                break;

            } else if (g1.getBoard()[(int) getPosx() - i][(int) getPosy()] == 3) {
                for (j = 0; j <= bombArray.size() - 1; j++) {
                    if(bombArray.get(j).getPosx() == getPosx() - i  && bombArray.get(j).getPosy() == getPosy()) { // recherche de la bombe concernée
                        // récupération des cases vertes et bonus que la bombe est censée détruire
                        x1 = bombArray.get(j).getArrayPosx();
                        x2 = bombArray.get(j).getArrayBonusPosx();
                        y1 = bombArray.get(j).getArrayPosy();
                        y2 = bombArray.get(j).getArrayBonusPosy();
                        //on arrête le timer de la bombe concernée
                        bombArray.get(j).getTimer().cancel();
                        bombArray.get(j).afterTimer(g1, x1, y1, x2, y2);

                        break;
                    }
                }
            }
        }
        for (i = 1; i <= this.getRange(); i++) {

            if (g1.getTransBoard()[(int) getPosx()][(int) getPosy() + i] == 0) {
                break;

            } else if (g1.getBoard()[(int) getPosx()][(int) getPosy() + i] == 3) {
                for (j = 0; j <= bombArray.size() - 1; j++) {
                    if(bombArray.get(j).getPosx() == getPosx() && bombArray.get(j).getPosy() == getPosy()+i) { // recherche de la bombe concernée
                        // récupération des cases vertes et bonus que la bombe est censée détruire
                        x1 = bombArray.get(j).getArrayPosx();
                        x2 = bombArray.get(j).getArrayBonusPosx();
                        y1 = bombArray.get(j).getArrayPosy();
                        y2 = bombArray.get(j).getArrayBonusPosy();
                        //on arrête le timer de la bombe concernée
                        bombArray.get(j).getTimer().cancel();
                        bombArray.get(j).afterTimer(g1, x1, y1, x2, y2);
                        break;
                    }
                }
            }
        }

        for (i = 1; i <= this.getRange(); i++) {

            if (g1.getTransBoard()[(int) getPosx()][(int) getPosy() - i] == 0) {
                break;

            } else if (g1.getBoard()[(int) getPosx()][(int) getPosy() - i] == 3) {
                for (j = 0; j <= bombArray.size() - 1; j++) {
                    if(bombArray.get(j).getPosx() == getPosx() && bombArray.get(j).getPosy() == getPosy()-i) { // recherche de la bombe concernée
                        // récupération des cases vertes et bonus que la bombe est censée détruire
                        x1 = bombArray.get(j).getArrayPosx();
                        x2 = bombArray.get(j).getArrayBonusPosx();
                        y1 = bombArray.get(j).getArrayPosy();
                        y2 = bombArray.get(j).getArrayBonusPosy();
                        //on arrête le timer de la bombe concernée
                        bombArray.get(j).getTimer().cancel();
                        bombArray.get(j).afterTimer(g1, x1, y1, x2, y2);
                        break;
                    }
                }
            }
        }
    }

    public void afterTimer(GUI g1, ArrayList<Float> x1, ArrayList<Float> y1, ArrayList<Float> x2, ArrayList<Float> y2){

        int i,j;
        int [][] g3;
        g3 = g1.getBoard();
        for(i=0; i<= x1.size()-1; i++) { //definir la position des carrés verts
            float x = x1.get(i);
            float y = y1.get(i);

            if(g1.getBoard()[(int) x][(int) y] != 2){
                g3[(int) x][(int) y] = 2;
            }
        }

        for(j=0; j<= x2.size() -1; j++){ //définir la position où il peut possiblement y avoir un bonus
            float xBonus = x2.get(j);
            float yBonus = y2.get(j);
            g3[(int) xBonus][(int) yBonus] = 2;

            int randomNum = ThreadLocalRandom.current().nextInt(0,6);
            if(randomNum/5 == 1 ){
                int randomNumBonus = ThreadLocalRandom.current().nextInt(0,4);

                if(randomNumBonus == 0){
                    g3[(int) xBonus][(int) yBonus] = 5;
                }
                else if (randomNumBonus==1){

                    g3[(int) xBonus][(int) yBonus] = 6;
                }
                else if (randomNumBonus == 2){
                    g3[(int) xBonus][(int) yBonus] = 7;

                }else{
                    g3[(int) xBonus][(int) yBonus] = 2;
                }

        }



        }
        g1.setBoard(g3);

    }



}



