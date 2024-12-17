package com.ivanledakovich;

import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import org.apache.log4j.Logger;

/**
 * This class contains methods for reading files
 *
 * @author Ivan Ledakovich
 */
public class FileReader {

    static final private Logger logger = Logger.getLogger(FileReader.class);

    /**
     * This method receives file path and returns the file in form of a String
     *
     * @param filePath String, containing path to base file
     * @return file data in form of a String
     */
    public static String readFile(String filePath){
        String data = "";
        try {
            data = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
        } catch (IOException e) {
            ErrorNotifier.invalidInputFilesNotification();
            throw new RuntimeException(e);
        }
        System.out.println(data);
        return data;
    }
}
