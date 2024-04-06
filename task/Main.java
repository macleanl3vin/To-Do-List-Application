package task;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ToDoList exampleToDoList = new ToDoList();

        // Prompt user for different options
        while (true) {
            printSeparator();
            System.out.println("\n\u001B[1m\u001B[36mChoose an option:\u001B[0m");
            System.out.println("\t1. Print the to-do list");
            System.out.println("\t2. Sort tasks by priority");
            System.out.println("\t3. Sort tasks by due date");
            System.out.println("\t4. Search for a task");
            System.out.println("\t5. Add a task");
            System.out.println("\t6. Exit\n");
            printSeparator();
            System.out.print("\u001B[1m\u001B[36mEnter your choice: \u001B[0m");

            int choice = scanner.nextInt();
            scanner.nextLine();
            printSeparator();

            switch (choice) {
                case 1:
                    exampleToDoList.printToDoList();
                    break;
                case 2:
                    System.out.print("Enter priority level (high, medium, low, or all): ");
                    String priorityLevel = scanner.next().toLowerCase();
                    exampleToDoList.sortByPriority(priorityLevel);
                    break;
                case 3:
                    System.out.print("Enter priority level (high, medium, low, or all): ");
                    String datePriority = scanner.next().toLowerCase();
                    exampleToDoList.sortTasksByDate(datePriority);
                    break;
                case 4:
                    System.out.print("\u001B[1m\u001B[36mEnter task name to search: \u001B[0m");
                    String taskName = scanner.next();
                    System.out.println();
                    ArrayList<task> foundTasks = exampleToDoList.search(taskName);

                    if (!foundTasks.isEmpty()) {
                        int namePadding = Math.max(0, 20 - foundTasks.get(0).getName().length());

                        System.out.printf("%s%" + namePadding + "s\t%s\t%s\t%s", "\u001B[1m\u001B[34mName", "",
                                "dueDate", "",
                                "priorityLevel\u001B[0m\n");
                        System.out.println("\u001B[35m-----------------------------------\u001B[0m");

                        for (task foundTask : foundTasks) {
                            System.out.println(foundTask);
                        }
                        System.out.println("\u001B[35m-----------------------------------\u001B[0m");

                    }
                    break;
                case 5:
                    addTasksToToDoList(exampleToDoList, scanner);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please choose a number between 1 and 5.");
                    break;
            }
        }
    }

    private static void addTasksToToDoList(ToDoList toDoList, Scanner scanner) {
        System.out.println();

        while (true) {
            System.out.println("\u001B[1m\u001B[36mAdd Tasks to your To-Do List:\u001B[0m");

            System.out.print("\t• Enter Task name (or type \u001B[32m'done'\u001B[0m to finish adding tasks): ");
            String taskName = scanner.nextLine();
            if (taskName.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("\t• Enter due date (YYYY-MM-DD): ");
            String dueDate = scanner.nextLine();
            if (!isValidDate(dueDate)) {
                System.out.println("\t\u001B[31mInvalid due date format. Please enter the date again.\u001B[0m");
                continue;
            }

            System.out.print("\t• Enter priority level (high, medium, low): ");
            String priorityLevel = scanner.nextLine();
            if (!isValidPriority(priorityLevel)) {
                System.out.println("\t\u001B[31mInvalid priority level. Please enter the level again.\u001B[0m");
                continue;
            }

            task newTask = new task(taskName, dueDate, priorityLevel);
            toDoList.addTask(newTask);
            System.out.println("\u001B[32mTask added successfully!\u001B[0m");
            System.err.println();
        }
    }

    private static boolean isValidPriority(String priorityLevel) {
        return priorityLevel.equalsIgnoreCase("high") ||
                priorityLevel.equalsIgnoreCase("medium") ||
                priorityLevel.equalsIgnoreCase("low");
    }

    private static boolean isValidDate(String date) {
        // check if the date matches the format YYYY-MM-DD using reg ex
        return date.matches("\\d{4}-\\d{2}-\\d{2}");
    }

    private static void printSeparator() {
        System.out.println("\u001B[33m-----------------------------------------------------------\u001B[0m");
    }
}
