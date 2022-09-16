/**
 * Author: Dheemanth G K(DG072881)
 * [cerner_2tothe5th_2022]
 * [cerner_2^5_2022]
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum
 * equal to given sum.
 * Input: numbers[] = {3, 34, 4, 12, 5, 2}, target = 9
 * Output: True
 * Time complexity for recursive solution would be exponential.
 * Using top-down tabular method(DP) it is reduced to O(sum*sizeOfArray)
 */
public class SubsetSum {
    public static boolean[][] dp;

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 34, 4, 12, 5, 2};
        int sum = 9;
        dp = new boolean[numbers.length + 1][sum + 1];
        System.out.println(isSubsetPresent(numbers, sum, numbers.length));//true
        sum = 1;
        dp = new boolean[numbers.length + 1][sum + 1];
        System.out.println(isSubsetPresent(numbers, sum, numbers.length));//false
    }

    /**
     * The function constructs a MATRIX(sizeOfArray+1 X sum+1). Fill the first row and column with base
     * condition.
     * The base condition is
     * MATRIX[0][0] is true because sum=0 and array size is zero we get empty subset({})
     * MATRIX[i][0] is true because sum = 0 will always have a empty subset({})
     * MATRIX[1][j] is false because sum > 0 and number array size = 0(No elements)
     *  __________________________
     * |true  false   false   false
     * |true
     * |true
     * |true
     * @param sum  target sum
     * @param size size of array
     * @return true if subset is present or else returns false
     */
    private static boolean isSubsetPresent(int[] numbers, int sum, int size) {
        for (int eachEle = 0; eachEle <= size; eachEle++) {
            for (int subSum = 0; subSum <= sum; subSum++) {
                if (eachEle == 0) {
                    dp[eachEle][subSum] = false;
                }
                if (subSum == 0) {
                    dp[eachEle][subSum] = true;
                } else if (eachEle > 0) {
                    if (numbers[eachEle - 1] <= subSum) {
                        dp[eachEle][subSum] = dp[eachEle - 1][subSum - numbers[eachEle - 1]] || dp[eachEle - 1][subSum];
                    } else {
                        dp[eachEle][subSum] = dp[eachEle - 1][subSum];
                    }
                }
            }
        }
        return dp[size][sum];
    }
}
