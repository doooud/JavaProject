import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by user on 28/05/2017.
 */
public class Circle {

    public String color;
    public float posx;
    public float posy;
    public String playerName;

    public Circle(String c, float x, float y, String pName){

        this.color = c;
        this.posx = x;
        this.posy = y;
        this.playerName = pName;

        if(c == "RED"){
            StdDraw.setPenColor(StdDraw.RED);
        }
        else if(c == "BLUE"){
            StdDraw.setPenColor(StdDraw.BLUE);
        }

        StdDraw.filledCircle(x, y, 0.45);
        StdDraw.show();

    }
}
