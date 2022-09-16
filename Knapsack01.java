/**
 * [cerner_2tothe5th_2022]
 * "cerner_2^5_2022"
 * Author: Dheemanth G K(DG072881)
 *
 * Knapsack 0/1
 * Problem statement:
 * Given weights and prices of n items, put these items in a knapsack of capacity W to get the maximum total prices
 * in the knapsack. In other words, given two integer arrays prices[0..n-1] and wt[0..n-1] which represent prices and
 * weights associated with n items respectively. Also given an integer W which represents knapsack capacity,find
 * out the maximum prices subset of val[] such that sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don’t pick it (0-1 property).
 *
 * The problem statement above can be solved using recursive approach. But the time complexity would be O(2^items).
 * The top-down tabular approach(DP) bring down the complexity to O(items*maxWeightCapacity) because redundant calculations of states are
 * avoided.
 */
public class Knapsack01 {
    private static int[][] topDownTable;//
    public static void main(String[] args) {
        int[] prices = new int[]{600, 100, 120}; //Prices of each item.
        int[] weights = new int[]{1, 2, 5}; //Weights of each item.
        int maxWeightCapacity = 3;
        topDownTable = new int[prices.length+1][maxWeightCapacity+1];
        System.out.println("Maximum profit: "+knapsackTopDown(weights, prices, maxWeightCapacity, prices.length));
    }

    /**
     * The function constructs a MATRIX(no_of_items+1 X maxWeightCapacity+1). Fill the first row and column with base
     * condition (i.e weights = 0 and prices = 0) in this case.
     * Example:  each col index represents max capacity. each row index represent item select corresponds to weights[i]
     * and prices[i]
     *                 _  _   _   _
     *                |0  0   0   0
     *                |0 600 600 600
     *                |0 600 600 700
     *                |0 600 600 700
     * @param weights Weights array
     * @param prices prices array
     * @param maxWeightCapacity Max capacity of knapsack
     * @param numberOfItems number of items available
     * @return max profits obtained
     */
    private static int knapsackTopDown(int[] weights, int[] prices, int maxWeightCapacity, int numberOfItems) {
        for(int selectItem=1; selectItem<=numberOfItems; selectItem++) {
            for(int availableCapacity=1; availableCapacity<=maxWeightCapacity; availableCapacity++) {
                if(selectItem == 0 || availableCapacity == 0) {
                    topDownTable[selectItem][availableCapacity] = 0;
                }
                //if selected item's weight is less than or equal available capacity we will have 2 options either select the
                // current items or avoid them. Max profit when compared to both is selected
                if(weights[selectItem-1] <= availableCapacity) {
                    topDownTable[selectItem][availableCapacity] = Math.max(
                            prices[selectItem-1] + topDownTable[selectItem-1][availableCapacity- weights[selectItem-1]],
                            topDownTable[selectItem-1][availableCapacity]);
                } else { //if selected item's weight is more than available capacity no other choice
                    // but avoid and move on. Aukat se bahar!!! :P
                    topDownTable[selectItem][availableCapacity] = topDownTable[selectItem-1][availableCapacity];
                }
            }
        }
        return topDownTable[numberOfItems][maxWeightCapacity];
    }
}
