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
        // print current board
        System.out.println(this.toString());
        // ask for player move
        Scanner input = new Scanner(System.in);
        String playerMove = input.nextLine();
        // parse player move (how to check for inappropriate input?)
        int row = Integer.parseInt(playerMove.substring(0, 1));
        int col = Integer.parseInt(s)
        // check player move validity
        // make player move
        // check for win
        // ask for computer move
        // make computer move
        // check for win
        // print current board
        System.out.println(this.toString());
        // depending on if game ends, repeat or end game
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