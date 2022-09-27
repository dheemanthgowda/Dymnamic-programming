/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 * Given two sequences, find the length of longest subsequence present in both of them.
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * NOTE: Memoization approach
 * EXAMPLE: abcdgh and abedfhr has 4 common alphabets therefore output = 4
 */
public class FindLargestCommonSubsequenceMemoization {
    static int[][] dp;
    public static void main(String[] args) {
        String s1=  "abcdgh";
        String s2 =  "abedfhr";
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<s1.length(); i++) {
            for(int j=0; j<s2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(count(s1, s2, 6, 7));
    }
    private static int count(String input1, String input2, int size1, int size2) {
        if(size1 == 0  || size2 == 0) {
            return 0;
        }
        if(dp[size1-1][size2-1] != -1) {
            return dp[size1-1][size2-1];
        }
        //If last characters of both sequences match (or input1[size1-1] == input1[size2-1]) then
        //count(input1[0..size1-1], input2[0..size2-1]) = 1 + count(input1[0..size1-1], input2[0..size2-1])
        if(input1.charAt(size1-1) == input2.charAt(size2-1)) {
            dp[size1-1][size2-1] = 1 + count(input1, input2, size1-1, size2-1);
        } else {
            //If last characters of both sequences do not match (or X[m-1] != Y[n-1]) then
            //L(input1[0..size1-1], input2[0..size2-1]) = MAX ( L(input1[0..size1-1], input2[0..size2]),
            // L(input1[0..size1], input2[0..size2-1]) )
            dp[size1-1][size2-1]  = Math.max(count(input1, input2, size1-1, size2),
                    count(input1, input2, size1, size2-1));
        }
        return dp[size1-1][size2-1];
    }
}