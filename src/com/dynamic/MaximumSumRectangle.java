package com.dynamic;

//Kadane's algorithm for Largest contiguous sum in rectangular sub-array in a 2D matrix
//For this algorithm to work, there must be atleast one positve integer in the 2D matrix
//Space complexity O(row)
//Time-complexity O(col*col*row)

public class MaximumSumRectangle {


    public static void main(String[] args) {

        findMaxSubMatrix(new int[][] {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        });

    }


    //Use Kadane's algorithm to find max_sum in 1D array
    //Return {max_sum, left, right}
    public static int[] kadane(int[] array) {

        //result[0] == maxSum, result[1] == start, result[2] == end
        int[] result = new int[]{Integer.MIN_VALUE, 0, -1};
        int currentSum = 0, start = 0;


        //Kadane's algorithm
        for(int i = 0; i < array.length; i++) {
            currentSum += array[i];
            if (currentSum < 0) {
                currentSum = 0;
                start = i + 1;
            }
            else if (currentSum > result[0]){
                result[0] = currentSum;
                result[1] = start;
                result[2] = i;
            }
        }


        //if all the elements in the array are negative
        if (result[2] == -1) {
            result[0] = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] > result[0]) {
                    result[0] = array[i];
                    result[1] = i;
                    result[2] = i;
                }
            }
        }

        return result;
    }

    //Find and print max_sum
    //Print left, right, top, bottom
    public static void findMaxSubMatrix(int[][] array) {

        int columns = array[0].length;
        int rows = array.length;
        int[] currentResult;
        int maxSum = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int top = 0, bottom = 0;


        for(int leftColumn = 0; leftColumn < columns; leftColumn++) {
            int[] temp = new int[rows];

            for(int rightColumn = leftColumn; rightColumn < columns; rightColumn++) {

                for(int i = 0; i < rows; i++)
                    temp[i] += array[i][rightColumn];

                currentResult = kadane(temp);

                if (currentResult[0] > maxSum) {
                    maxSum = currentResult[0];
                    left = leftColumn;
                    right = rightColumn;
                    top = currentResult[1];
                    bottom = currentResult[2];
                }
            }
        }

        System.out.printf("Max sum is %d%nLeft: %d   Right: %d%nTop: %d   Bottom: %d%n",maxSum, left, right, top, bottom);
    }
}
