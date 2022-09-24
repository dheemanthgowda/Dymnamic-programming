/**
 *  * [cerner_2tothe5th_2022]
 *  * "cerner_2^5_2022"
 *  * Author: Dheemanth G K(DG072881)
 */
public class FindKinRotatedArray {
    public static void main(String[] args) {
        int[] arrRotate = new int[]{2,3,4,5,6,7,1};
        System.out.println(findKRotation(arrRotate, 7));
    }

    private static  int findKRotation(int arr[], int n) {
        // code here
        int start = 0;
        int end = n - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            int prev = (mid + n - 1) % n;
            int next = (mid + 1) % n;
            if(arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            } else if(arr[start] <= arr[mid]) { //Check if it's sorted then move the search space to the remaining one.
                start = mid + 1;
            } else if(arr[mid] <= arr[end]) {
                end = mid - 1;
            }

        }
        return 0;
    }
}
