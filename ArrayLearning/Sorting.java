
import java.util.Arrays;

public class Sorting {

    public static int[] bubbleSort(int[] target) {

        int targetLength = target.length;
        if (targetLength <= 1) {
            return target;
        }
        for (int i = targetLength - 1; i >= 1; i--) {

            for (int j = 0; j < i; j++) {
                if (target[j] > target[j + 1]) {
                    int temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
        }
        return target;
    }

    // This is stable sort algo
    public static int[] bubbleSortOptimised(int[] target) {
        int i, j, temp;
        boolean swapped;
        int targetLength = target.length;
        for (i = 0; i < targetLength - 1; i++) {
            swapped = false;
            for (j = 0; j < targetLength - i - 1; j++) {
                if (target[j] < target[j + 1]) {
                    swapped = true;
                    temp = target[j];
                    target[j] = target[j + 1];
                    target[j + 1] = temp;
                }
            }
            if (!swapped) {
                return target;
            }
        }
        return target;
    }

    // This is stable sort
    public static int[] insertionSort(int[] target) {
        int i, j, temp;
        int targetLength = target.length;
        for (i = 1; i <= targetLength - 1; i++) {
            for (j = i; j > 0; j--) {
                if (target[j] < target[j - 1]) {
                    temp = target[j];
                    target[j] = target[j - 1];
                    target[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        return target;
    }

    // This isn't stable sort
    public static int[] selectionSort(int[] target) {
        int i, j, temp, maxIndex;
        for (i = target.length - 1; i > 0; i--) {
            maxIndex = 0;
            for (j = 0; j <= i; j++) {
                if (target[maxIndex] < target[j]) {
                    maxIndex = j;
                }
            }
            if (i != maxIndex) {
                temp = target[i];
                target[i] = target[maxIndex];
                target[maxIndex] = temp;
            }

        }
        return target;
    }

    public static void quickSort(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }
        int pivot = partition(arr, start, end);
        quickSort(arr, start, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    public static int partition(int arr[], int start, int end) {

        int pos = start;
        int pivot = arr[end];
        for (int i = start; i <= end; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[pos];
                arr[pos] = arr[i];
                arr[i] = temp;
                pos++;
            }
        }
        return pos - 1;

    }

    public static void quickSortApproach2(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int low = start;
        int high = end;
        int pivot = arr[start + (end - start) / 2];
        while (low <= high) {
            while (arr[low] < pivot) {
                low++;
            }
            while (arr[high] > pivot) {
                high--;
            }
            if (low <= high) {
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
                low++;
                high--;
            }
        }
        quickSortApproach2(arr, start, high);
        quickSortApproach2(arr, low, end);

    }

    public static int[] qs(int[] arr, int i, int j) {
        if (i >= j) {
            return arr;
        }
        int start = i;
        int end = j;
        int pivot = arr[start + (end - start) / 2];
        while (start < end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (arr[end] > pivot) {
                end--;
            }
            if (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        qs(arr, i, end);
        qs(arr, start, j);
        return arr;
    }

    public static void rotate(int[] nums, int k) {
        int[] result = new int[nums.length];
        int rotateBy = nums.length - (k % nums.length);
        for (int i = 0; i < nums.length; i++) {
            result[i] = nums[(rotateBy + i) % nums.length];
        }
        System.out.println(Arrays.toString(result));
    }

    public static void main(String[] args) {
        int[] target = {1, 2, 3, 4, 5};
        System.out.println(Arrays.toString(target));
        rotate(target, 3);
        // System.out.println("Sorted String is "+ Arrays.toString(selectionSort(target)));
        // qs(target, 0, target.length - 1);
        // System.out.println(Arrays.toString(target));
    }
}
