import java.util.Collections;
import java.util.PriorityQueue;
/**
 *  [cerner_2tothe5th_2022]
 *  Author: Dheemanth G K(DG072881)
 * Given an array and a number K where K is smaller than the size of the array. Find the K’th smallest element in the given unsorted array.
 * Given that all array elements are distinct.
 */
public class FindKthSmallestEle {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,1,6,7,8,9,10,12};
        findKthSmallestNumber(arr, 3);
    }

    private static void findKthSmallestNumber(int[] arr, int k) {
        //Using max heap because largest element will always be on the top.
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(arr.length, Collections.reverseOrder());
        for(int i=0; i < arr.length; i++) {
            if(i < k) { //Add elements till heap has element equal to k
                priorityQueue.add(arr[i]);
            } else if(priorityQueue.peek() !=null && priorityQueue.peek()  > arr[i]) {
                // after kth index of the array is passed if we encounter an element in
                // array less than top of heap remove and add the new element
                priorityQueue.poll();
                priorityQueue.add(arr[i]);
            }
        }
        System.out.println(priorityQueue.peek());
    }
}
