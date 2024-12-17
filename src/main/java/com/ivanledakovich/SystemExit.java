package com.ivanledakovich;

/**
 * This class contains the method which shuts down the program
 *
 * @author Ivan Ledakovich
 */
public class SystemExit {

    /**
     * This method shuts down the program
     *
     * @param status status which the program shuts down with
     */
    public static void systemExit(int status){
        System.exit(status);
    }
}
