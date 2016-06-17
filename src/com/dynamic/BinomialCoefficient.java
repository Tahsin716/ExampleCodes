package com.dynamic;

import java.util.Scanner;

public class BinomialCoefficient {

    static Scanner scanner;
    static int[][] F;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        System.out.println("Enter n and k: ");
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        F = new int[n+1][n+1];

        for(int i = 0; i <= n; i++)
            for(int j = 0; j <= n; j++)
                F[i][j] = -1;

        F[n][0] = F[n][n] = 1;

        int a, b;

        a = MemBin(n,k);
        b = IterBin(n,k);

        System.out.printf("%d%n%d%n",a, b);
    }

    //The naive algorithm
    static int RecBin(int n, int k) {

        if(k == 0 || k == n)
            return 1;
        else
            return RecBin(n-1, k-1) + RecBin(n-1, k);
    }


    //Binomial Coefficient using memoization (Top-Down)
    static int MemBin(int n, int k) {

        if(k == 0 || k == n)
            return 1;
        else {
            if(F[n][k] == -1)
                F[n][k] = MemBin(n-1, k-1) + MemBin(n-1, k);

            return F[n][k];
        }
    }


    //Binomial Coefficient using Iterative approach (Bottom-Up)
    static int IterBin(int n, int k) {

        int[][] H = new int[n+1][k+1];

        for(int i = 0; i <= n; i++) {
            for (int j = 0; j <= Math.min(i, k); j++) {

                //Base case
                if (j == 0 || j == i)
                    H[i][j] = 1;

                    //Calculate value using previously stored values
                else
                    H[i][j] = H[i - 1][j - 1] + H[i - 1][j];
            }
        }

        return H[n][k];
    }
}
