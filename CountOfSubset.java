/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 * Given an array arr[] of non-negative integers and an integer sum, the task is to count all subsets
 * of the given array with a sum equal to a given sum.
 */
public class CountOfSubset {
    public static int[][] dp;
    public static void main(String[] args) {
        int[] numbers = new int[]{2, 3, 5, 6, 8, 10};
        int target = 10;
        dp = new int[numbers.length + 1][target + 1];
        System.out.println(count(numbers, numbers.length, target));
    }
    private static int count(int[] numbers, int size, int target) {
        dp = new int[size + 1][target + 1];
        for (int eachEle = 0; eachEle <= size; eachEle++) {
            for (int subSum = 0; subSum <= target; subSum++) {
                if (subSum == 0) { dp[eachEle][subSum] = 1; }
                else if (eachEle > 0) {
                    if (numbers[eachEle - 1] <= subSum) {
                        dp[eachEle][subSum] = dp[eachEle - 1][subSum - numbers[eachEle - 1]] + dp[eachEle - 1][subSum];
                    } else { dp[eachEle][subSum] = dp[eachEle - 1][subSum]; }
                }
            }
        }
        return dp[size][target];
    }
}
