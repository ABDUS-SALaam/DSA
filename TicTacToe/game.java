
import java.util.Scanner;

public class game {

    public static boolean isGameOver(char[][] board) {
        boolean isGameOver = true;
        for (char[] row : board) {
            for (char value : row) {
                if (value == ' ') {
                    return false;
                }
            }
        }
        return isGameOver;
    }

    public static void print(char[][] board) {
        for (char[] row : board) {
            for (char value : row) {
                System.out.print(" | " + value);
            }
            System.out.print(" |");
            System.out.println();
        }
        System.out.println("");
    }

    public static boolean isValid(char[][] board, int i, int j) {
        if (i >= board.length || j >= board.length) {
            return false;
        }
        return board[i][j] == ' ';
    }

    public static boolean hasWonGame(char[][] board, char player) {
        for (char[] row : board) {
            if (row[0] == player && row[1] == player && row[2] == player) {
                return true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            char activePlayer = 'X';
            char board[][] = new char[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = ' ';
                }
            }
            while (!isGameOver(board)) {
                System.out.println(activePlayer + "'s turn");
                System.out.println("Enter coordinates: ");
                int i = scanner.nextInt();
                int j = scanner.nextInt();
                if (isValid(board, i, j)) {
                    board[i][j] = activePlayer;
                    if (hasWonGame(board, activePlayer)) {
                        System.out.println("Player : " + activePlayer + " has won game!! ");
                        print(board);
                        break;
                    }
                    activePlayer = activePlayer == 'X' ? 'O' : 'X';
                } else {
                    System.out.println("Invalid move, Enter again");
                }
                print(board);
            }
        }
    }
}
