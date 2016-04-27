package com.io.input;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderUntilStop {

    public static void main(String[] args) {

        try {

            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String name = "";

            while( !name.equals("stop") ) {
                System.out.println( "Enter your name" );
                name = bufferedReader.readLine();
                System.out.println( "data is " + name );
            }

            bufferedReader.close();
            inputStreamReader.close();

        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
