package com.io.fileinputoutput;


import java.io.FileInputStream;
import java.io.IOException;

public class FileInputStreamTest {

    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream = new FileInputStream( "fileOutputStreamTest.txt" );
            int i = 0;

            while( (i = fileInputStream.read()) != -1 ) {
                System.out.print((char)i);
            }

            fileInputStream.close();
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
