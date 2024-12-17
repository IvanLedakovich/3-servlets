package com.ivanledakovich;

import org.apache.log4j.Logger;

public class ErrorNotifier {
    static final private Logger logger = Logger.getLogger(FileReader.class);

    public static void invalidInputFilesNotification(){
        logger.info("Please check if the input file(s) are valid, of .txt format and not empty.");
        SystemExit.systemExit(0);
    }

    public static void invalidFileTypeNotification(){
        logger.info("Please check if the selected image format is correct. The program accepts png and jpg format selection.");
        SystemExit.systemExit(0);
    }

    public static void fileCouldNotBeWritten(){
        logger.info("Could not write the file. Please check if the provided save directory exists and is writable.");
        SystemExit.systemExit(0);
    }
}
