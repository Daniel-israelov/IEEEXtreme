package CSacademy;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class MaximumSum {
    //ToDo - Sort the array in such way the
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int size = in.nextInt();
            Integer[] arr = new Integer[size];
            for (int j = 0; j < size; j++) {
                arr[j] = in.nextInt();
            }
            System.out.println(findMaxSum(arr));
            printArr(arr);
        }
    }

    public static int findMaxSum(Integer[] arr){
        Arrays.sort(arr,0,arr.length/2);
        Arrays.sort(arr, arr.length/2+1, arr.length, Collections.reverseOrder());

        int sum = 0;
        for (int i = 0; i < arr.length-2; i++) {
            sum += (arr[i]*arr[i+1]);
        }
        return sum;
    }

    public static void printArr(Integer[] arr){
        for(int a : arr)
            System.out.print(a + " ");
    }
}
