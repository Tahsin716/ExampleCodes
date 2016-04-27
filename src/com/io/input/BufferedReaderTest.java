package com.io.input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderTest {

    public static void main(String[] args) {

        try {

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            System.out.println( "Enter your name " );
            String name = bufferedReader.readLine();

            System.out.println( "Welcome " + name );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
