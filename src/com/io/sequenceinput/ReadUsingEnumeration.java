package com.io.sequenceinput;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

public class ReadUsingEnumeration {

    public static void main(String[] args) {

        try {

            FileInputStream fileInputStream1 = new FileInputStream( "f1.txt" );
            FileInputStream fileInputStream2 = new FileInputStream( "f2.txt" );
            FileInputStream fileInputStream3 = new FileInputStream( "f3.txt" );
            FileInputStream fileInputStream4 = new FileInputStream( "fileOutputStreamTest.txt" );
            FileInputStream fileInputStream5 = new FileInputStream( "fileOutputStreamTestDuplicate.txt" );

            //Create vector object for all the streams
            Vector vector = new Vector();
            vector.add(fileInputStream1);
            vector.add(fileInputStream2);
            vector.add(fileInputStream3);
            vector.add(fileInputStream4);
            vector.add(fileInputStream5);

            //Create enumeration object by calling all the elements methods
            Enumeration enumeration = vector.elements();

            //Passing the enumeration object in the constructor
            SequenceInputStream sequenceInputStream = new SequenceInputStream( enumeration );
            int i = 0;

            while( (i = sequenceInputStream.read()) != -1 ) {
                System.out.print( (char)i );
            }

            sequenceInputStream.close();
            fileInputStream1.close();
            fileInputStream2.close();
            fileInputStream3.close();
            fileInputStream4.close();
            fileInputStream5.close();

        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
