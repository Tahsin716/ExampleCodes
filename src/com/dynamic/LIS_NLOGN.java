package com.dynamic;

public class LIS_NLOGN {

    /**
     * An ubiquitious binary search is used here.
     * We will find the largest end element that is smaller than key.
     * Clone and extend the list by key, and discard all other list of same length.
     *
     * An ubiquitious binary search is used to get the left most position in the array;
     * that is, we will be using the lower_bound of the binary search.
     *
     */
    static int binarySearch(int[] A, int left, int right, int key) {

        while (right - left > 1) {
            int mid = left + (right - left) / 2;

            if (A[mid] >= key)
                right = mid;
            else
                left = mid;
        }
        return right;
    }

    /**
     * Finding the length of the LongestIncreasingSubsequence
     *
     * Time complexity: O( nlogn )
     */
    static int LIS_Length(int[] A, int size) {

        //Add boundary case when array is of size one
        int[] table = new int[size];

        //Always points towards empty slot
        int length;

        table[0] = A[0];
        length = 1;

        for (int i = 1; i < size; i++) {

            // If A[i] is smallest among all end candidates of current active list
            // We will start new active list of length 1.
            if (A[i] < table[0]) {
                table[0] = A[i];
            }

            // If A[i] larger than the largest end candidate of the current active list
            // We will extend the table by inserting A[i]
            else if (A[i] > table[length - 1]) {
                table[length++] = A[i];
            }

            // If A[i] is in between the end candidate of the current active list
            // We will use binary search to replace the member.
            else {
                table[ binarySearch(table, -1, length - 1, A[i])] = A[i];
            }
        }

        return length;
    }

    // Driver program to test above function
    public static void main(String[] args)
    {
        int A[] = { 2, 5, 3, 7, 11, 8, 10, 13, 6 };
        int n = A.length;

        System.out.println("Length of Longest Increasing Subsequence is "+
                LIS_Length(A, n));
    }
}
