import edu.princeton.cs.introcs.StdDraw;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        StdDraw.clear();

        StdDraw.setCanvasSize(21 * 50, 17 * 50);
        StdDraw.setXscale(0, 21);
        StdDraw.setYscale(0, 17);
        StdDraw.enableDoubleBuffering();

        Player p1 = new Player("p1", "RED", 0, 0);
        Player p2 = new Player("Adrien", "BLUE", 0, 0);


        while(true){

            Interface();

            p2.movePlayer(p2.color);
            p1.drawPlayer(p1.color);
            p1.movePlayer(p1.color);
            p2.drawPlayer(p2.color);
            p2.bombPlayer(p2.color);
            p1.bombPlayer(p1.color);
            StdDraw.show(60);

            StdDraw.clear();

        }
    }

    public static void PlayerName() {

        Scanner myScan = new Scanner(System.in);

        Player p1 = new Player("p1", "RED", 0, 0);
        Player p2 = new Player("Adrien", "BLUE", 0,0);


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
    public static void Interface(){

        GUI g1 = new GUI();
        g1.generate(0,0);

    }



}                                                                                       
