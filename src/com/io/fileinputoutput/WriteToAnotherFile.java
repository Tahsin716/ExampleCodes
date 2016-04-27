package com.io.fileinputoutput;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteToAnotherFile {

    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream = new FileInputStream( "fileOutputStreamTest.txt" );
            FileOutputStream fileOutputStream = new FileOutputStream( "fileOutputStreamTestDuplicate.txt" );

            int i = 0;

            while ( (i = fileInputStream.read()) != -1 ) {
                fileOutputStream.write( (byte)i );
            }

            fileOutputStream.close();
            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }


    }
}
