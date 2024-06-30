
import java.util.Arrays;

public class ArrayMisc {
    
    public static int[] rotatedArrayByN(int arr[],int units)
    {
        // rotated by 2 -> [1,2,3,4] => [3,4,1,2]
        int[] rotatedArray=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            rotatedArray[i]=arr[(i+units)%arr.length];
        }
        return rotatedArray;
    }
    
    
    public static void main(String[] args) {
        System.out.println("Rotated array is : "+Arrays.toString(rotatedArrayByN(new int[]{1,2,3,4,5,6}, 3)));
    }
}
