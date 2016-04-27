package com.io.sequenceinput;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;

public class WritingToAnotherFile {

    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream1 = new FileInputStream( "f1.txt" );
            FileInputStream fileInputStream2 = new FileInputStream( "f2.txt" );

            FileOutputStream fileOutputStream = new FileOutputStream( "f3.txt" );

            SequenceInputStream sequenceInputStream = new SequenceInputStream( fileInputStream1, fileInputStream2 );
            int i = 0;

            while ( (i = sequenceInputStream.read()) != -1 ) {
                fileOutputStream.write(i);
            }

            sequenceInputStream.close();
            fileInputStream1.close();
            fileInputStream2.close();
            fileOutputStream.close();

            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.out.println( "Error Message" );
        }
    }
}
