package org.example.jsonFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.*;

public class User {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private static List<User> readCollect(File file) {
        List<User> usersList = new LinkedList<>();
        String read;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            while ((read = bufferedReader.readLine()) != null) {
                String[] result = read.split(" ");
                if (!result[0].toLowerCase().contains("name") && !result[1].toLowerCase().contains("age")) {
                    usersList.add(new User(result[0].trim(), Integer.parseInt(result[1])));
                }
            }
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
        return usersList;
    }

    public static void writerJson(File inputFile, File outputFile) {
        List<User> usersList = readCollect(inputFile);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(usersList);
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFile))) {
            writer.write(json);
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }

    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/JsonFile/file.txt";
        String outputFilePath = "src/main/resources/JsonFile/user.json";
        File inputFile = new File(inputFilePath);
        File outputFile = new File(outputFilePath);
        writerJson(inputFile, outputFile);

    }
}
