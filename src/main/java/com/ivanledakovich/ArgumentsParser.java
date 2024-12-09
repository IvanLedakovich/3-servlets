package com.ivanledakovich;

import java.util.ArrayList;
import java.util.List;

/**
 * This class contains methods to parse command line arguments
 *
 * @author Ivan Ledakovich
 *
 */

public class ArgumentsParser {

    /**
     * This method converts command line arguments into a Parameter class object
     *
     * @param args command line arguments
     * @return command line arguments in form of a structured object of class Parameters
     *
     * @author Ivan Ledakovich
     *
     */

    public static Parameters parseArguments(String[] args) {

        Parameters parameters = new Parameters();

        for (int i = 0; i < args.length; i++) {
            if(args[i].equals("--help")){
                Help.help();
            }
            if (args[i].equalsIgnoreCase("--file-type")) {
                parameters.setImageFileType(args[i + 1]);
            }
            if (args[i].equalsIgnoreCase("--save-location")) {
                parameters.setImageSaveLocation(args[i + 1]);
            }
            if (args[i].equalsIgnoreCase("--file-path")) {
                parameters.setTextFilePaths(parseFilePaths(args, i));
            }
        }

        return parameters;
    }

    /**
     * This method converts command line .txt file paths into a List of Strings
     *
     * @param args command line arguments
     * @param currentArgumentIndex current argument index in command line
     * @return List of .txt file paths
     *
     * @author Ivan Ledakovich
     *
     */

    private static List<String> parseFilePaths(String[] args, int currentArgumentIndex) {
        List<String> textFilePaths = new ArrayList<String>();

        for (int i = currentArgumentIndex + 1; i < args.length; i++) {
            if (args[i].contains("--")) {
                break;
            } else {
                textFilePaths.add(args[i]);
            }
        }
        return textFilePaths;
    }
}
