package com.ivanledakovich.logic;

import java.io.File;

public class ThreadStarter {

    public static void threadStarter(String imageExtension, String uploadPath, String convertedPath) {
        File dir = new File(uploadPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                Thread.startANewThread(imageExtension, convertedPath, child.getAbsolutePath());
            }
        }
    }
}