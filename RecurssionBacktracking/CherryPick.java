
public class CherryPick {

    public static void reverseArray(int arr[][]) {
        int row = 0;
        while (row < arr.length) {
            int col = 0;
            while (col < arr.length && col <= row) {
                int temp = arr[row][col];
                arr[row][col] = arr[col][row];
                arr[col][row] = temp;
                col++;
            }
            row++;
        }
        for (int[] arr1 : arr) {
            for (int j = 0; j < arr.length / 2; j++) {
                int temp = arr1[j];
                int inverseIndex = arr.length - j - 1;
                arr1[j] = arr1[inverseIndex];
                arr1[inverseIndex] = temp;
            }
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int temp[] = arr[i];
            int inverseIndex = arr.length - i - 1;
            arr[i] = arr[inverseIndex];
            arr[inverseIndex] = temp;
        }
    }

    public static int maxPick(int arr[][], int row, int col, int count) {
        int currentValue = arr[row][col];
        if (arr.length - 1 == row && arr[0].length - 1 == col) {
            return currentValue != -1 ? count + currentValue : 0;
        }
        if (currentValue == -1) {
            return 0;
        }
        int rightCount = 0;
        int downCount = 0;
        if (col < arr[0].length - 1) {
            rightCount = maxPick(arr, row, col + 1, count + currentValue);
        }
        if (row < arr.length - 1) {
            downCount = maxPick(arr, row + 1, col, count + currentValue);
        }
        if (rightCount > downCount || (rightCount == downCount && rightCount != 0)) {
            if (arr[row][col + 1] != -1) {
                arr[row][col + 1] = 0;
            }
        }
        if (rightCount < downCount) {
            if (arr[row + 1][col] != -1) {
                arr[row + 1][col] = 0;
            }
        }

        return rightCount > downCount ? rightCount : downCount;
    }

    public static int cherryPickup(int[][] grid) {
        // int firstTraverseCount = maxPick(grid, 0, 0, 0);
        // if (firstTraverseCount == 0) {
        //     return 0;
        // }
        // grid[0][0] = 0;
        // reverseArray(grid);
        return maxPick(grid, 0, 0, 0);
    }

    public static int maxCherries = 0;

    public static void helper(int[][] arr, int row, int col, int cc) {
        if (row < 0 || col < 0 || arr[row][col] == -1) {
            return;
        }
        int cherries = arr[row][col];
        if (row == 0 && col == 0) {
            maxCherries = Math.max(maxCherries, cc + cherries);
        }
        arr[row][col] = 0;
        helper(arr, row, col - 1, cc + cherries);
        helper(arr, row - 1, col, cc + cherries);
        arr[row][col] = cherries;
    }

    public static void cherryCollector(int[][] arr, int row, int col, int cc) {
        if (row >= arr.length || col >= arr.length || arr[row][col] == -1) {
            return;
        }
        int cherries = arr[row][col];
        if (row == arr.length - 1 && col == arr.length - 1) {
            helper(arr, row, col, cc);
        }
        arr[row][col] = 0;
        cherryCollector(arr, row, col + 1, cc + cherries);
        cherryCollector(arr, row + 1, col, cc + cherries);
        arr[row][col] = cherries;

    }

    public static void main(String[] args) {
        int arr[][] = {
            {1, 1, -1},
            {1, -1, 1},
            {-1, 1, 1}};
        cherryCollector(arr, 0, 0, 0);
        System.out.println(maxCherries);
        // System.out.println(maxPick(arr, 0, 0, 0));
        // for (int[] a : arr) {
        //     System.out.println(Arrays.toString(a));
        // }

    }
}
