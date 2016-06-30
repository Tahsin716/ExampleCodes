package com.dynamic;


public class LongestCommonSubsequence {

    public static void main(String[] args) {

        String str1 = "AGGTAB";
        String str2 = "GXTXAYB";

        int length = LCS_Length(str1.toCharArray(), str2.toCharArray());
        System.out.println(length);
        String answer = LCS_String(str1.toCharArray(), str2.toCharArray());
        System.out.println(answer);

    }

    static int LCS_Length(char[] str1, char[] str2) {

        int[][] temp = new int[str1.length+1][str2.length+1];

        for(int i = 0; i <= str1.length; i++) {
            for(int j = 0; j <= str2.length; j++) {

                if(i == 0 || j == 0) {
                    temp[i][j] = 0;
                }
                else if (str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i-1][j-1] + 1;
                }
                else {
                    temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
                }
            }
        }

        return temp[str1.length][str2.length];
    }

    static String LCS_String(char[] str1, char[] str2) {

        int[][] temp = new int[str1.length +1][str2.length +1];

        //Used to build the temp table in Bottom-Up

        for(int i = 0; i <= str1.length; i++) {
            for(int j = 0; j <= str2.length; j++) {

                if(i == 0 || j == 0) {
                    temp[i][j] = 0;
                }
                else if (str1[i-1] == str2[j-1]) {
                    temp[i][j] = temp[i-1][j-1] + 1;
                }
                else {
                    temp[i][j] = Math.max(temp[i-1][j], temp[i][j-1]);
                }
            }
        }

        //For printing the lcs

        int index = temp[str1.length][str2.length];

        char[] lcs = new char[index +1];
        lcs[index] = '\0';

        int i = str1.length, j = str2.length;
        while(i > 0 && j > 0) {

            if(str1[i-1] == str2[j-1]) {
                lcs[index-1] = str1[i-1];
                i--;
                j--;
                index--;
            }
            else if(temp[i-1][j] > temp[i][j-1])
                i--;
            else
                j--;
        }

        return String.valueOf(lcs);
    }
}
