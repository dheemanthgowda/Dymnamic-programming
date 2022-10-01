/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 * Given a positive integer n, print all n-bit binary numbers having more 1’s than 0’s for any prefix of the number.
 * Example:
 * Input:  N = 2
 * Output: 11 10
 * Explanation: 11 and 10 have more than
 * or equal 1's than 0's
 */
public class PrintNBitNumber1GE0 {

    public static void main(String[] args) {
        printNBitNumber1GE0(0, 0, 5, "1");
    }

    public static void printNBitNumber1GE0(int zeros, int ones, int n, String op) {
        if(n == 0) {
            System.out.println(op);
            return;
        }
        if(ones > zeros) {
            printNBitNumber1GE0(zeros, ones+1, n-1, op + "1");
            printNBitNumber1GE0(zeros+1, ones, n-1, op + "0");
        } else {
            printNBitNumber1GE0(zeros, ones+1, n-1, op+"1");
        }
    }
}
