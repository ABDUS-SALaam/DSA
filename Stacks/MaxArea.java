
import java.util.Stack;

public class MaxArea {

    public static int[] leftMin(int arr[]) {
        int left[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = -1;
                stack.push(arr[i]);
            } else {
                left[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return left;
    }

    public static int[] rightMin(int arr[]) {
        int right[] = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= stack.peek()) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                right[i] = arr.length;
                stack.push(arr[i]);
            } else {
                right[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return right;
    }

    public static int maxAreaInHistogram(int[] array) {
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        left = leftMin(array);
        right = rightMin(array);
        int max = 0;
        for (int i = 0; i < array.length; i++) {
            max = Math.max((right[i] - left[i] - 1) * array[i], max);
        }
        return max;
    }

    public static int calculateArea(char[][] matrix) {
        int arrayLength = matrix[0].length;
        int[] array = new int[arrayLength];
        int row = 0;
        int result = 0;
        while (row < matrix.length) {
            for (int i = 0; i < arrayLength; i++) {
                char value = matrix[row][i];
                int parsedValue = value - '0';
                if (parsedValue == 0 && array[i] != 0) {
                    array[i] = 0;
                } else {
                    array[i] += parsedValue;
                }
            }
            result = Math.max(maxAreaInHistogram(array), result);
            row++;
        }
        return result;
    }

    public static int maximalRectangle(char[][] matrix) {
        return calculateArea(matrix);
    }

    public static void main(String[] args) {
        char[][] matrix = {
            {'1', '0'}
        };
        System.out.println("result is: " + maximalRectangle(matrix));
    }

}
