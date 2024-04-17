package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileIO {
    public static void readFile(ToDoList toDoList) {
        // Specify the file path to the file containing the todo list tasks
        String filePath = "task/data/TaskFile.txt";

        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            // Reading each line of the file
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");

                // This ensures correct format of the array: task, date, priority
                if (parts.length == 3) {
                    // Triming leading and trailing spaces for task, date, priority.
                    String name = parts[0].trim();
                    String date = parts[1].trim();
                    String priority = parts[2].trim();

                    // Create a new task and add it to the toDoList
                    task task = new task(name, date, priority);
                    toDoList.addTask(task);
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
