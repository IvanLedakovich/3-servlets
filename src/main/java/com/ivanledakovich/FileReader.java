package com.ivanledakovich;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class contains methods for reading files
 *
 * @author Ivan Ledakovich
 *
 */

public class FileReader {

    /**
     * This method receives file path and returns the file in form of a String
     *
     * @param filePath String, containing path to base file
     * @return file data in form of a String
     *
     * @author Ivan Ledakovich
     *
     */

    public static String readFile(String filePath) {
        File myObj = new File(filePath);
        String data = "";
        Scanner myReader = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            System.out.println(line);
            data += line;
        }
        myReader.close();
        return data;
    }
}
