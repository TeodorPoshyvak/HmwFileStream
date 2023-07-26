package org.example.frequencyFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class freqLogic {
    private static String readFile(File file) {
        StringBuilder results = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = br.readLine();
            while (line != null) {
                String[] splited = line.trim().split("\\s+");
                for (String words : splited) {
                    results.append(words).append(" ");
                }
                line = br.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }
        return results.toString().trim();
    }

    public static String freq(File file) {
        String[] splited = readFile(file).toLowerCase().split("\\s+");
        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> words = new HashMap<>();
        for (int i = 0; i < splited.length; i++) {
            int g = 0;
            for (int j = 0; j < splited.length; j++) {
                if (splited[i].equals(splited[j])) {
                    g++;
                }
            }
            words.put(splited[i], g);
        }

        List<Map.Entry<String, Integer>> sorted = new ArrayList<>(words.entrySet());
        sorted.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        for (Map.Entry<String, Integer> word : sorted) {
            sb.append(word).append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        File file = new File("src/main/resources/Frequency/words.txt");
        System.out.println(freq(file));
    }
}
