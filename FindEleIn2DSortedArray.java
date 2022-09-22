/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 * Find ele in sorted 2d array.
 */
public class FindEleIn2DSortedArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18}};
        findEle(arr, 3, 6, 16);

    }
    private static void findEle(int[][] arr, int n, int m, int ele) {
        int i = 0;
        int j = m - 1;
        while (i >= 0 && i <= n - 1 && j >= 0 && j <= m - 1) {
            int mid = arr[i][j];
            if (ele == mid) {
                System.out.println("Row: " + i);
                System.out.println("Col: " + j);
                break;
            } else if (ele > mid) {
                i++;
            } else {
                j--;
            }
        }
    }
}
