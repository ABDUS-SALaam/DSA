
import java.util.Arrays;

public class Sorting {
    public static int[] bubbleSort(int[] target){

        int targetLength=target.length;
        if(targetLength<=1)return target;
        for(int i=targetLength-1;i>=1;i--){
            
            for(int j=0;j<i;j++){
                if(target[j] > target[j+1]){
                    int temp=target[j];
                    target[j]=target[j+1];
                    target[j+1]=temp;
                }
            }
        }
        return target;
    }

    // This is stable sort algo
    public static int[] bubbleSortOptimised(int[] target){
        int i, j ,temp;
        boolean swapped;
        int targetLength=target.length;
        for(i=0;i<targetLength-1;i++){
            swapped=false;
            for(j=0;j<targetLength-i-1;j++){
                if(target[j]<target[j+1]){
                    swapped=true;
                    temp=target[j];
                    target[j]=target[j+1];
                    target[j+1]=temp;
                }
            }
            if(!swapped)return target;
        }
        return target;
    }

    // This is stable sort
    public static int[] insertionSort(int[] target){
        int i, j, temp;
        int targetLength=target.length;
        for(i=1;i<=targetLength-1;i++){
            for(j=i;j>0;j--){
                if(target[j]<target[j-1]){
                    temp=target[j];
                    target[j]=target[j-1];
                    target[j-1]=temp;
                }
                else break;
            }
        }
        return target;
    }

    // This isn't stable sort
    public static int[] selectionSort(int[] target){
        int i, j, temp, maxIndex;
        for (i=target.length-1;i>0;i--){
            maxIndex=0;
            for(j=0;j<=i;j++){
                if(target[maxIndex]<target[j]){
                    maxIndex=j;
                }
            }
            if(i!=maxIndex){
                temp=target[i];
                target[i]=target[maxIndex];
                target[maxIndex]=temp;
            }

        }
        return target;
    }
    public static void main(String[] args){
        int[] target={7,8,5,4,3,2,1,0};
        System.out.println("Sorted String is "+ Arrays.toString(selectionSort(target)));
    }
}
