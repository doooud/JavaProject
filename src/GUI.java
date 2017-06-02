import edu.princeton.cs.introcs.StdDraw;

/**
 * Created by user on 18/05/2017.
 */
public class GUI {


    int[][] board ;


    public GUI() {


        int [][] board = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0/*(0,1)*/, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 2, 0, 2, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 0},
                {0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 2, 0, 2, 0},
                {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };

        this.board = board;

    }

    public void generate(){

        int i,j;

        for( i = 0; i <= this.board.length - 1; i++) {
            for ( j = 0; j <= this.board[1].length - 1; j++) {
                if (this.board[i][j] == 0) {
                    StdDraw.setPenColor(StdDraw.GRAY);
                    //StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
                } else if (this.board[i][j] == 1) {
                    StdDraw.setPenColor(StdDraw.ORANGE);
                    //StdDraw.picture(i+0.5, j+0.5, "image/gui/destructible.png", 1,1);
                } else if (this.board[i][j] == 2) {
                    StdDraw.setPenColor(StdDraw.GREEN);

                }
                //System.out.print(board[i][j]);
                StdDraw.filledSquare(i + 0.5, j + 0.5, 0.5);
            }
        }
    }


    public void checkBomb(){

        int i,j;

        for(i = 0; i <= this.board.length - 1; i++) {
            for (j = 0; j <= this.board[1].length - 1; j++) {

                    if (this.board[i][j] == 3) {

                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledCircle(i+0.5, j+0.5, 0.20);

                    }
                    else if(this.board[i][j] == 4){
                        StdDraw.setPenColor(StdDraw.GREEN);
                        StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
                        StdDraw.setPenColor(StdDraw.BLACK);
                        StdDraw.filledCircle(i+0.5, j+0.5, 0.20);

                    }else if(this.board[i][j] == 5){
                        StdDraw.setPenColor(StdDraw.ORANGE);
                        StdDraw.filledSquare(i+0.5, j+0.5, 0.5);
                    }


                }

                //System.out.print(board[i][j]);
        }

    }
    public int[][] getBoard() {
        return board;
    }


    public void setBoard(int[][] board) {
        this.board = board;
    }




}




