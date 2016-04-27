package com.io.bytearrayoutput;


import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteArrayOutputStreamTest {

    public static void main(String[] args) {

        try {

            FileOutputStream fileOutputStream1 = new FileOutputStream( "f1.txt" );
            FileOutputStream fileOutputStream2 = new FileOutputStream( "f2.txt" );

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byteArrayOutputStream.write('b');
            byteArrayOutputStream.writeTo(fileOutputStream1);
            byteArrayOutputStream.writeTo(fileOutputStream2);

            byteArrayOutputStream.flush(); //flushes the stream
            byteArrayOutputStream.close(); //has no effect

            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
