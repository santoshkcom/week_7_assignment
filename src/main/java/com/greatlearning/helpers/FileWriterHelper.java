package com.greatlearning.helpers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileWriterHelper {
    public void writeToFile(String inputLine) {
        PrintWriter out = null;
        try {
            String fileName = "class_details.txt";
            File f = new File(fileName);

            if (f.exists() && !f.isDirectory()) {
                out = new PrintWriter(new FileOutputStream(fileName, true));
            } else {
                out = new PrintWriter(fileName);
            }
            out.println(inputLine);
            System.out.println("Information stored into file successfully.");
        } catch (Exception e) {
            System.out.println("Error occurred while writing to file:" + e.getMessage());
        } finally {
            if (out != null)
                out.close();
        }

    }

    public void RadFileContent() {
        String fileName = "class_details.txt";
        System.out.println("Class details:");
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(System.out::println);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
