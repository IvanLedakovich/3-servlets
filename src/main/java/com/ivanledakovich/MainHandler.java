package com.ivanledakovich;

import java.io.File;

public class MainHandler {

    public static void mainHandler(String imageExtension, String uploadPath, String convertedPath) {
        File dir = new File(uploadPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                Thread.startANewThread(imageExtension, convertedPath, child.getAbsolutePath());
            }
        }
    }
}