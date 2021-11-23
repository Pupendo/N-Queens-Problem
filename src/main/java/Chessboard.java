import java.util.ArrayList;
import java.util.List;

public class Chessboard {
    private int[][] board;
    private int n;

    public Chessboard(int n){
        this.n = n;
        board = new int[n][n];
    }

    public int[][] getBoard() {
        return board;
    }

    public void setBoard(int[][] board) {
        this.board = board;
    }

    public void printBoard(){
        StringBuilder str = new StringBuilder("Chessboard:");
        for (int i = 0; i < n; i++){
            str.append("\n");
            for (int j = 0; j<n; j++){
                str.append(board[i][j]).append("  ");
            }
        }
        System.out.println(str);
    }

    public boolean insertQueen(int x, int y){
        if (board[x][y] == 0){
            board[x][y] = 1;
            coverSquares(x,y);
            return true;
        }
        return false;
    }

    public Chessboard copy(){
        Chessboard chessboard = new Chessboard(n);
        chessboard.setBoard(copyBoard(board));
        return chessboard;
    }

    public void coverSquares(int x, int y){
        int min = Math.min(x,y);
        for (int i = 1; i < n-min;i++){
            int leftIndex = y-i;
            int rightIndex = y+i;
            int topIndex = x-i;
            int bottomIndex = x+i;

            //Horizontal left
            if (leftIndex >= 0){
                board[x][y-i] = 2;
            }
            //Horizontal right
            if (rightIndex < n){
                board[x][y+i] = 2;
            }
            //Vertical up
            if (topIndex >= 0){
                board[x-i][y] = 2;
            }
            //Vertical down
            if (bottomIndex < n){
                board[x+i][y] = 2;
            }
            //Top left diagonal
            if (leftIndex >= 0 && topIndex >=0){
                board[x-i][y-i] = 2;
            }
            //Bottom left diagonal
            if (leftIndex >= 0 && bottomIndex < n){
                board[x+i][y-i] = 2;
            }
            //Top right diagonal
            if (rightIndex < n && topIndex >=0){
                board[x-i][y+i] = 2;
            }
            //Bottom right diagonal
            if (rightIndex < n && bottomIndex < n){
                board[x+i][y+i] = 2;
            }
        }
    }

    public List<Chessboard> NQueensProblem(){
        return NQueensProblem(copy(), new ArrayList<>(),0);
    }

    private List<Chessboard> NQueensProblem(Chessboard chessboard, List<Chessboard> solutions, int column){
        //Step
        for (int i = 0; i < n; i++)
        {
            Chessboard board = chessboard.copy();
            boolean flag = board.insertQueen(i,column);
            //Explore if possible
            if (flag){
                //Goal
                if (column == n-1){
                    solutions.add(board);
                    return solutions;
                }
                Chessboard board2 = board.copy();
                NQueensProblem(board2,solutions,column+1);
            }
        }
        return solutions;
    }

    private int[][] copyBoard(int[][] input){
        if (input == null)
            return null;
        int[][] result = new int[input.length][];
        for (int r = 0; r < input.length; r++) {
            result[r] = input[r].clone();
        }
        return result;
    }
}
