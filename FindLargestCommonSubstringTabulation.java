/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 * Given two strings ‘X’ and ‘Y’, find the length of the longest common substring.
 * nput : X = “abcdxyz”, y = “xyzabcd”
 * Output : 4
 * Explanation: The longest common substring is “abcd” and is of length 4.
 */
public class FindLargestCommonSubstringTabulation {
    static int[][] dp;
    public static void main(String[] args) {
        String s1 = "abcdxyz";
        String s2 = "xyzabcd";
        dp = new int[s1.length() + 1][s2.length() + 1];
        System.out.println(count(s1, s2, s1.length(), s2.length()));
    }
    private static int count(String input1, String input2, int size1, int size2) {
        for (int i = 0; i < size1 + 1; i++) {
            dp[i][0] = 0;
        }
        for (int j = 0; j < size2 + 1; j++) {
            dp[0][j] = 0;
        }
        int max = 0;
        for (int i = 1; i <= size1; i++) {
            for (int j = 1; j <= size2; j++) {
                if (input1.charAt(i - 1) == input2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    max = Math.max(dp[i][j], max);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return max;
    }
}
