
import java.util.ArrayList;
import java.util.Stack;

public class BasicStacks {

    public static int[] previousMin(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(arr[i]);

        }
        return result;
    }

    public static int[] NextMin(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= s.peek()) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(arr[i]);

        }
        return result;
    }

    public static int[] prevMinIndex(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public static int[] NextMinIndex(int[] arr) {
        int[] result = new int[arr.length];
        Stack<Integer> s = new Stack<>();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[i] <= arr[s.peek()]) {
                s.pop();
            }
            if (s.isEmpty()) {
                result[i] = arr.length;
            } else {
                result[i] = s.peek();
            }
            s.push(i);
        }
        return result;
    }

    public static int[] previousMax(int[] arr) {
        int[] temp = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                temp[i] = -1;
                stack.push(arr[i]);
            } else {
                temp[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return temp;
    }

    public static int[] nextMax(int[] arr) {
        int[] temp = new int[arr.length];
        Stack<Integer> stack = new Stack();
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                temp[i] = -1;
                stack.push(arr[i]);
            } else {
                temp[i] = stack.peek();
                stack.push(arr[i]);
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 6, 2, 3};
        // System.out.println(Arrays.toString(previousMin(arr)));
        // System.out.println(Arrays.toString(NextMin(arr)));
        // System.out.println(Arrays.toString(prevMinIndex(arr)));
        // System.out.println(Arrays.toString(NextMinIndex(arr)));
        // System.out.println(Arrays.toString(previousMax(arr)));
        // System.out.println(Arrays.toString(nextMax(arr)));

        StockSpanner ss = new StockSpanner();
        System.out.println(ss.next(100));
        System.out.println(ss.next(80));
        System.out.println(ss.next(60));
        System.out.println(ss.next(70));
        System.out.println(ss.next(60));
        System.out.println(ss.next(75));
        System.out.println(ss.next(85));

    }
}

class StockSpanner {

    Stack<Integer> stack;
    ArrayList<Integer> al;

    public StockSpanner() {
        this.stack = new Stack();
        this.al = new ArrayList<>();
    }

    public int next(int price) {
        al.add(price);
        if (stack.isEmpty()) {
            stack.push(al.size() - 1);
            return 1;
        } else {
            while (!stack.isEmpty() && al.get(stack.peek()) <= price) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                stack.push(al.size() - 1);
                return 1;
            } else {
                int index = stack.peek();
                stack.push(al.size() - 1);
                return al.size() - index;
            }
        }

    }
}
