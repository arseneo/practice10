import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Practice10 {
    public static void main(String[] args) {
        System.out.println("Practical task 1.10, Student Korneev Arseniy, RIBO-04-22, Variant 2");
        // Запросить путь к исходному файлу у пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter path to text file:");
        String inputFilePath = scanner.nextLine();
        scanner.close();

        // Проверить, был ли передан путь к файлу
        if (inputFilePath.isEmpty()) {
            System.out.println("No path entered.");
            return;
        }

        // Считать и перевернуть строки из исходного файла
        try {
            File inputFile = new File(inputFilePath);
            Scanner fileScanner = new Scanner(inputFile);
            
            // Получить имя исходного файла без расширения
            String fileName = inputFilePath.substring(0, inputFilePath.lastIndexOf('.'));
            // Создать выходной файл
            String outputFilePath = fileName + "_modified.txt";
            // Создать PrintWriter для записи в новый файл
            PrintWriter writer = new PrintWriter(outputFilePath);

            while (fileScanner.hasNextLine()) {
                // Считать строку из исходного файла
                String line = fileScanner.nextLine();
                // Перевернуть строку
                String reversedLine = reverseString(line);
                // Записать перевернутую строку в новый файл
                writer.println(reversedLine);
            }

            // Закрыть Writer и Scanner
            writer.close();
            fileScanner.close();

            System.out.println("File modified. New file saved as " + outputFilePath);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    // Метод для переворачивания строки
    private static String reverseString(String str) {
        return new StringBuilder(str).reverse().toString();
    }
}