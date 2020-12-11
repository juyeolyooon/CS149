import java.io.*;
import java.util.*;

/*
Write a program that reads a Java source file and produces an index of all identifiers in the file.
For each identifier, print all lines in which it occurs.
For simplicity, we will consider each string consisting only of letters, numbers, and underscores an identifer.
Declare a Scanner in for reading from the source file and call in.useDelimiter("[^A-Za-z0-9_]+").
Then each call to next returns an identifier.
 */
public class E5_15 {
    public static void main(String[] args) throws FileNotFoundException {
        // take one command line argument for the file to read
        if (args.length != 0) {
            // use LinkedHashMap to keep the order
            LinkedHashMap<Integer, String> identifier = new LinkedHashMap<>();
            HashMap<String, String> lines = new HashMap<>();
            File file = new File(args[0]);
            Scanner scanFile = new Scanner(file);
            int index = 0; // index for identifiers
            while (scanFile.hasNextLine()) {
                String line = scanFile.nextLine();
                Scanner in = new Scanner(line);
                in.useDelimiter("[^A-Za-z0-9_]+");
                while (in.hasNext()) {
                    String id = in.next();
                    if (lines.containsKey(id)) { // if identifier already exist
                        String previous = lines.get(id);
                        lines.put(id, previous + "\n" + line); // update lines
                    } else {
                        identifier.put(index, id);
                        lines.put(id, line);
                        index++;
                    }
                }
            }
            // print result
            for (Integer i : identifier.keySet()) {
                String id = identifier.get(i);
                System.out.println("Identifier " + i + ": \"" + id +"\" occurs in:");
                System.out.println(lines.get(id) + "\n");
            }
        } else {
            System.out.println("Need a command line argument for the file to read.");
        }
    }
}
