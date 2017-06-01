import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
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

    private int pressCount = 0;
    private int imageValue = 1;

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

        // rajouter condition si 1 alors blogué aussi

        if (c == "RED") {
            if (StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0) {
                if(StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 3) {
                    if(g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 4){
                        replacePlayer();
                        setPosy(getPosy() + 1);
                        drawPlayer(c);
                    }
                }
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
                if(g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 3) {
                    if(g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 4){
                        replacePlayer();
                        setPosy(getPosy() + 1);
                        drawPlayer(c);
                    }
                }
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

    public void putBomb() {
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledCircle(getPosx(), getPosy(), 0.20);
    }
    public int getValue(int valPosx, int valPosy, int [][] board){
            int value;
            value = board[valPosx][valPosy];
            return value;
    }

    public void bombPlayer(String c, GUI g1) {
        // rajouter condition si orange alors blogué aussi

        int bombVal = 3;
        int value; // où est le joueur
        value = g1.board[(int) getPosx()][(int) (getPosy())]; //le joueur est sur une case verte donc 1


        if (c == "RED") {

            if (StdDraw.isKeyPressed(KeyEvent.VK_F)) { //rajouter condition stack de bombe

                pressCount = pressCount +1 ; // incrémentation du nombre de fois où le joueur à mis une bombe

                int valPosx = (int) getPosx();
                int valPosy = (int) getPosy();
                value = g1.board[valPosx][valPosy]; //case à  la position du joueur au moment où il place la bombe (1 ou 2)
                getValue((int) getPosx(), (int) getPosy(), g1.board);

                int [][] g2 = g1.board; //tableau de transition

                System.out.println(getPosx() +" // position y" +  getPosy() + "//") ;
                System.out.println((int) getPosx() +"// position y" +  (int) getPosy()+ "/INT/") ;

                if( getValue((int) getPosx(), (int) getPosy(), g1.board) == 1){
                        g2[(int) (getPosx())][(int) (getPosy())] = 3;
                    if(g1.getBoard()[(int) getPosx()+1][(int) (getPosy())] != 0){
                        g2[(int) (getPosx()+1)][(int) (getPosy())] = 3;
                    }
                }
                else if(value == 2){
                    if(g1.getBoard()[(int) getPosx()][(int) (getPosy())] != 0){
                        g2[(int) (getPosx())][(int) (getPosy())] = 4;
                        if(g1.getBoard()[(int) getPosx()+1][(int) (getPosy())] != 0){
                            g2[(int) (getPosx()+1)][(int) (getPosy())] = 3;
                        }
                    }                }
                g1.setBoard(g2); // si le joueur appuie sur F changer le 1 par 3 quand le joueur pose une bombe
                //System.out.print( g1.getBoard()[(int) getPosx()][(int) (getPosy())]);
                //System.out.print(pressCount);
                Timer timer = new Timer();

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
                        for(i = 0; i <= g1.board.length - 1; i++) {
                            for (j = 0; j <= g1.board[1].length - 1; j++) {
                                if (g1.board[i][j] == 3 || g1.board[i][j] == 4) {
                                    g1.board[i][j]=2;
                                }
                            }

                            //System.out.print(board[i][j]);
                        }
                        }
                    }, 5 * 1000); // millisecondes
                }

            }
        } else if (c == "BLUE") {
            if (StdDraw.isKeyPressed(KeyEvent.VK_SPACE)) {
                //putBomb();
            }
        }
    }

}