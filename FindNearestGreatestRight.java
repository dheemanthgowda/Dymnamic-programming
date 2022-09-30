import java.util.Stack;
/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 */
public class FindNearestGreatestRight {
    public static void main(String[] args) {
        int[] arr =  new int[] {1, 10, 2, 7, 2, 13, 1};
        System.out.println(nearestGreatestRight(arr));
    }
    public static int nearestGreatestRight(int[] arr) {
        Stack<Integer> stack =  new Stack<>();
        int[] res = new int[arr.length];
        for(int i=0; i<arr.length; i++) {
            if(stack.empty()) {
                res[i] = -1;
            } else if(stack.peek() > arr[i]) {
                res[i] = stack.peek();
            } else {
                while(!stack.empty() && stack.peek() <= arr[i]) {
                    stack.pop();
                }
                if(stack.empty()) {
                    res[i] = -1;
                } else {
                    res[i] = stack.peek();
                }
            }
            stack.push(arr[i]);
        }
        return res[res.length - 1];
    }
}
