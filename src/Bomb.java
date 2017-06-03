import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by user on 18/05/2017.
 */


public class Bomb{


    public String color;
    public float posx;
    public float posy;
    public int pressCount;

    public Bomb(String c, int p) { // c pour la couleur permettant d'identifier la personne posant la bombe

        this.color = c;

        if (color == "RED") {
            this.pressCount = p;
        } else {
            this.pressCount = p;
        }

    }

    public void bombPlayer(String c, GUI g1, Player p1, GUI g2, Timer timer) {
        // rajouter condition si orange alors blogué aussi

        int bombVal = 3;
        int value; // où est le joueur
        int orange = 4; // valeur de transition pour les bombes
        int green = 5;
        int posi = 0;
        int posj = 0;

        int [][] g4 = g1.getBoard();
        int [][] g3 = g2.getBoard();

        if (c == "RED") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_F)) { //rajouter condition stack de bombe
                this.pressCount = pressCount +1 ; // incrémentation du nombre de fois où le joueur à mis une bombe

                int valPosx = (int) p1.getPosx();
                int valPosy = (int) p1.getPosy();

                value = g1.getBoard()[valPosx][valPosy]; //case à  la position du joueur au moment où il place la bombe (1 ou 2)
                p1.getValue((int) p1.getPosx(), (int) p1.getPosy(), g1.getBoard());


                if(value == 2 || value == 5){
// rajouter le cas où pos == 1 et changer en orange
                    if(g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy())] != 0) {

                        g3[(int) (p1.getPosx())][(int) (p1.getPosy())] = 3;
                    }
                    if (g1.getBoard()[(int) p1.getPosx() + 1][(int) (p1.getPosy())] != 0 && g1.getBoard()[(int) p1.getPosx() + 1][(int) (p1.getPosy())] != 3) {
                        if(g1.getBoard()[(int) p1.getPosx() + 1][(int) (p1.getPosy())] == 1 || g1.getBoard()[(int) p1.getPosx() + 1][(int) (p1.getPosy())] == 4) {
                            g3[(int) (p1.getPosx() + 1)][(int) (p1.getPosy())] = orange;

                        }
                        else{
                            g3[(int) (p1.getPosx() + 1)][(int) (p1.getPosy())] = green;
                        }
                    }
                    if (g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy() + 1)] != 0 && g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy() + 1)] != 3) {
                        if(g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy() + 1)] == 1 || g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy() + 1)] == 4){
                            g3[(int) (p1.getPosx())][(int) (p1.getPosy() + 1)] = orange;
                        }
                        else{
                            g3[(int) (p1.getPosx())][(int) (p1.getPosy() + 1)] = green;
                        }
                    }
                    if (g1.getBoard()[(int) p1.getPosx()-1][(int) p1.getPosy()] !=0 && g1.getBoard()[(int) p1.getPosx()-1][(int) p1.getPosy()] != 3){
                        if(g1.getBoard()[(int) p1.getPosx()-1][(int) p1.getPosy()] == 1 || g1.getBoard()[(int) p1.getPosx() - 1][(int) (p1.getPosy())] == 4){
                            g3[(int) (p1.getPosx() - 1)][(int) (p1.getPosy())] = orange;
                        }
                        else{
                            g3[(int) (p1.getPosx() - 1)][(int) (p1.getPosy())] = green;
                        }

                    }
                    if (g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy()-1)] != 0 && g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy()-1)] != 3) {
                        if(g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy()-1)] == 1 || g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy()-1)] == 4){
                            g3[(int) (p1.getPosx())][(int) (p1.getPosy() - 1)] = orange;
                        }
                        else{
                            g3[(int) (p1.getPosx())][(int) (p1.getPosy() - 1)] = green;
                        }
                    }
                }
                // si le joueur appuie sur F changer le 1 par 3 quand le joueur pose une bombe
                //System.out.print( g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy())]);
                //System.out.print(pressCount);

                if(pressCount > 20){
                    System.out.print("vous n'avez plus de bombes, veuillez attendre 3 secondes");

                    timer.schedule(new TimerTask() { // execution de void run après le temps donc après 3 secondes

                        public void run() {
                            pressCount = pressCount - 1;
                        }
                    }, 5 * 1000); // millisecondes
                }
                else{
                    timer.schedule(new TimerTask() { // execution de void run après le temps donc après 3 secondes

                        public void run() {
                            int i,j;
                            System.out.print("I'd like you to get the fuck out of here");
                            if(g2.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy())] == 5 || g2.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy())] == 4){
                                p1.setVie(p1.getVie()-1);
                            }
                            for(i = 0; i <= g2.getBoard().length - 1; i++) {
                                for (j = 0; j <= g2.getBoard()[1].length - 1; j++) {
                                    if (g2.getBoard()[i][j] == 3 || g2.getBoard()[i][j] == 4 || g2.getBoard()[i][j] == 5) {
                                        g2.getBoard()[i][j]=2;
                                    }
                                }
                                //System.out.print(board[i][j]);
                            }
                            g1.setBoard(g3);
                        }
                    }, 5 * 1000); // millisecondes
                }

            }
        } else if (c == "BLUE") {/*
            Timer timer = new Timer();

            if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) { //rajouter condition stack de bombe

                pressCount = pressCount +1 ; // incrémentation du nombre de fois où le joueur à mis une bombe

                int valPosx = (int) p1.getPosx();
                int valPosy = (int) p1.getPosy();
                value = g1.board[valPosx][valPosy]; //case à  la position du joueur au moment où il place la bombe (1 ou 2)
                p1.getValue((int) p1.getPosx(), (int) p1.getPosy(), g1.board);

                int [][] g2 = g1.board; //tableau de transition

                System.out.println(p1.getPosx() +" // position y" +  p1.getPosy() + "//") ;
                System.out.println((int) p1.getPosx() +"// position y" +  (int) p1.getPosy()+ "/INT/") ;

                if(value == 2){
// rajouter le cas où pos == 1 et changer en orange
                    if(g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy())] != 0) {

                        g2[(int) (p1.getPosx())][(int) (p1.getPosy())] = 3;
                    }
                    if (g1.getBoard()[(int) p1.getPosx() + 1][(int) (p1.getPosy())] != 0) {
                        if(g1.getBoard()[(int) p1.getPosx() + 1][(int) (p1.getPosy())] == 1) {
                            g2[(int) (p1.getPosx() + 1)][(int) (p1.getPosy())] = 4;
                        }
                        else{
                            g2[(int) (p1.getPosx() + 1)][(int) (p1.getPosy())] = 5;
                        }
                    }
                    if (g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy() + 1)] != 0) {
                        if(g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy() + 1)] == 1){
                            g2[(int) (p1.getPosx())][(int) (p1.getPosy() + 1)] = 4;
                        }
                        else{
                            g2[(int) (p1.getPosx())][(int) (p1.getPosy() + 1)] = 5;
                        }
                    }
                    if (g1.getBoard()[(int) p1.getPosx()-1][(int) p1.getPosy()] !=0){
                        if(g1.getBoard()[(int) p1.getPosx()-1][(int) p1.getPosy()] == 1){
                            g2[(int) (p1.getPosx() - 1)][(int) (p1.getPosy())] = 4;
                        }
                        else{
                            g2[(int) (p1.getPosx() - 1)][(int) (p1.getPosy())] = 5;
                        }

                    }
                    if (g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy()-1)] != 0) {
                        if(g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy()-1)] == 1){
                            g2[(int) (p1.getPosx())][(int) (p1.getPosy() - 1)] = 4;
                        }
                        else{
                            g2[(int) (p1.getPosx())][(int) (p1.getPosy() - 1)] = 5;
                        }

                    }

                }

                g1.setBoard(g2); // si le joueur appuie sur F changer le 1 par 3 quand le joueur pose une bombe
                //System.out.print( g1.getBoard()[(int) p1.getPosx()][(int) (p1.getPosy())]);
                //System.out.print(pressCount);

                if(pressCount > 20){
                    System.out.print("vous n'avez plus de bombes, veuillez attendre 3 secondes");

                    timer.schedule(new TimerTask() { // execution de void run après le temps donc après 3 secondes

                        public void run() {
                            pressCount = pressCount - 1;
                        }
                    }, 5 * 1000); // millisecondes
                }
                else{
                    timer.schedule(new TimerTask() { // execution de void run après le temps donc après 3 secondes

                        public void run() {
                            int i,j;


                        }
                    }, 5 * 1000); // millisecondes
                }

            }*/
        }
    }

}


