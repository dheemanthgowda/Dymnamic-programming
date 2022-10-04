/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them.
 * The output should be printed in sorted increasing order of strings.
 * Input:
 * S = "ABC"
 * Output: (A B C)(A BC)(AB C)(ABC)
 * Explanation:
 * ABC
 * AB C
 * A BC
 * A B C
 * These are the possible combination of "ABC".
 */
public class PermutationWithSpaces {

    public static void main(String[] args) {
        permutationAddSpaces("abc", "");
    }

    public static void permutationAddSpaces(String in, String out) {
        if(out.equals("")) {
            out = in.substring(0, 1);
            in = in.substring(1);
        }
        if(in.length() == 0) {
            System.out.println(out);
            return;
        }
        String op1 = out;
        op1 = op1 + " ";
        op1 = op1.concat(in.substring(0,1));
        String op2 = out.concat(in.substring(0,1));
        in = in.substring(1);
        permutationAddSpaces(in, op1);
        permutationAddSpaces(in, op2);
    }


}
