/**
 * [cerner_2tothe5th_2022]
 * Author: Dheemanth G K(DG072881)
 */
import java.util.Arrays;
public class InsertionSort {
    public static void insertionSort(int[] arr) {
        for(int i=0; i<arr.length; i++) {
            int insertVal = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > insertVal) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = insertVal;
        }
    }
    
    public static void main(String[] args) {
        int[] ex = new int[]{3,4,5,1,2,10,0};
        insertionSort(ex);
        System.out.println(Arrays.toString(ex));
    }
}
