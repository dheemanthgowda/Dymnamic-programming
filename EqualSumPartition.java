/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 *
 * Equal Sum Partition
 * Problem statement:
 * Partition problem is to determine whether a given set can be partitioned into two subsets such that the sum of
 * elements in both subsets is the same.
 *
 * The problem statement above can be solved using recursive approach. But the time complexity would be O(2^items).
 * The top-down tabular approach(DP) bring down the complexity to O(items*maxWeightCapacity) because redundant
 * calculations of states are avoided.
 */
public class EqualSumPartition {
    public static boolean[][] dp;

    public static void main(String[] args) {
        int[] numbers = new int[]{1, 5, 11, 5};
        System.out.println(isEqualSumPartitionPresent(numbers, numbers.length));//true
    }
    private static boolean isEqualSumPartitionPresent(int[] numbers, int size) {
        int sum = 0;
        for (int eachEle = 0; eachEle < size; eachEle++) {sum = sum + numbers[eachEle];}
        dp = new boolean[size + 1][sum + 1];
        if (sum % 2 == 0) {
            for (int eachEle = 0; eachEle <= size; eachEle++) {
                for (int subSum = 0; subSum <= sum; subSum++) {
                    if (eachEle == 0) { dp[eachEle][subSum] = false; }
                    if (subSum == 0) { dp[eachEle][subSum] = true; }
                    else if (eachEle > 0) {
                        if (numbers[eachEle - 1] <= subSum) {
                            dp[eachEle][subSum] = dp[eachEle - 1][subSum - numbers[eachEle - 1]] || dp[eachEle - 1][subSum];
                        } else { dp[eachEle][subSum] = dp[eachEle - 1][subSum]; }
                    }
                }
            }
            return dp[size][sum];
        }
        return false;
    }
}
