/**
 * Program usage: java GrepCloneApplication -filepath (e.g. D:\Files\text.txt) -pattern (e.g. "John")
 *
 * This application accepts a file and a string from command line, and searches through the file
 * for any matches of the given string. When finished, it then prints the number of line, where
 * the match has been found along with the line itself.
 */

import java.io.*;
import java.util.*;

final public class GrepCloneApplication {

    /** *
     * @param filepath path to a file (e.g. D:\Files\text.txt)
     * @param pattern string representing a pattern to search in file
     */
    static void searchForPattern(String filepath, String pattern) throws FileNotFoundException {
        int lineCounter = 0;
        String firstLetterCapital = pattern.substring(0, 1).toUpperCase() + pattern.substring(1).toLowerCase();
        try (Scanner in = new Scanner(new FileInputStream(filepath))) {
            while(in.hasNextLine()) {
                lineCounter++;
                String line = in.nextLine();
                if(line.contains(pattern) || line.contains(firstLetterCapital)
                || line.contains(pattern.toLowerCase()) || line.contains(pattern.toUpperCase())) {
                    System.out.println(lineCounter + ":" + line);
                }
            }
        }
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("Program usage: java GrepCloneApplication -filepath -pattern");
            System.exit(1);
        } else {
            try {
                searchForPattern(args[0], args[1]);
            } catch (FileNotFoundException e) {
                System.out.println("Invalid filepath!");
                e.printStackTrace();
            }
        }
    }
}
