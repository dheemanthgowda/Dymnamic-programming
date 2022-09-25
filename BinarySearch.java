/**
 * Find first occurrence in sorted array
 *  [cerner_2tothe5th_2022]
 *  "cerner_2^5_2022"
 *  Author: Dheemanth G K(DG072881)
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arrFirstOccurence = new int[]{1,2,3,3,3,3,4,5,6,7,8};
        System.out.println(findFirstOccurence(arrFirstOccurence, 0, arrFirstOccurence.length-1, 3));
    }


    private static int findFirstOccurence(int[] arr, int start, int end, int searchEle) {
        int res = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] ==  searchEle) {
                res = mid;
                end  = mid - 1;
            } else if(searchEle < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}
