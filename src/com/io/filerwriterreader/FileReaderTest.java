package com.io.filerwriterreader;


import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader( "f5.txt" );
            int i = 0;

            while( (i = fileReader.read()) != -1 ) {
                System.out.print( (char)i );
            }

            fileReader.close();
        }
        catch (IOException e) {
            System.err.println( "Error Message" );
        }
    }
}
