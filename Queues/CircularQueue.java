
public class CircularQueue {

    public static int findMin(int[] nums) {
        int min = minInRotatedSortedArray(nums, 0, nums.length - 1);
        return min;
    }

    public static int minInRotatedSortedArray(int[] arr, int s, int e) {
        if (s >= e) {
            return arr[s];
        }
        if (arr[s] <= arr[e]) {
            return arr[s];
        }
        int m = s + (e - s) / 2;
        int mid = arr[m];
        if (m - 1 >= s && arr[m - 1] > mid) {
            return mid;
        }
        if (mid + 1 <= e && arr[mid + 1] < mid) {
            return arr[mid + 1];
        }
        if (arr[s] < mid) {
            return minInRotatedSortedArray(arr, m + 1, e);
        } else if (arr[s] > mid) {
            return minInRotatedSortedArray(arr, s, m - 1);
        } else {
            return minInRotatedSortedArray(arr, s, e - 1);
        }
    }

    // NOTE : If we want to extend this CustomCircularQueue to be dynamic then the below CustomCircularQueue doesnt support it.
    // REASON : CustomCircularList to be in a way that first and last are always in range of [0,listLength)
    // SOLUTION : Keep making first and last  modulus with list length on every insertion or deletion (first % listLength or last % listLength)
    public static void main(String[] args) {
        try {

            System.out.println(findMin(new int[]{3, 1}));
            // CustomCircularQueue queue = new CustomCircularQueue(5);
            // queue.insert(1);
            // queue.insert(2);
            // queue.insert(3);
            // queue.insert(4);
            // queue.insert(5);
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // queue.insert(6);
            // queue.insert(7);
            // queue.insert(8);
            // queue.insert(9);
            // queue.insert(10);
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // System.out.println(queue.remove());
            // queue.display();

        } catch (Exception e) {
            System.out.println("Exception occured " + e);
        }
    }
}

class CustomCircularQueue {

    int[] arr = new int[]{};
    int first = 0;
    int last = -1;
    // int arrLength = this.arr.length;

    private final static int DEFAULT_SIZE = 10;

    public CustomCircularQueue() {
        this(DEFAULT_SIZE);
    }

    public CustomCircularQueue(int size) {
        this.arr = new int[size];
    }

    public boolean insert(int value) {
        int arrLength = this.arr.length;
        if (isFull()) {
            return false;
        }
        this.arr[++this.last % arrLength] = value;
        return true;
    }

    public int remove() throws CircularQueueException {
        if (isEmpty()) {
            throw new CircularQueueException("Cannot remove from empty queue");
        }
        int arrLength = this.arr.length;
        int value = this.arr[this.first++ % arrLength];
        return value;
    }

    public boolean isFull() {
        int arrLength = this.arr.length;
        return this.last - this.first == arrLength - 1 || (this.last % arrLength - this.first % arrLength == - 1 && this.first != 0);
    }

    public boolean isEmpty() {
        // int arrLength = this.arr.length;
        // return this.last % arrLength - this.first % arrLength == -1;
        return this.first > this.last;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        int ptr = this.first;
        while (ptr <= this.last) {
            System.out.print(arr[ptr++ % this.arr.length] + " -> ");
        }
    }

}

class CircularQueueException extends Exception {

    public CircularQueueException(String message) {
        super(message);
    }
}
