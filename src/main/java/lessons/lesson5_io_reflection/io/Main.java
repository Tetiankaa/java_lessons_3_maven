package lessons.lesson5_io_reflection.io;

import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Main {
    @SneakyThrows
    public static void main(String[] args) {

        Properties prop = System.getProperties();

        for (Object o : prop.keySet()) {
            System.out.println(o);
        }
        //, System.getProperties() is a method call that returns a Properties object representing the current system properties.
        //
        //System properties are key-value pairs that provide information about the environment in which the Java Virtual Machine (JVM) is running,
        // such as the operating system, file separator, and user account information.
        //
        //The Properties object returned by System.getProperties() can be used to read and modify system properties at runtime.
        // For example, you can use this method to get the value of a specific system property by passing
        // its key as an argument to the getProperty() method, like this:

        String userFolderPath = System.getProperty("user.home");

        File file = new File(userFolderPath + File.separator + "test.txt");
        if (!file.exists()){
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file,true);//вихідний потік. Для того щоб записати щось у новостворений файл. Бо сам файл test.txt - це тільки посилання на нього.
        //append: true - Якщо для цього аргументу встановлено значення true, це означає, що будь-які дані, записані у файл, будуть додані в кінець файлу, а не перезаписані його вміст.
        //false - значить що файл перезапишеться.
        String s = "hello";
        byte[] bytes = s.getBytes(StandardCharsets.UTF_8);
        fileOutputStream.write(bytes);
        fileOutputStream.close();

        //Зчитати інформацію з того файлу що створили

        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytesRead = new byte[fileInputStream.available()];
        fileInputStream.read(bytesRead);
        String msg = new String(bytesRead);
        System.out.println(msg);
    }
}
