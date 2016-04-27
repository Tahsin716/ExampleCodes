package com.io.filerwriterreader;


import java.io.FileWriter;
import java.io.IOException;

public class FileWriterTest {

    public static void main(String[] args) {

        try {

            FileWriter fileWriter = new FileWriter( "f5.txt" );
            fileWriter.write( "Hello World" );
            fileWriter.close();

            System.out.println( "Successfully done..." );
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
