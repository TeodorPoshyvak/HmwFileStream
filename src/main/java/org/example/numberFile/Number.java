package org.example.numberFile;

import java.io.*;

public class Number {
    public static String scanner(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String read = bufferedReader.readLine();
            while (read != null) {
                String[] num = read.split("");
                if ((num[0].equals("(") & num[4].equals(")")) && (num[5].equals(" ") & num[9].equals("-"))) {
                    if (num.length <= 14) {
                        stringBuilder.append(read).append("\n");
                    }
                }
                if (num[3].equals("-") && num[7].equals("-")) {
                    if (num.length <= 12) {
                        stringBuilder.append(read).append("\n");
                    }
                }
                read = bufferedReader.readLine();
            }
        } catch (IOException e) {
            System.err.println("Error" + e.getMessage());
        }
        return stringBuilder.toString();
    }


    public static void main(String[] args) throws IOException {
        File fileNumber = new File("C:\\Users\\Teodor Poshyvak\\OneDrive\\Робочий стіл\\java\\HmwFileStream\\src\\main\\resources\\Number\\file.txt");
        System.out.println("number.exists() = " + fileNumber);
        System.out.println("number.isFile() = " + fileNumber.isFile());
        System.out.println("scanner(fileNumber) = " + scanner(fileNumber));


    }
}
