package com.ivanledakovich.logic;

import java.io.File;

public class ThreadStarter {

    public void startThreads(String imageExtension, String uploadPath, String convertedPath) {
        File dir = new File(uploadPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                Thread thread = new Thread();
                thread.startANewThread(imageExtension, convertedPath, child.getAbsolutePath());
            }
        }
    }
}