/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 *
 * Given two sequences, print the longest subsequence present in both of them.
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 */
public class PrintLargestCommonSubsequenceTabulation {
    static int[][] dp;
    public static void main(String[] args) {
        String s1=  "AGGTAB";
        String s2 =  "GXTXAYB";
        dp = new int[s1.length()+1][s2.length()+1];
        System.out.println(print(s1, s2, s1.length(), s2.length()));
    }
    private static String print(String input1, String input2, int size1, int size2) {
        StringBuilder res = new StringBuilder();
        for (int i=0; i<size1+1; i++) { dp[i][0] = 0; }
        for (int j = 0; j <size2+1; j++) { dp[0][j] = 0; }
        for (int i=1; i<=size1; i++) {
            for(int j=1; j<=size2; j++) {
                if(input1.charAt(i-1) == input2.charAt(j-1)) { dp[i][j] = 1 + dp[i-1][j-1]; }
                else { dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]); }
            }
        }
        int i = size1; int j = size2;
        while (i > 0 && j > 0) {
            if(input1.charAt(i-1) == input2.charAt(j-1)) {
                res.append(input1.charAt(i - 1));i--;j--;
            } else {
                if(dp[i-1][j] > dp[i][j-1]) {i--;}
                else {j--;}
            }
        }
        return res.reverse().toString();
    }
}
