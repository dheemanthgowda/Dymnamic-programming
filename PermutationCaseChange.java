/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 * Print all permutations of a string keeping the sequence but changing cases.
 * Input : ab
 * Output : AB Ab ab aB
 *
 * Input : ABC
 * Output : abc Abc aBc ABc abC AbC aBC ABC
 */
public class PermutationCaseChange {

    public static void main(String[] args) {
        permutationCaseChange("abc", "");
    }
    public static void permutationCaseChange(String in, String out) {
        if(in.length() == 0) {
            System.out.println(out);
            return;
        }
        String outRes = in.substring(0, 1);
        String op1 = out+outRes.toUpperCase();
        String op2 = out+outRes;
        in = in.substring(1);
        permutationCaseChange(in, op1);
        permutationCaseChange(in, op2);
    }
}
