/**
 * Created by user on 09/06/2017.
 */
public class Bonus {

    private int life;
    private int bombRange;
    private int typeBonus;
    private float speed;
    private int bombNumBonus;


    public Bonus(int playerLife, int range, int type, float playerSpeed, int playerBombNum){
        this.life = playerLife;
        this.bombRange = range;
        this.typeBonus = type;
        this.speed = playerSpeed;
        this.bombNumBonus = playerBombNum;

    }


    public void applyBonus(GUI g1, float x, float y){
        int [][] g2;
        g2 = g1.getBoard();

        if(g1.getBoard()[(int) x][(int) y] == 5){
            setBombRange(getBombRange() + 1);
            g2[(int) x][(int) y] = 2;
            g1.setBoard(g2);
        }

        else if(g1.getBoard()[(int) x][(int)y] == 6){
            setLife(getLife()+1);
            g2[(int) x][(int) y] = 2;
            g1.setBoard(g2);
        }

        else if(g1.getBoard()[(int) x][(int)y] == 7){
            setBombNumBonus(getBombNumBonus()+2);
            g2[(int) x][(int) y] = 2;
            g1.setBoard(g2);
        }
    }

    public int getBombNumBonus() {
        return bombNumBonus;
    }

    public void setBombNumBonus(int bombNumBonus) {
        this.bombNumBonus = bombNumBonus;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getBombRange() {
        return bombRange;
    }

    public void setBombRange(int bombRange) {
        this.bombRange = bombRange;
    }

    public int getTypeBonus() {
        return typeBonus;
    }

    public void setTypeBonus(int typeBonus) {
        this.typeBonus = typeBonus;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }






}
