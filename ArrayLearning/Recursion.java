
import java.util.Arrays;



public class Recursion{

    static int fiboSum(int n){
        if(n<2)return n;
        return fiboSum(n-1)+fiboSum(n-2);
    }

    static void fiboList(int n){
        int num1=0;
        int num2=1;
        for(int i=0;i<n;i++){
            if(i<2)System.err.print(i+" ");
            else {
                int sum = num1+num2;
                System.err.print(sum+" ");
                num1=num2;
                num2=sum;
            }
        }
    }
    
    static int reverseNumber(int target){
        if((target/10)==0)return target;
        int result=(target%10)*(int)(Math.pow(10,Math.floor(Math.log(target)/Math.log(10)))) + reverseNumber(target/10);
        return result;
    }

    static String reverNumber2(int target){
        if(target/10==0)return String.valueOf(target);
        return target%10+""+reverNumber2(target/10);
    }

    static int factorial(int n){
        if(n==1)return 1;
        return n*factorial(n-1);
    }

    static int digitSum(int n){
        if(n==0)return 0;
        return n%10+digitSum(n/10);
    }
    
    static boolean isPalandrome(int number){
        return number==reverseNumber(number);
    }

    static int zeroCount(int number){
        if(number==0)return 0;
        return number%10==0 ? 1+zeroCount(number/10):zeroCount(number/10);
    }

    static int targetInRotatedBinarySearch(int arr[],int target,int s,int e){
        if(s>e)return -1;
        int mid=s+(e-s)/2;
        if(target==arr[mid])return mid;
        if(arr[s]<=arr[mid])
        {
            if(arr[s]<=target&&target<arr[mid])return targetInRotatedBinarySearch(arr, target, s, mid-1);
            else return targetInRotatedBinarySearch(arr, target, mid+1, e);
        }
        else
        {
            if(target<=arr[e]&&target>arr[mid])return targetInRotatedBinarySearch(arr, target, mid+1, e);
            return targetInRotatedBinarySearch(arr, target, s, mid-1);
        }
    }

    static int pivotInRotatedArray(int arr[],int s,int e)
    {
        if(s>e)return 0;
        if(arr[s]<arr[e])return s;
        int mid=s+(e-s)/2;
        if(mid+1<=e && arr[mid]>arr[mid+1])return mid+1;
        if(arr[mid]>=arr[s])return pivotInRotatedArray(arr, mid+1, e);
        else return pivotInRotatedArray(arr,  s, mid);
    }

    static int[] mergeArray(int[] left,int right[])
    {
        int[] combinedArray=new int[left.length+right.length];
        int currIndex=0;
        int leftIndex=0;
        int rightIndex=0;
        for(;leftIndex<left.length&&rightIndex<right.length;currIndex++)
        {
            if(left[leftIndex]<right[rightIndex])
            {
                combinedArray[currIndex]=left[leftIndex];
                leftIndex++;
            }
            else 
            {
                combinedArray[currIndex]=right[rightIndex];
                rightIndex++;
            }
        }
        while(leftIndex<left.length){
            combinedArray[currIndex]=left[leftIndex];
            leftIndex++;
            currIndex++;
        }
        while (rightIndex<right.length) { 
            combinedArray[currIndex]=right[rightIndex];
            rightIndex++;
            currIndex++;
        }
        return combinedArray;
    }

    static int[] mergeSort(int arr[],int s,int e)
    {
        if(e-s==0)return new int[]{arr[s]};
        int mid=s+(e-s)/2;
        int left[]=mergeSort(arr, s, mid);
        int right[]=mergeSort(arr, mid+1, e);
        return mergeArray(left, right);
    }

    static void quickort(int arr[],int low,int high)
    {
        if(low>=high)return ;
        int start=low;
        int end=high;
        int mid=start+(end-start)/2;
        int pivot=arr[mid];
        while(start<=end)
        {
            while(arr[start]<pivot)
            {
                start++;
            }
            while(arr[end]>pivot)
            {
                end--;
            }
            if(start<=end)
            {
                int temp=arr[start];
                arr[start]=arr[end];
                arr[end]=temp;
                start++;
                end--;
            }
        }
        quickort(arr, low, end);
        quickort(arr, start, high);
    }

  
    public static void main(String[] s){
        // System.err.println(fiboSum(10));
        // System.err.println(Integer.parseInt(reverNumber2(1000)));
        // System.out.println(isPalandrome(0001));
        // int[] arr={5,5,0,5};
        // System.out.println(pivotInRotatedArray(arr,0,arr.length-1));
        int target[]={12,1,2};
        quickort(target,0,target.length-1);
        System.out.println(Arrays.toString(target));
    }
}