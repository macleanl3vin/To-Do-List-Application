package task;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoList {
    private static ArrayList<task>[] toDoList;
    private static final String[] PRIORITY_LEVELS = {
            "\u001B[33mHigh\u001B[0m",
            "\u001B[33mMedium\u001B[0m",
            "\u001B[33mLow\u001B[0m"
    };

    // Static block to initialize the array of task lists
    static {
        toDoList = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            toDoList[i] = new ArrayList<>();
        }
    }

    // Method to add tasks to the to-do list
    public void addTask(task task) {
        String priorityLevel = task.getPriorityLevel();
        int priorityIndex = getPriorityIndex(priorityLevel);

        if (priorityIndex != -1) {
            toDoList[priorityIndex].add(task);
        } else {
            System.out.println("\t\t\u001B[31mInvalid priority level\u001B[0m");
        }
    }

    // Method to search for tasks by name
    public ArrayList<task> search(String taskName) {
        ArrayList<task> matchingTasks = new ArrayList<>();

        // Search through the task list to find tasks that match criteria
        for (int i = 0; i < toDoList.length; i++) {
            ArrayList<task> tasks = toDoList[i];

            for (int j = 0; j < tasks.size(); j++) {
                task currentTask = tasks.get(j);

                if (currentTask.getName().equals(taskName)) {
                    matchingTasks.add(currentTask);
                }
            }
        }
        if (matchingTasks.isEmpty()) {
            System.out.println();
            System.out.println("\t\t\u001B[31mTask '" + taskName + "' not found\u001B[0m");
            System.out.println();
        }
        return matchingTasks;
    }

    // Method to delete a task by name
    public void delete(String taskName) {
        // Search through the task list to find tasks that match criteria
        for (int i = 0; i < toDoList.length; i++) {
            ArrayList<task> tasks = toDoList[i];

            for (int j = 0; j < tasks.size(); j++) {
                task currentTask = tasks.get(j);

                if (currentTask.getName().equals(taskName)) {
                    tasks.remove(j);
                    return;
                }
            }
        }
        System.out.println("\t\t\u001B[31mTask '" + taskName + "' not found\u001B[0m");
        System.out.println();
    }

    // Method to get the index of a priority level in the PRIORITY_LEVELS array
    public static int getPriorityIndex(String priorityLevel) {
        String trimmedPriority = priorityLevel.trim().toLowerCase();

        switch (trimmedPriority) {
            case "high":
                return findIndex("high");
            case "medium":
                return findIndex("medium");
            case "low":
                return findIndex("low");
            default:
                return -1;
        }
    }

    public static int findIndex(String priority) {
        for (int i = 0; i < PRIORITY_LEVELS.length; i++) {
            // Removing formatting and convert to lowercase before we compare
            String normalizedPriority = priority.replaceAll("\u001B\\[\\d+m", "").toLowerCase();
            String normalizedPriorityLevel = PRIORITY_LEVELS[i].replaceAll("\u001B\\[\\d+m", "").toLowerCase();

            if (normalizedPriority.equals(normalizedPriorityLevel)) {
                return i;
            }
        }
        return -1;
    }

    public void printToDoList() {
        boolean tasksExist = false;

        for (int i = 0; i < toDoList.length; i++) {
            if (!toDoList[i].isEmpty()) {
                tasksExist = true;
                break;
            }
        }

        for (int i = 0; i < toDoList.length; i++) {
            if (tasksExist) {
                if (!toDoList[i].isEmpty()) {
                    printByPriorityLevel(PRIORITY_LEVELS, i);
                } else {
                    printByPriorityLevel(PRIORITY_LEVELS, i);
                }
            } else {
                printByPriorityLevel(PRIORITY_LEVELS, i);
            }
        }
        System.out.println();
    }

    // a helper method used to print tasks groupedå by priority level
    private void printByPriorityLevel(String[] priorityLevels, int priorityIndex) {
        System.out.println("\u001B[35m-----------------------------------\u001B[0m");
        System.out.println("\u001B[37;1mPriority Level:\u001B[0m " + priorityLevels[priorityIndex]);
        System.out.println();

        if (!toDoList[priorityIndex].isEmpty()) {
            for (task t : toDoList[priorityIndex]) {
                System.out.println("\t" + t.toString());
            }
            System.out.println();
            System.out.println("\u001B[37;1mTotal tasks in Priority Level " + priorityLevels[priorityIndex] + ": "
                    + toDoList[priorityIndex].size());
        } else {
            System.out.println("\t\u001B[31mNo tasks in this priority level.\u001B[0m");
            System.out.println();
            System.out.println("\u001B[37;1mTotal tasks in Priority Level " + priorityLevels[priorityIndex] + ": 0");
        }
        System.out.println("\u001B[35m-----------------------------------\u001B[0m");
        System.out.println();
    }

    public void sortByPriority(String priorityLevel) {
        int priorityIndex = getPriorityIndex(priorityLevel);

        if (priorityIndex != -1) {
            ArrayList<task> tempList = toDoList[priorityIndex];
            String tempPriority = PRIORITY_LEVELS[priorityIndex];
            int currentPosition = -1;

            for (int i = 0; i < toDoList.length; i++) {
                if (toDoList[i] == tempList) {
                    currentPosition = i;
                    break;
                }
            }

            switch (priorityLevel) {
                case "high":
                    if (currentPosition == 0) {
                        break;
                    } else if (currentPosition == 2) {
                        sort(tempList, tempPriority, 0, 2);
                        break;
                    } else if (currentPosition == 1) {
                        sort(tempList, tempPriority, 0, 1);
                        break;
                    }
                    break;
                case "medium":
                    if (currentPosition == 1) {
                        sort(tempList, tempPriority, 0, 1);
                        break;
                    }
                    break;

                case "low":
                    if (currentPosition == 2) {
                        sort(tempList, tempPriority, 2, 0);
                        break;
                    }
                    break;
            }
        } else {
            System.out.println("\t\t\u001B[31mInvalid Priority Level.\u001B[0m");
        }
    }

    // Another helper method used to swap both task lists and priority levels during
    // sorting
    public void sort(ArrayList<task> tempList, String tempPriority, int num1, int num2) {
        tempList = toDoList[num1];
        toDoList[num1] = toDoList[num2];
        toDoList[num2] = tempList;

        tempPriority = PRIORITY_LEVELS[num1];
        PRIORITY_LEVELS[num1] = PRIORITY_LEVELS[num2];
        PRIORITY_LEVELS[num2] = tempPriority;
    }

    // date sort methods
    // takes either high,med,low, or all as a parameter and then sorts tasks
    // matching that priority by date and prints
    public void sortTasksByDate(String priorityLevel) {
        DateSort.sortByDate(toDoList, priorityLevel);
    }

    public void sortTasksByDateAll() {
        DateSort.sortByDateAll(toDoList);
    }

    public void sortByNamePriority(String priorityLevel) {
        if (!priorityLevel.equals("all")) {
            NameSort.sortByNamePriority(toDoList, priorityLevel);
            System.out.println("\t\u001B[32mTo-Do-List sorted by name successfully!\u001B[0m");
        }
    }

    public void writeToFile() {
        String filePath = "task/data/TaskFile.txt";

        try {
            FileWriter writer = new FileWriter(filePath);
            for (ArrayList<task> tasks : toDoList) {
                for (task task : tasks) {
                    // Ensure the original format is maintained: task, date, priority
                    String line = task.getName() + ", " + task.getDueDate() + ", " + task.getPriorityLevel();
                    writer.write(line + System.lineSeparator());
                }
            }
            writer.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }

}
