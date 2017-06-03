import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;
import java.util.Scanner;
import java.util.Timer;


public class Main {

    public static void main(String[] args) {

        StdDraw.setCanvasSize(21 * 50, 17 * 50);
        StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
        StdDraw.enableDoubleBuffering();
        Timer timer = new Timer();

        Player p1 = new Player("p1", "RED", 0, 0, 3);
        Player p2 = new Player("Adrien", "BLUE", 0, 0, 3);

        GUI g1 = new GUI();
        GUI g2 = new GUI();
        g1.setBoard(g2.getBoard());
        Bomb b1 = new Bomb(p1.color, 0);


        int value;
        int i,j;

        while(true){

            g1.generate();

            //debug
            if(StdDraw.isKeyPressed(KeyEvent.VK_D)){
                System.out.print(p1.getVie());
                System.out.println("----------");
                for(i = 0; i <= g1.getBoard().length - 1; i++) {
                    for (j = 0; j <= g1.getBoard()[1].length - 1; j++) {
                        System.out.print(g1.getBoard()[i][j]);
                    }
                    System.out.println("");
                }
            }

            p2.movePlayer(p2.color, g1);
            p1.movePlayer(p1.color, g1);

            b1.bombPlayer(p1.color, g1, p1, g2, timer);
            //b1.bombPlayer(p2.color, g1, p2, g2, timer, time);

            g1.checkBomb();
            p2.drawPlayer(p2.color);
            p1.drawPlayer(p1.color);

            StdDraw.show(60);


        }
    }

    public static void PlayerName() {

        Scanner myScan = new Scanner(System.in);

        Player p1 = new Player("p1", "RED", 0, 0, 3);
        Player p2 = new Player("Adrien", "BLUE", 0,0, 3);


        p1.drawPlayer(p1.color);
        p2.drawPlayer(p2.color);


        /*System.out.println("P1 Set your name : ");
        String p1Name = myScan.nextLine();
        p1.setName(p1Name);
        System.out.println("Ok, your name is : " + p1.getName());

        System.out.println("P2 Set your name : ");
        String p2Name = myScan.nextLine();
        p2.setName(p2Name);

        System.out.println("Ok, your name is : " + p2.getName());
        */


    }




}                                                                                       
