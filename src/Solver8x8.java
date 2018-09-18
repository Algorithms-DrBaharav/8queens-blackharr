
/**
 * Solves 8-Queens problem
 * 
 * How to place 8-queens on a chess board such that none can capture another.
 * 
 * 
 * The function solve() return the board for display.
 * 
 * @author Dr. Baharav
 */
public class Solver8x8 {

    // Board representation
    int[8][8] board;
    int[8][8] numBlanked;
    int[8][8] invalid;
    int[2] initQueen;
    int[2] lastQueen;
    
    
    // Initialize all to empty
    public Solver8x8() {
        resetBoards();
    }

    /**
     * 
     * @return int[][] - Board - 2D array, with 1 representing a queen, and 0 
     * represents NO queen (aka empty square)
     * 
     */
    public int[][] solve() {
        int queens;
        while (True) {
            for (int queens = 0; queens < 8; queens++) {
                if (isValidPosition()) {
                    placeQueen();
                    if (queens == 0) {
                        initQueen[0] = lastQueen[0];
                        initQueen[1] = lastQueen[1];
                    }
                    updateBoard();
                    updateNumBlanks();
                } else
                    break;
            }
            if (numQueens == 8)
                return cleanup();
            resetBoards();
            invalid[initQueen[0]][initQueen[1]] = 1;
            
        }
    }
    
    private void placeQueen() {
        int minx = 0;
        int miny = 0;
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                boolean smallerValid = numBlanked[i][j] != -1 && numBlanked[i][j] < numBlanked[minx][miny];
                if (invalid[i][j] == 1 && (smallerValid || numBlanked[minx][miny] == -1)) {
                    minx = i;
                    miny = j;
                }
            }
        board[minx][miny] = 1;
        lastQueen[0] = minx;
        lastQueen[1] = miny;
    }
    
    private void updateBoard() {
        //ToDo
    }
    
    private void updateNumBlanks() {
        //ToDo
    }
    
    private boolean isValidPosition() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; i < 8; j++)
                if (board[i][j] == 0)
                    return True;
        return False;
    
    private void resetBoards() {
        board = new int[8][8];
        numBlanked = new int[8][8];
        invalid = new int[8][8];
    }
    
    private int[][] cleanup() {
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++)
                if (board[i][j] == -1)
                    board[i][j] = 0;
        return board;
    }
    
    
    /*
    
    UTILITY methods below
    
    */
    
    
    
    

    //  Convert into a 2D representation.
    //  Used to communicate out. For display. Simple 8x8 array
    //      bDisplay[ii][jj] is square [ii][jj] on the board.
    //      content of cell: 1 is Queen present, 0 is empty cell.

    private int[][] b2board() {
        int[][]br = new int[8][8];
        for (int ii = 0; ii < 8; ++ii) 
            for (int jj = 0; jj < 8; ++jj) 
                br[ii][jj] = 0;
           
        for (int ii = 0; ii < 8; ++ii)
            if (ii==4)
                br[7][ii] = 1;
            else    
                br[ii][ii] = 1;

        // Just if you want intermediate printouts, see how it works
        printBoard(br);
        
        return br;
    }
    
    
    
    private void printBoard(int[][] b) {
        System.out.println("Board");

        for (int cc = 0; cc < 8; ++cc) 
            System.out.print("+-");
        System.out.println("+");

        for (int rr = 0; rr < 8; ++rr) {
            for (int cc = 0; cc < 8; ++cc) {
                if (b[rr][cc] == 1)
                    System.out.format("|*");
                else
                    System.out.format("| ");                    
            }
            System.out.println("|");
        
            for (int cc = 0; cc < 8; ++cc) 
                System.out.print("+-");
            System.out.println("+");
        }

    }

}
