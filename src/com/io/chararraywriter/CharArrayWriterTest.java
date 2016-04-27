package com.io.chararraywriter;


import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CharArrayWriterTest {

    public static void main(String[] args) {

        try {

            CharArrayWriter charArrayWriter = new CharArrayWriter();
            charArrayWriter.write( "His name is John Cena" );

            FileWriter fileWriter1 = new FileWriter( "a.txt" );
            FileWriter fileWriter2 = new FileWriter( "b.txt" );
            FileWriter fileWriter3 = new FileWriter( "c.txt" );
            FileWriter fileWriter4 = new FileWriter( "d.txt" );

            charArrayWriter.writeTo(fileWriter1);
            charArrayWriter.writeTo(fileWriter2);
            charArrayWriter.writeTo(fileWriter3);
            charArrayWriter.writeTo(fileWriter4);

            fileWriter1.close();
            fileWriter2.close();
            fileWriter3.close();
            fileWriter4.close();

            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
