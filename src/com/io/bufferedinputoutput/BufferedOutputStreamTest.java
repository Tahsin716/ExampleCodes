package com.io.bufferedinputoutput;


import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamTest {

    public static void main(String[] args ){

        try {

            FileOutputStream fileOutputStream = new FileOutputStream( "f4.txt" );
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream( fileOutputStream );

            String s = "My name is Tahsin Rashad";
            byte[] b = s.getBytes(); //converting String to byte array

            bufferedOutputStream.write(b);
            bufferedOutputStream.flush();

            bufferedOutputStream.close();
            fileOutputStream.close();

            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
