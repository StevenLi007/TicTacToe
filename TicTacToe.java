/**
 * TODO: file header
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
     */
    public void play() {
        // TODO: implementation
        System.out.println(this.toString());
        Scanner input = new Scanner(System.in);
        boolean validMove = false;
        while (!validMove) {
            System.out.println("Input the row number of your move: ");
            int row = input.nextInt();
            System.out.println("Input the column number of your move: ");
            int col = input.nextInt();
            if (this.board[row][col] == null) {
                this.board[row][col] = "x";
                validMove = true;
            }
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