package com.io.bufferedinputoutput;


import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

public class BufferedInputStreamTest {

    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream = new FileInputStream( "f4.txt" );
            BufferedInputStream bufferedInputStream = new BufferedInputStream( fileInputStream );

            int i = 0;
            while( (i = bufferedInputStream.read()) != -1 ) {
                System.out.print( (char)i );
            }

            bufferedInputStream.close();
            fileInputStream.close();
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
