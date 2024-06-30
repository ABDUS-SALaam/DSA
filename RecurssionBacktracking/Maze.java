
public class Maze {

    public static void allPaths(int rows, int cols) {
        printAllPaths(rows, cols, "");
        int count = countAllPaths(3, 3);
        System.out.println("\nNo of paths " + count);
    }

    public static void printAllPaths(int rowCount, int colCount, String path) {
        if (rowCount == 1 && colCount == 1) {
            System.out.print(path + " ");
        }
        if (rowCount > 1) {
            printAllPaths(rowCount - 1, colCount, path + "D");
        }
        if (colCount > 1) {
            printAllPaths(rowCount, colCount - 1, path + "R");
        }
    }

    public static int countAllPaths(int rowCount, int colCount) {
        if (rowCount == 1 && colCount == 1) {
            return 1;
        }
        int left = 0, right = 0;
        if (rowCount > 1) {
            left = countAllPaths(rowCount - 1, colCount);
        }
        if (colCount > 1) {
            right = countAllPaths(rowCount, colCount - 1);
        }
        return left + right;
    }

    public static void printAllPathsAllDirections(int row, int col, String path, boolean[][] arr, int[][] selectedPath, int step) {
        if (row == 2 && col == 2) {
            selectedPath[row][col] = step;
            for (int[] selectedPathRow : selectedPath) {
                System.err.print("[ ");
                for (int a : selectedPathRow) {
                    System.err.print(a + " ");
                }
                System.err.println("]");
            }
            System.out.println(path + "\n");
            return;
        }
        if (arr[row][col]) {
            return;
        }
        arr[row][col] = true;
        selectedPath[row][col] = step;
        if (row < 2) {
            printAllPathsAllDirections(row + 1, col, path + "D", arr, selectedPath, step + 1);
        }
        if (col < 2) {
            printAllPathsAllDirections(row, col + 1, path + "R", arr, selectedPath, step + 1);
        }
        if (row > 0) {
            printAllPathsAllDirections(row - 1, col, path + "U", arr, selectedPath, step + 1);
        }
        if (col > 0) {
            printAllPathsAllDirections(row, col - 1, path + "L", arr, selectedPath, step + 1);
        }
        arr[row][col] = false;
        selectedPath[row][col] = 0;
    }

    public static int nQueens(boolean[][] box, int row) {
        if (row == box.length) {
            printBox(box);
            System.err.println();
            return 1;
        }
        int count = 0;
        for (int col = 0; col < box.length; col++) {
            if (isCorrectPosition(box, row, col)) {
                box[row][col] = true;
                count += nQueens(box, row + 1);
                box[row][col] = false;
            }
        }
        return count;
    }

