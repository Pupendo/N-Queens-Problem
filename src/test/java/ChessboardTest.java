import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ChessboardTest {

    Chessboard chessboard;

    @BeforeEach
    void setUp() {
        chessboard = new Chessboard(8);
    }

    @Test
    void printBoard() {
        chessboard.printBoard();
    }

    @Test
    void insertQueen() {
        Assertions.assertTrue(chessboard.insertQueen(2,5));
        printBoard();
        Assertions.assertFalse(chessboard.insertQueen(0,7));
        Assertions.assertFalse(chessboard.insertQueen(2,0));
        Assertions.assertTrue(chessboard.insertQueen(1,1));
        printBoard();
        Assertions.assertFalse(chessboard.insertQueen(2,5));
        Assertions.assertFalse(chessboard.insertQueen(1,1));
    }


    @Test
    void NQueensProblem() {
        Chessboard chessboard = new Chessboard(4);
        List<Chessboard> solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(2, solutions.size());

        chessboard = new Chessboard(5);
        solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(10,solutions.size());

        chessboard = new Chessboard(6);
        solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(4,solutions.size());

        chessboard = new Chessboard(7);
        solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(40,solutions.size());

        chessboard = new Chessboard(8);
        solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(92,solutions.size());

        chessboard = new Chessboard(9);
        solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(352,solutions.size());

        chessboard = new Chessboard(10);
        solutions = chessboard.NQueensProblem();
        Assertions.assertEquals(724,solutions.size());
//
//        chessboard = new Chessboard(11);
//        solutions = chessboard.NQueensProblem();
//        Assertions.assertEquals(2680,solutions.size());
//
//        chessboard = new Chessboard(12);
//        solutions = chessboard.NQueensProblem();
//        Assertions.assertEquals(14200,solutions.size());
//
//        chessboard = new Chessboard(13);
//        solutions = chessboard.NQueensProblem();
//        Assertions.assertEquals(73712,solutions.size());
//
//        chessboard = new Chessboard(14);
//        solutions = chessboard.NQueensProblem();
//        Assertions.assertEquals(365596,solutions.size());
//
//        chessboard = new Chessboard(15);
//        solutions = chessboard.NQueensProblem();
//        Assertions.assertEquals(2279184,solutions.size());
    }
}
