package com.dynamic;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class FibonacciNumber {

    static Scanner scanner;
    static PrintWriter printWriter;

    static int[] H;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        printWriter = new PrintWriter(System.out);

        System.out.print("Number of terms: ");
        int terms = scanner.nextInt();

        H = new int[terms+1];
        Arrays.fill(H,-1);
        H[0] = 0;
        H[1] = 1;

        int a ,b ,c;

        a = RecFib(terms);
        b = MemFib(terms);
        c = IterFib(terms);

        printWriter.printf("%d %d %d%n",a , b, c);
        printWriter.flush();
    }


     //The naive algorithm
    static int RecFib(int n) {

        if(n < 2)
            return n;
        else
            return RecFib(n - 1) + RecFib(n - 2);
    }


    //Fibonacci using memoization (Top-Down)
    static int MemFib(int n) {

        if(n < 2)
            return H[n];
        else {

            if (H[n] == -1)
                H[n] = MemFib(n - 1) + MemFib(n - 2);

            return H[n];
        }
    }


    //Iterative approach for Fibonacci (Bottom-Up)
    static int IterFib(int n) {

        int[] F = new int[n+1];
        Arrays.fill(F, -1);
        F[0] = 0;
        F[1] = 1;

        for(int i = 2; i <= n; i++)
            F[i] = F[i-1] + F[i-2];

        return F[n];
    }

}
