/**
 *  [cerner_2tothe5th_2022]
 *  Author: Dheemanth G K(DG072881)
 * Given a rod of length n inches and an array of prices that includes prices of all pieces of size smaller than n.
 * Determine the maximum value obtainable by cutting up the rod and selling the pieces.
 * For example, if the length of the rod is 8 and the values of different pieces are given as the following,
 * then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
 */
public class RodCuttingProblem {
    static int[][] topDownTable;
    public static void main(String[] args) {
        int[] prices = new int[]{3,   5,   8,   9,  10,  17,  17,  20}; //Prices of each rod length.
        int[] length = new int[]{1, 2, 3, 4, 5, 6, 7, 8};
        int rodLength = 8;
        topDownTable =  new int[prices.length+1][rodLength+1];
        System.out.println(maxProfit(length, prices, rodLength, prices.length));
    }
    private static int maxProfit(int[] length, int[] prices, int rodLength, int numberOfRods) {
        for(int selectRod=1; selectRod<=numberOfRods; selectRod++) {
            for(int availableRodLength=1; availableRodLength<=rodLength; availableRodLength++) {
                if(selectRod == 0 || availableRodLength == 0) {
                    topDownTable[selectRod][availableRodLength] = 0;
                }
                //if selected item's weight is less than or equal available capacity we will have 2 options either select the
                // current items or avoid them. Max profit when compared to both is selected
                if(length[selectRod-1] <= availableRodLength) {
                    topDownTable[selectRod][availableRodLength] = Math.max(
                            prices[selectRod-1] + topDownTable[selectRod][availableRodLength - length[selectRod-1]],
                            topDownTable[selectRod-1][availableRodLength]);
                } else { //if selected item's weight is more than available capacity no other choice
                    // but avoid and move on.
                    topDownTable[selectRod][availableRodLength] = topDownTable[selectRod-1][availableRodLength];
                }
            }
        }
        return topDownTable[numberOfRods][rodLength];
    }
}
