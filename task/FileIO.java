package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
    public static void readFile(ToDoList todoList) {
        String filePath = "task/data/TaskFile.txt"; // Specify the file path here

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                if (parts.length == 3) { // Ensure correct format: task, date, priority
                    String name = parts[0].trim(); // Trim leading and trailing spaces
                    String date = parts[1].trim(); 
                    String priority = parts[2].trim();
                    task task = new task(name, date, priority);
                    todoList.addTask(task);
                } else {
                    System.out.println("Invalid format in file: " + line);
                }
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }
    }

}
