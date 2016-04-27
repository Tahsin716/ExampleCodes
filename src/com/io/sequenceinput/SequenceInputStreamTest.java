package com.io.sequenceinput;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class SequenceInputStreamTest {

    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream1 = new FileInputStream( "f1.txt" );
            FileInputStream fileInputStream2 = new FileInputStream( "f2.txt" );

            SequenceInputStream sequenceInputStream = new SequenceInputStream( fileInputStream1, fileInputStream2 );
            int i = 0;

            while( (i = sequenceInputStream.read()) != -1 ) {
                System.out.println( (char)i );
            }

            sequenceInputStream.close();
            fileInputStream1.close();
            fileInputStream2.close();

        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
