/**
 *  [cerner_2tothe5th_2022]
 *  Author: Dheemanth G K(DG072881)
 */
public class FindNearestAlphabetOfAGivenChar {

    public static void main(String[] args) {
        System.out.println(floorEle(new char[]{'a', 'b','d','e','f','g','i','j','k'},'c'));
    }
    private static char floorEle(char[] arr, char ele) {
        int start = 0;
        int end = arr.length - 1;
        int res = -1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(arr[mid] == ele) {
                return arr[mid];
            } else if(ele < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
                res = mid;
            }
        }
        return arr[res];
    }
}
