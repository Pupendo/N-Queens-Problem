import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        //Chessboard object holds a two-dimensional integer array which represents the chessboard state.
        //The numbers have the following meaning:
        // 0 represents an empty square which is not attacked by any of the queens on the board
        // 1 represents a square with a queen
        // 2 represents an empty square attacked by one or more queens on the board.

        // The integer passed into the constructor represents the size of the board; in this case the board is 8x8
        Chessboard chessboard = new Chessboard(8);

        //Simple print method; initially all squares are marked with 0
        chessboard.printBoard();

        // The cover squares method takes two parameters which represent the square on the board where queen is placed.
        // The method marks all squares in queen's range (horizontal, vertical and diagonal) with number two.
        // Please note that this method does not insert the queen, only covers the other squares.
        chessboard.coverSquares(3,4);
        chessboard.printBoard();

        chessboard = new Chessboard(8);

        //insertQueen takes two parameters representing the coordinates of the square where we want to insert queen.
        // First, the program checks if the square is marked with zero. If so it, marks the square with one and calls
        // the cover method to update the board state.
        //The method returns a boolean value to represent if it is possible the insert a queen at that square
        boolean flag = chessboard.insertQueen(3,4);
        if (flag){
            chessboard.printBoard();
        }

        // If we try to insert at the same position again, it will return false and nothing is printed out
        flag = chessboard.insertQueen(3,4);
        if (flag){
            chessboard.printBoard();
        }

        // If we try to insert at a position marked with 2, it will return false and nothing is printed out.
        flag = chessboard.insertQueen(3,1);
        if (flag){
            chessboard.printBoard();
        }

        // NQueensProblem method returns a list of all solutions of an n queens problem for a given board size.
        ArrayList<Chessboard> solutions = (ArrayList<Chessboard>) chessboard.NQueensProblem();

        System.out.println("Number of solutions for board of size 8 is known to be 92... The method returned "
                +solutions.size()+" solutions");

        // All solutions are printed out to check if they are valid solutions
        //Uncomment this part to print all solutions
//        for (Chessboard board: solutions) {
//            board.printBoard();
//        }
    }
}
