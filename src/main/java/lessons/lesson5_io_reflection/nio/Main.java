package lessons.lesson5_io_reflection.nio;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {

//        Path userFolder = Paths.get(System.getProperty("user.home"));

//        try {
//           Stream<Path> list = Files.list(userFolder);
//           list.forEach(r -> System.out.println(r));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        //This line of code creates a new Path object called txt, which represents a file path to a file named "test.txt" located in the user's home directory. The System.getProperty("user.home") method returns the path to the user's home directory, and the File.separator constant is used to create a platform-specific file separator to separate the home directory path from the "test.txt" file name.
        Path txt = Paths.get(System.getProperty("user.home") + File.separator + "test.txt");
//This line of code reads all the lines of text from the "test.txt" file located at the path represented by the txt object, and stores them in a List of String objects called lines. The Files.readAllLines() method is a convenient way to read all the lines of a text file in one shot, and returns a List of String objects, with each element of the list representing a line of text in the file.
        List<String> lines = Files.readAllLines(txt);
        //This line of code uses the forEach() method of the List class to iterate over each element of the lines list, and print each line of text to the console using the System.out.println() method. The forEach() method takes a lambda expression as its argument, which is used to define what should be done with each element of the list. In this case, the lambda expression is s -> System.out.println(s), which takes a String parameter called s, and prints it to the console.
        lines.forEach(s -> System.out.println(s));

        //if we want to write something
        //Here's a breakdown of the arguments to Files.write():
        //
        //txt: The Path object representing the file to write to.
        //"to write something".getBytes(StandardCharsets.UTF_8): The bytes to write to the file, which are obtained by converting the string "to write something" to a byte array using the UTF-8 character encoding.
        //StandardOpenOption.APPEND: The option indicating that the text should be appended to the end of the file.
        Files.write(txt,"to write something".getBytes(StandardCharsets.UTF_8), StandardOpenOption.APPEND);
    }
}
