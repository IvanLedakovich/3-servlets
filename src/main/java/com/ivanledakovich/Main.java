package com.ivanledakovich;

import java.io.File;

public class Main {

    public static void main(String uploadPath, String convertedPath) {
        File dir = new File(uploadPath);
        File[] directoryListing = dir.listFiles();
        if (directoryListing != null) {
            for (File child : directoryListing) {
                Thread.startANewThread("png", convertedPath, child.getAbsolutePath());
            }
        }
    }
}

