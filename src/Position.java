import edu.princeton.cs.introcs.StdDraw;

import java.awt.event.KeyEvent;

/**
 * Created by user on 28/05/2017.
 */
public class Position {

    Player p1 = new Player("p1", "RED", 0,0,3);
    Player p2 = new Player("Adrien", "BLUE", 0, 0,3);

    public float posx;
    public float posy;



    public Position(){

        if(p1.color ==  "RED"){
            this.posx = 1.5f;
            this.posy = 1.5f;
        }
        else{
            this.posx = 19.5f;
            this.posy = 15.5f;
        }

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

    public void movePlayer(String c){

        p1.drawPlayer(p1.color);
        p2.drawPlayer(p2.color);

        GUI g1 = new GUI();
        // rajouter condition si 1 alors blogué aussi

        if(c == "RED"){

            if(StdDraw.isKeyPressed(KeyEvent.VK_UP) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0){
                StdDraw.clear();
                setPosy(getPosy() + 1);
                g1.generate();

                p1.drawPlayer(c);

            }
            else if(StdDraw.isKeyPressed(KeyEvent.VK_DOWN) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0){
                StdDraw.clear();
                setPosy(getPosy() - 1);
                g1.generate();

                p1.drawPlayer(c);
            }
            else if(StdDraw.isKeyPressed(KeyEvent.VK_RIGHT) && g1.getBoard()[(int) getPosx() + 1][(int) (getPosy())] != 0){
                StdDraw.clear();
                setPosx(getPosx() + 1);
                g1.generate();
                p1.drawPlayer(c);
            }
            else if(StdDraw.isKeyPressed(KeyEvent.VK_LEFT) && g1.getBoard()[(int) getPosx()-1][(int) (getPosy())] != 0){
                StdDraw.clear();
                setPosx(getPosx() - 1);
                g1.generate();
                p1.drawPlayer(c);
            }
        }
        else if(c == "BLUE"){

            if(StdDraw.isKeyPressed(KeyEvent.VK_Z) && g1.getBoard()[(int) getPosx()][(int) (getPosy() + 1)] != 0){

                StdDraw.clear();
                setPosy(getPosy() + 1);
                g1.generate();

                p2.drawPlayer(c);

            }
            else if(StdDraw.isKeyPressed(KeyEvent.VK_S) && g1.getBoard()[(int) getPosx()][(int) (getPosy() - 1)] != 0){
                StdDraw.clear();
                setPosy(getPosy() - 1);
                g1.generate();

                p2.drawPlayer(c);
            }
            else if(StdDraw.isKeyPressed(KeyEvent.VK_D) && g1.getBoard()[(int) getPosx() + 1][(int) (getPosy())] != 0){
                StdDraw.clear();
                setPosx(getPosx() + 1);
                g1.generate();
                p2.drawPlayer(c);
            }
            else if(StdDraw.isKeyPressed(KeyEvent.VK_Q) && g1.getBoard()[(int) getPosx()-1][(int) (getPosy())] != 0){
                StdDraw.clear();
                setPosx(getPosx() - 1);
                g1.generate();
                p2.drawPlayer(c);
            }
        }
    }
}