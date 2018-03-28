package PegJump;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Driver {
    public static void main(String[] args) {
        PegJump game = new PegJump();
        game.printBoard();
        while (!game.isGameOver()) {
            game.userInput();
            game.printBoard();
        }
    }

}

class PegJump {

    private static final int N = 15;
    private static final int ROWS = 5;

    private boolean board[][];
    private Stack<Integer> invertedPreviousMoves;

    public PegJump() {
        board = new boolean[ROWS][];
        for (int i = 0; i < ROWS; i++) {
            board[i] = new boolean[i + 1];
            for (int j = 0; j < i + 1; j++)
                board[i][j] = true;
        }
        board[0][0] = false;

        invertedPreviousMoves = new Stack<Integer>();
    }

    public void printBoard() {
        System.out.println(" ");
        //System.out.printf("0:");
        for (int iter = 0; iter <= ROWS; iter++)
            System.out.printf(" ");

        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (board[i][j])
                    System.out.printf("X ");
                else
                    System.out.printf("O ");
            }
            System.out.println();
            //System.out.printf("\n%d:", i+1);
            for (int iter = 0; iter < ROWS - i; iter++)
                System.out.printf(" ");
        }
    }

    public boolean makeMove(int srcRow, int srcIndex, int destRow, int destIndex) {
        // check validity
        if (!isValidMove(srcRow, srcIndex, destRow, destIndex)) {
            System.out.println("***INVALID MOVE***");
            return false;
        }

        board[srcRow][srcIndex] = false;
        board[(srcRow + destRow) / 2][(srcIndex + destIndex) / 2] = false;
        board[destRow][destIndex] = true;

        storeMove(srcRow, srcIndex, destRow, destIndex);

        return true;
    }

    private void storeMove(int srcRow, int srcIndex, int destRow, int destIndex) {
        // Keep this order or use a Move Object
        invertedPreviousMoves.push(destIndex);
        invertedPreviousMoves.push(destRow);
        invertedPreviousMoves.push(srcIndex);
        invertedPreviousMoves.push(srcRow);
    }

    public boolean undoMove() {
        if (invertedPreviousMoves.empty())
            return false;
        int srcRow = invertedPreviousMoves.pop();
        int srcIndex = invertedPreviousMoves.pop();
        int destRow = invertedPreviousMoves.pop();
        int destIndex = invertedPreviousMoves.pop();

        board[srcRow][srcIndex] = true;
        board[(srcRow + destRow) / 2][(srcIndex + destIndex) / 2] = true;
        board[destRow][destIndex] = false;

        return true;
    }

    // assumes all input is in bounds
    private boolean isValidMove(int srcRow, int srcIndex, int destRow, int destIndex) {
        // check input bounds
        if (srcRow < 0 || srcRow >= ROWS || destRow < 0 || destRow >= ROWS || srcIndex < 0 || srcIndex > srcRow || destIndex < 0 || destIndex > destRow)
            return false;

        return isValidJump(srcRow, srcIndex, destRow, destIndex) && arePiecesValid(srcRow, srcIndex, destRow, destIndex);
    }

    private boolean arePiecesValid(int srcRow, int srcIndex, int destRow, int destIndex) {
        if (board[srcRow][srcIndex] && !board[destRow][destIndex]) { // source filled, destination empty
            if (board[(srcRow + destRow) / 2][(srcIndex + destIndex) / 2]) // hopped piece filled
                return true;
        }

        return false;
    }

    private boolean isValidJump(int srcRow, int srcIndex, int destRow, int destIndex) {
        // check position logic
        if (srcRow == destRow) {
            if (Math.abs(srcIndex - destIndex) == 2)
                return true;
        }

        if (Math.abs(srcRow - destRow) == 2) {
            // indices must have difference less than equal to 2
            // indices must both be odd or both be even
            if (Math.abs(srcIndex - destIndex) <= 2) {
                if ((srcIndex % 2) == (destIndex % 2)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isGameOver() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < i + 1; j++) {
                if (hasMoreMoves(i, j))
                    return false;
            }
        }

        System.out.println("\t***GAME OVER***");
        return true;

    }

    private boolean hasMoreMoves(int srcRow, int srcIndex) {
        // Empty cannot move
        if (!board[srcRow][srcIndex])
            return false;

        // Check for moves in row
        for (int destIndex = srcIndex - 2; destIndex < srcIndex + 3; destIndex = destIndex + 4) {
            if (isValidMove(srcRow, srcIndex, srcRow, destIndex))
                return true;
        }

        // Check for moves outside of row
        for (int destRow = srcRow - 2; destRow < ROWS; destRow = destRow + 4) {
            for (int destIndex = srcIndex - 2; destIndex < srcIndex + 3; destIndex++) {
                if (isValidMove(srcRow, srcIndex, destRow, destIndex))
                    return true;
            }
        }

        return false;

    }

    public void userInput() {

        Scanner scanner = new Scanner(System.in);
        System.out.printf("Please input src row, src col, dest row, dest col (space delimited) or empty to undo a move: ");
        String inputLine = scanner.nextLine();
        if (inputLine.equals("")) {
            undoMove();
            return;
        }
        try {
            int[] numbers = Arrays.stream(inputLine.split(" ")).mapToInt(Integer::parseInt).toArray();
            makeMove(numbers[0], numbers[1], numbers[2], numbers[3]);
        }
        catch (Exception E) {
            System.out.println("***Invalid Input***");
            userInput();
        }
    }
}
