/**
 * TODO: file header
 * 
 * Sources:
 * Checking for inappropriate user input: https://kodejava.org/how-do-i-validate-input-when-using-scanner/#:~:text=To%20validate%20input%20the%20Scanner,provide%20a%20positive%20integer%20number.
 * How to format text: https://www.javatpoint.com/java-string-format
 */
import java.util.Scanner;

/**
 * TODO: class header
 */
public class TicTacToe {
    String[][] board;

    /**
     * Initializes an empty 3x3 board.
     */
    public TicTacToe() {
        this.board = new String[3][3];
        for (int r = 0; r < this.board.length; r++) {
            for (int c = 0; c < this.board[0].length; c++) {
                this.board[r][c] = "-";
            }
        }
    }

    // generate computer move
    // idea for future: multiple difficulties
    public String getComputerMove() {
        // TODO: implementation
        return "";
    }

    /**
     * Returns the winner of the game or
     * null if no one has won yet
     * @return the winner of the game or
     * null if no one has won yet
     */
    public String getWinner() {
        // TODO: implementation
        return "";
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
     * TODO: does main() need a documentation?
     * @param args
     */
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        System.out.println(game.toString());
        // ask for user input
        Scanner in = new Scanner(System.in);
        System.out.println("Please enter the row number of your move: ");
        while (!in.hasNextInt()) {
            String invalidRow = in.nextLine();
            System.out.printf("%s is not a valid row", invalidRow);
        }
    }
}