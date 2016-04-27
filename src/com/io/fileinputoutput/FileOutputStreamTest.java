package com.io.fileinputoutput;


import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

    public static void main(String[] args) {

        try {

            FileOutputStream fileOutputStream = new FileOutputStream( "fileOutputStreamTest.txt" );
            String s = "Hello my name is Tahsin";

            byte[] b = s.getBytes(); //converting String to byte array
            fileOutputStream.write(b);
            fileOutputStream.close();

            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
