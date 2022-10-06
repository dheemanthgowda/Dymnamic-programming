/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater
 * than a neighbor that is outside the array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 */
public class FindPeakEleIndex {
    public static void main(String[] args) {
        int[] arrPeak = new int[]{1,2,3,1};
        System.out.println(findPeakElement(arrPeak));
    }
    public static int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        while(start <= end) {
            int mid = start + (end - start)/2;
            if(mid > 0 && mid < nums.length - 1) {
                if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1]) { return mid; }
                else if(nums[mid + 1] > nums[mid]) { start = mid + 1; }
                else { end = mid - 1; }
            } else if(mid == 0) {
                if(nums[mid] > nums[mid +1]) { return mid; }
                else { return mid +1; }
            } else {
                if(nums[mid - 1] > nums[mid]) {
                    return mid - 1;
                } else {
                    return mid;
                }
            }
        }
        return -1;
    }
}
