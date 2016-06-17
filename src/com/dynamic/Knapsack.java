package com.dynamic;

public class Knapsack {

    public static void main(String[] args) {

        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int W = 30;

        System.out.printf("The maximum value is %d.%n", bottomUpDp(val, wt, W));
    }

    static int bottomUpDp(int[] val, int[] wt, int W) {

        int[][] K = new int[val.length + 1][W + 1];

        for(int i = 0; i <= val.length; i++) {
            for(int j = 0; j <= W; j++) {

                if(i == 0 || j == 0) {
                    K[i][j] = 0;
                    continue;
                }

                //Knapsack Formula
                if(j - wt[i-1] >= 0) {
                    K[i][j] = Math.max(K[i-1][j], K[i-1][j - wt[i-1]] + val[i-1]);
                }
                else {
                    K[i][j] = K[i-1][j];
                }
            }
        }
        return K[val.length][W];
    }
}
