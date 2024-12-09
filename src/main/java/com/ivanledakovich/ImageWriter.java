package com.ivanledakovich;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * This class contains the method which writes the generated image
 *
 * @author Ivan Ledakovich
 *
 */

public class ImageWriter {

    /**
     * This method writes the final image file
     *
     * @param image generated image
     * @param imageFileType image file type for saving
     * @param imageSaveLocation locations to save the image
     * @param textFilePath the path to the initial .txt file
     *
     * @author Ivan Ledakovich
     *
     */

    public static void writeImage (BufferedImage image, String imageFileType, String imageSaveLocation, String textFilePath) {
        try {
            ImageIO.write(image, imageFileType, new File(imageSaveLocation + "\\" + textFilePath.substring(textFilePath.lastIndexOf("\\")+1) + "." + imageFileType));
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
