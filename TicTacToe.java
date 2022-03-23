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
    }

    /**
     * Plays the game.
     * TODO: it relies on many helper methods; how do we make that clear (curr description a bit vague)?
     * TODO: I'm concerned that this method is a bit large; make sure that it's self documenting and has a specific role
     */
    public void play() {
        // TODO: implementation
        System.out.println(this.toString());
        Scanner input = new Scanner(System.in);
        System.out.println("Input the row number of your move: ");
        if (input.hasNextInt()) {
            if (input.nextInt() >= 1 && input.nextInt() <= 3) {
                int row = input.nextInt();
            }

        }
        while (!input.hasNextInt() || input.nextInt() > 3) {
            String invalidRow = input.next();
            System.out.println(String.format("%s is not a valid row number", invalidRow));
        }
        int row = input.nextInt();
        System.out.println("Input the column number of your move: ");
        int col = input.nextInt();
        if (this.board[row][col] == null) {
            this.board[row][col] = "x";
        }
        if (this.getWinner() == "Player") {
            System.out.println("You won! Would you like to play again?" +
                "(Type Y/N): ");
            String replayChoice = input.nextLine().toLowerCase();
            if (replayChoice.equals("y")) {
                this.play();
            }
        } else {
            // ask for computer move
            // make computer move
            // check for win
        }
        // how to prevent crash when given inappropriate input?
        System.out.println(this.toString());
    }

    // get the user input
    // what format?
    // this may be unnecessary
    public String getPlayerMove() {
        // TODO: implementation
        return "";
    }

    // generate computer move
    // idea for future: multiple difficulties
    public String getComputerMove() {
        // TODO: implementation
        return "";
    }

    // has anyone won?
    // is there an efficient way to check?
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
        // TODO: implementation
        return "";
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        game.play();
    }
}