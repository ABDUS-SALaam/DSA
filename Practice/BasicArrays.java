class BasicArrays
{


   public static int targetInRotatedStortedArray(int arr[],int target,int start,int end)
    {
        if(start>end)return -1;
        int mid=start+(end-start)/2;
        if(arr[mid]==target)return mid;
        if (arr[start]<=arr[mid]) {
            if(target<arr[mid]&&target>=arr[start])
            {
                return targetInRotatedStortedArray(arr, target, start, mid-1);
            }
            else 
            {
                return targetInRotatedStortedArray(arr, target, mid+1, end);
            }
        }
        else
        {
           if(arr[mid]<target&&arr[end]>=target)
           {
            return targetInRotatedStortedArray(arr, target, mid+1, end);
           }
           else return targetInRotatedStortedArray(arr, target, start, mid-1);
        }
    };


    public static int noOfTimesSortedArrayRotated(int arr[],int start,int end)
    {
        if(start>end)return -1;
        if(arr[start]<arr[end])return -1;
        int mid=start+(end-start)/2;
        if(mid+1<arr.length && arr[mid]>arr[mid+1]){
            return mid+1;
        }
        if (mid-1>=0 && arr[mid]<arr[mid-1]) {
            return mid;
        }
        if(arr[mid]>arr[start])
        {
            return noOfTimesSortedArrayRotated(arr, mid+1, end);
        }
        else return noOfTimesSortedArrayRotated(arr, start, mid-1);
    }
    


 
    public static void main(String[] args) {
        int arr[]=new int[]{3,3,1,1,2,3,3};
        // System.out.println(targetInRotatedStortedArray(arr,0,0,arr.length-1));
        System.out.println(noOfTimesSortedArrayRotated(arr,0,arr.length-1));

    }
}