    public static boolean isCorrectPosition(boolean[][] box, int row, int col) {
        // check vertically
        for (int i = 0; i < row; i++) {
            if (box[i][col]) {
                return false;
            }
        }
        // check on left diaognal
        int maxLeft = Math.min(row, col);
        for (int i = 1; i <= maxLeft; i++) {
            if (box[row - i][col - i]) {
                return false;
            }
        }
        // check on right diaognal
        int maxRight = Math.min(row, box.length - col - 1);
        for (int i = 1; i <= maxRight; i++) {
            if (box[row - 1][col + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void printBox(boolean[][] box) {
        for (boolean[] row : box) {
            for (boolean value : row) {
                if (value) {
                    System.err.print("Q ");
                } else {
                    System.err.print("N ");
                }
            }
            System.err.println();
        }
    }

    public static void nKnight(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            display(board);
            System.out.println("");
            return;
        }
        if (row == board.length) {
            return;
        }

        if (col == board.length) {
            nKnight(board, row + 1, 0, knight);
            return;
        }
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            nKnight(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }
        nKnight(board, row, col + 1, knight);
    }

    public static boolean isSafe(boolean[][] board, int row, int col) {
        if (isValidPosition(board, row - 2, col - 1)) {
            if (board[row - 2][col - 1]) {
                return false;
            }
        }
        // if(isValidPosition(board, row+2, col-1))
        // {
        //     if(board[row-2][col-1])
        //     {
        //         return  false;
        //     }
        // }
        //  if(isValidPosition(board, row+2, col+1))
        // {
        //     if(board[row-2][col-1])
        //     {
        //         return  false;
        //     }
        // }
        if (isValidPosition(board, row - 2, col + 1)) {
            if (board[row - 2][col + 1]) {
                return false;
            }
        }
        // if(isValidPosition(board, row+1, col+2))
        // {
        //     if(board[row-2][col-1])
        //     {
        //         return  false;
        //     }
        // }
        if (isValidPosition(board, row - 1, col + 2)) {
            if (board[row - 1][col + 2]) {
                return false;
            }
        }
        // if(isValidPosition(board, row+1, col-2))
        // {
        //     if(board[row-2][col-1])
        //     {
        //         return  false;
        //     }
        // }
        if (isValidPosition(board, row - 1, col - 2)) {
            if (board[row - 1][col - 2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isValidPosition(boolean[][] board, int row, int col) {
        return row < board.length && row >= 0 && col < board.length && col >= 0;
    }

    public static void display(boolean[][] board) {
        for (boolean row[] : board) {
            for (int i = 0; i < row.length; i++) {
                if (row[i]) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println("");
        }
    }

    public static int nKnightCount(boolean[][] board, int row, int col, int knight) {
        if (knight == 0) {
            // display(board);
            // System.out.println("");
            return 1;
        }
        if (row == board.length) {
            return 0;
        }

        if (col == board.length) {
            return nKnightCount(board, row + 1, 0, knight);
        }
        int count = 0;
        if (isSafe(board, row, col)) {
            board[row][col] = true;
            count = count + nKnightCount(board, row, col + 1, knight - 1);
            board[row][col] = false;
        }
        count = count + nKnightCount(board, row, col + 1, knight);
        return count;
    }

    public static boolean sodokuSolver(char[][] box, int row, int col) {
        if (row == box.length) {
            return true;
        }
        if (col == box.length) {
            return sodokuSolver(box, row + 1, 0);
        }
        if (box[row][col] != '.') {
            return sodokuSolver(box, row, col + 1);
        }
        for (int i = 1; i <= 9; i++) {
            if (isSafePosition(box, row, col, i)) {
                box[row][col] = (char) (i + '0');
                boolean result = sodokuSolver(box, row, col + 1);
                if (result) {
                    return result;
                }
                box[row][col] = '.';
            }
        }
        return false;
    }

    public static boolean isSafePosition(char[][] box, int row, int col, int newValue) {

        char value = (char) ('0' + newValue);
        for (int i = 0; i < box.length; i++) {
            if (box[row][i] == value) {
                return false;
            }
            if (box[i][col] == value) {
                return false;
            }
        }

        int startRow = row - row % (int) Math.sqrt(box.length);
        int startCol = col - col % (int) Math.sqrt(box.length);
        for (int i = startRow; i <= startRow + 2; i++) {
            for (int j = startCol; j <= startCol + 2; j++) {
                if (box[i][j] == value) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void display(char[][] box) {
        for (char[] row : box) {
            for (int i = 0; i < row.length; i++) {
                System.out.print(row[i] + " ");
            }
            System.out.println();
        }
    }

    public static char[][] convertStringArrayToChar(String board[][]) {
        char[][] box = new char[board.length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                box[i][j] = board[i][j].charAt(0);
            }
        }
        return box;
    }

    public static void main(String[] args) {
        // printAllPathsAllDirections(0, 0,"",new boolean[3][3],new int[3][3],1);
        // System.err.println(nQueens(new boolean[5][5], 0));
        // nKnight(new boolean[4][4], 0, 0, 4);
        String[][] board = new String[][]{
            {"5", "3", ".", ".", "7", ".", ".", ".", "."},
            {"6", ".", ".", "1", "9", "5", ".", ".", "."},
            {".", "9", "8", ".", ".", ".", ".", "6", "."},
            {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
            {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
            {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
            {".", "6", ".", ".", ".", ".", "2", "8", "."},
            {".", ".", ".", "4", "1", "9", ".", ".", "5"},
            {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        char box[][] = convertStringArrayToChar(board);
        boolean result = sodokuSolver(box, 0, 0);

        if (result) {
            display(box);
        } else {
            System.out.println("No solutions found!!");
        }
    }

}
