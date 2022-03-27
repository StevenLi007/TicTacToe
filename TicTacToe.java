/**
 * This file contains the implementation of a Tic Tac Toe game
 * that can be generalized to an N-in-a-row game played with an
 * NxN game board.
 * 
 * Sources:
 * Checking for inappropriate user input: https://kodejava.org/how-do-i-validate-input-when-using-scanner/#:~:text=To%20validate%20input%20the%20Scanner,provide%20a%20positive%20integer%20number.
 * How to format text: https://www.javatpoint.com/java-string-format
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Math;

/**
 * This class uses a String[][] to represent the Tic Tac Toe board.
 * It can register player input and use a pseudorandom method to 
 * generate a computer move. It will also check for wins.
 */
public class TicTacToe {
    String[][] board;

    private static final int DIMENSION = 3;
    private static final String EMPTY_SYMBOL = "-";
    private static final String PLAYER_SYMBOL = "x";
    private static final String COMPUTER_SYMBOL = "0";
    private static final String PLAYER_WON = "Player Won!";
    private static final String COMPUTER_WON = "Computer Won!";
    private static final String ASK_FOR_ROW = "Please enter the row number " + 
        "of your move: ";
    private static final String INVALID_ROW = "%s is not a valid row";
    private static final String ASK_FOR_COL = "Please enter the column number " + 
        "of your move: ";
    private static final String INVALID_COL = "%s is not a valid column";
    private static final String INVALID_MOVE = "Invalid move. Please try again.";
    private static final String COMPUTER_MOVE = "The computer chose to move " + 
        "to (%s, %s).";

    /**
     * Initializes an empty 3x3 board.
     */
    public TicTacToe() {
        this.board = new String[DIMENSION][DIMENSION];
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                this.board[r][c] = EMPTY_SYMBOL;
            }
        }
    }

    /**
     * Randomly chooses an empty spot as the computer's move
     * @return the concatenation of the row and column number of the move
     */
    public String getComputerMove() {
        ArrayList<Integer> availableRow = new ArrayList<>();
        ArrayList<Integer> availableCol = new ArrayList<>();
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                if (this.board[r][c].equals(EMPTY_SYMBOL)) {
                    availableRow.add(r);
                    availableCol.add(c);
                }
            }
        }
        int numAvailableSpots = availableRow.size();
        int randIdx = (int) (Math.random() * numAvailableSpots);
        String row = Integer.toString(availableRow.get(randIdx));
        String col = Integer.toString(availableCol.get(randIdx));
        return row + col;
    }

    /**
     * Returns the winner of the game or null if no one has won yet
     * @return the winner of the game or null if no one has won yet
     */
    public String getWinner() {
        boolean rowWinner = false;
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length - 1; c++) {
                if (this.board[r][c].equals(this.board[r][c + 1]) &&
                        !(this.board[r][c].equals(EMPTY_SYMBOL))) {
                    rowWinner = true;
                } else {
                    rowWinner = false;
                    break;
                }
            }
            if (rowWinner) {
                if (this.board[r][0].equals(PLAYER_SYMBOL)) {
                    return PLAYER_WON;
                } else {
                    return COMPUTER_WON;
                }
            }
        }
        boolean colWinner = false;
        for (int c = 0; c < this.board[0].length; c++) {
            for (int r = 0; r < this.board.length - 1; r++) {
                if (this.board[r][c].equals(this.board[r + 1][c]) &&
                        !(this.board[r][c].equals(EMPTY_SYMBOL))) {
                    colWinner = true;
                } else {
                    colWinner = false;
                    break;
                }
            }
            if (colWinner) {
                if (this.board[0][c].equals(PLAYER_SYMBOL)) {
                    return PLAYER_WON;
                } else {
                    return COMPUTER_WON;
                }
            }
        }
        boolean diag1Winner = false;
        for (int r = 0; r < this.board.length - 1; r++) {
            for (int c = 0; c < this.board[0].length - 1; c++) {
                if (this.board[r][c].equals(this.board[r + 1][c + 1]) &&
                        !(this.board[r][c].equals(EMPTY_SYMBOL))) {
                    diag1Winner = true;
                } else {
                    diag1Winner = false;
                    break;
                }
            }
        }
        boolean diag2Winner = false;
        for (int r = 0; r < this.board.length - 1; r++) {
            for (int c = this.board[0].length - 1; c > 0; c--) {
                if (this.board[r][c].equals(this.board[r + 1][c - 1]) &&
                        !(this.board[r][c].equals(EMPTY_SYMBOL))) {
                    diag2Winner = true;
                } else {
                    diag2Winner = false;
                    break;
                }
            }
        }
        if (diag1Winner || diag2Winner) {
            if (this.board[this.board.length - 1][0].equals(PLAYER_SYMBOL) || 
                    this.board[0][0].equals(PLAYER_SYMBOL)) {
                return PLAYER_WON;
            } else {
                return COMPUTER_WON;
            }
        }
        return null;
    }

    /**
     * Returns a string representation of the
     * game board.
     * @return string representation of the
     * game board.
     */
    public String toString() {
        String board = "";
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                board += this.board[r][c] + " ";
            }
            board += "\n";
        }
        return board;
    }

    /**
     * Plays the game with helper methods.
     * @param args not used in this method
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        boolean running = true;
        System.out.println(game.toString());
        while (running) {
            Scanner in = new Scanner(System.in);
            boolean moveComplete = false;
            while (!moveComplete) {
                System.out.println(ASK_FOR_ROW);
                boolean validRow = false;
                int row = 0;
                while (!validRow) {
                    if (!in.hasNextInt()) {
                        String invalidRow = in.next();
                        System.out.printf(INVALID_ROW, invalidRow);
                    } else {
                        int playerRow = in.nextInt();
                        if (playerRow < 1 || playerRow > game.board.length) {
                            System.out.printf(INVALID_ROW, playerRow);
                        } else {
                            row = playerRow;
                            validRow = true;
                        }
                    }
                }
                System.out.println(ASK_FOR_COL);
                boolean validCol = false;
                int col = 0;
                while (!validCol) {
                    if (!in.hasNextInt()) {
                        String invalidCol = in.next();
                        System.out.printf(INVALID_COL, invalidCol);
                    } else {
                        int playerCol = in.nextInt();
                        if (playerCol < 1 || playerCol > game.board.length) {
                            System.out.printf(INVALID_COL, playerCol);
                        } else {
                            col = playerCol;
                            validCol = true;
                        }
                    }
                }
                if (!game.board[row - 1][col - 1].equals(EMPTY_SYMBOL)) {
                    System.out.println(INVALID_MOVE);
                } else {
                    moveComplete = true;
                    game.board[row - 1][col - 1] = PLAYER_SYMBOL;
                }
            }
            System.out.println(game.toString());
            if (game.getWinner() != null) {
                System.out.println(game.getWinner());
                running = false;
            } else {
                String computerMove = game.getComputerMove();
                int computerMoveRow = Integer.parseInt(computerMove.substring(0, 1));
                int computerMoveCol = Integer.parseInt(computerMove.substring(1));
                System.out.printf(COMPUTER_MOVE, computerMoveRow, computerMoveCol);
                System.out.println();
                game.board[computerMoveRow][computerMoveCol] = COMPUTER_SYMBOL;
                System.out.println(game.toString());
                if (game.getWinner() != null) {
                    System.out.println(game.getWinner());
                    running = false;
                }
            }
        }
    }
}