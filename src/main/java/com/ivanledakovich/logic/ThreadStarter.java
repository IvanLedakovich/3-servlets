package com.ivanledakovich.logic;

import com.ivanledakovich.models.Parameters;

import java.io.File;

public class ThreadStarter {

	public static void startThreads(String imageExtension, String uploadPath, String convertedPath) {
		File dir = new File(uploadPath);
		File[] directoryListing = dir.listFiles();
		if (directoryListing != null) {
			for (File child : directoryListing) {
				Thread.startANewThread(imageExtension, convertedPath, child.getAbsolutePath());
			}
		}
	}

	public static void main(String[] args) {
		Parameters parameters = ArgumentsParser.parseArguments(args);
		for (int i = 0; i < parameters.getAllTextFilePaths().size(); i++) {
			Thread.startANewThread(parameters.getImageFileType(), parameters.getImageSaveLocation(), parameters.getSingleTextFilePath(i));
		}
	}
}