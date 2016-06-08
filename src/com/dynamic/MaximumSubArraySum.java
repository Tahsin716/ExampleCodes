package com.dynamic;

import java.util.Scanner;

//Kadane's Algorithm for Largest Contiguous sum
//Time-complexity O(n)

public class MaximumSubArraySum {

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);

        System.out.print("Number of elements: ");
        int num = scanner.nextInt();
        int[] arr = new int[num];

        System.out.println("Enter elements: ");
        for(int i = 0; i < num; i++)
            arr[i] = scanner.nextInt();

        int ans = maxSequenceSum(arr);
        System.out.println("Maximum sequence sum = " + ans);
    }


    //Using Kadane's Algorithm for max_sub_array_sum
    static int maxSequenceSum(int[] arr) {

        int maxSoFar = arr[0], maxEndingHere = arr[0];

        for(int i = 1; i < arr.length; i++) {

            if(maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];

            if(maxSoFar < maxEndingHere)
                maxSoFar = maxEndingHere;
        }

        return maxSoFar;
    }
}
