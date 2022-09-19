/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 *
 * Given an array arr of size N containing non-negative integers, the task is to divide it into two sets S1 and S2
 * such that the absolute difference between their sums is minimum and find the minimum difference.
 * If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and
 * the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.
 * Example:
 * Input: N = 4, arr[] = {1, 6, 11, 5}
 * Output: 1
 * Explanation:
 * Subset1 = {1, 5, 6}, sum of Subset1 = 12
 * Subset2 = {11}, sum of Subset2 = 11
 */
public class MinimumSubsetSumDiff {
    public static void main(String[] args) {
        System.out.println(findMinimumDiff(new int[]{1, 6, 11, 5}));
    }
    private static int findMinimumDiff(int[] numbers) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        //Find sum of the array to find the max range of the subset sum
        for (int number : numbers) {sum = sum + number;}
        // Since we have to find ABS(S1 - s2) = MIN. We can simplify it to sum - 2S1(Given S1 > S2)
        // For we can find candidate subsets sums till sum/2 to find S1, since S2 =  SUM - S1
        boolean[] candidateSums = isSubsetPresent(numbers, sum/2, numbers.length);
        //Index of array corresponds to sum of the subset S1
        for(int eachEle=0; eachEle < candidateSums.length;eachEle++) {
            if(candidateSums[eachEle]){
                 if(sum - (2 * eachEle) < min){min = sum - (2 * eachEle);}
            }}
        return min;
    }
    private static boolean[] isSubsetPresent(int[] numbers, int sum, int size) {
        boolean[][] dp = new boolean[size+1][sum+1];
        for(int subSum = 0;subSum <= sum; subSum++) {dp[0][sum] =false;}
        for(int eachELe = 0;eachELe <= size; eachELe++) {dp[eachELe][0] =true;}
        for (int eachEle = 1; eachEle <= size; eachEle++) {
            for (int subSum = 1; subSum <= sum; subSum++) {
                    if (numbers[eachEle - 1] <= subSum) { dp[eachEle][subSum] = dp[eachEle - 1][subSum - numbers[eachEle - 1]] || dp[eachEle - 1][subSum];}
                    else { dp[eachEle][subSum] = dp[eachEle - 1][subSum];}
            }
        }
        return dp[size];
    }
}
