package org.example.numberFile;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
    public static String scanner(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String read = bufferedReader.readLine();
            while (read != null) {
                Pattern pattern = Pattern.compile("(\\(\\d{3}\\)\\s\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4})");
                Matcher matcher = pattern.matcher(read);
                if (matcher.find()) {
                    stringBuilder.append(read).append("\n");
                }
                read = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws IOException {
        File fileNumber = new File("src/main/resources/Number/file.txt");
        System.out.println("number.exists() = " + fileNumber);
        System.out.println("number.isFile() = " + fileNumber.isFile());
        System.out.println("scanner(fileNumber) : " + "\n" + scanner(fileNumber));


    }
}
