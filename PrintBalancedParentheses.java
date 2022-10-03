/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 * Write a function to generate all possible n pairs of balanced parentheses.
 * Input : n=2
 * Output:
 * {}{}
 * {{}}
 * Explanation: This the only two sequences of balanced
 * parenthesis formed using 2 pair of balanced parenthesis.
 */
public class PrintBalancedParentheses {
    public static void main(String[] args) {
        printBalancedParen(4, 4, "");
    }

    public static void printBalancedParen(int close,int open, String op) {
        if(close == 0 && open == 0) {
            System.out.println(op);
            return;
        }
        if(close > open) {
            printBalancedParen(close -1, open, op+"}");
        }
        if(open != 0) {
            printBalancedParen(close, open-1, op+"{");
        }
    }
}
