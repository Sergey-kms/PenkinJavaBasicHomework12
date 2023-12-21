package ru.java.basic.penkin.hw12;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileReadWrite {
    public static void main(String[] args) {         // Получение текстовых файлов из корневого каталога.
        File rootDirectory = new File(".");
        File[] files = rootDirectory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (files != null) {
            for (File file : files) {
                System.out.println(file.getName());
            }
        }

        Scanner scanner = new Scanner(System.in);     // Запрос имени файла, для считывания и вывода содержимого файла в консоль и записи строки в данного файл.

        System.out.print("Введите имя файла, для вывода в консоль содержимого данного файла и записи строки в файл: ");
        String fileName = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {       // Считывание содержимого файла и вывод этого содержимого в консоль.

            System.out.println("Содержимое файла:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {       // Запись строки в выбранный файл.

            System.out.print("Введите строку для записи в выбранный файл: ");
            String input = scanner.nextLine();
            writer.write(input);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        scanner.close();
    }
}