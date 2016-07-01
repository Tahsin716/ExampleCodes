package com.dynamic;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static void main(String[] args) {

        int[] arr = {15, 27, 14, 38, 26, 55, 46, 65, 85};
        int lis_1 = LIS_1(arr, arr.length);
        String lis_11 = LIS_11(arr, arr.length);

        System.out.println(lis_1);
        System.out.println(lis_11);
    }

    //Calculate LongestIncreasingSubsequence, Time-Complexity O(N^2)
    static int LIS_1(int[] arr, int len) {

        int[] temp = new int[len];
        int max = 0;

        Arrays.fill(temp, 1);

        for(int i = 0; i < len; i++)
            for(int j = 0; j < i; j++)
                if(arr[i] > arr[j] && temp[i] < temp[j] +1)
                    temp[i] = temp[j] + 1;


        //Find the max LIS
        for(int i = 0; i < len; i++)
            if(max < temp[i])
                max = temp[i];

        return max;
    }

    //Print the LIS, Time-Complexity O(N^2)
    static String LIS_11(int arr[], int len) {

        int[] temp = new int[len];
        String[] path = new String[len];

        int max = 0;
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < len; i++) {
            temp[i] = 1;
            path[i] = arr[i] + " ";
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {

                if (arr[i] > arr[j] && temp[i] < temp[j] + 1) {
                    temp[i] = temp[j] + 1;
                    path[i] = path[j] + arr[i] + " ";

                    if (max < temp[i])
                        max = temp[i];
                }
            }
        }

        for(int i = 0; i < len; i++) {
            if(temp[i] == max)
                result.append(path[i]);
        }

        return result.toString();
    }
}
