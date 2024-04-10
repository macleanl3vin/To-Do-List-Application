package task;

import java.util.ArrayList;

public class DateSort {
    public static void sortByDateThenPrint(ArrayList<task>[] todoList, String priorityLevel) {
        ArrayList<task> temp = new ArrayList<task>();

        // for (int i = 0; i < todoList.length; i++) {
        // for (task task : todoList[i]) {
        // temp.add(task);
        // }
        // }

        // Iterate through each task in the specified priority level and add them to
        // temp
        int priorityIndex = getPriorityIndex(priorityLevel);
        if (priorityIndex != -1) {
            for (task task : todoList[priorityIndex]) {
                temp.add(task);
            }
            // Bubble sort temp list by the due date
            int n = temp.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (temp.get(j).getDueDate().compareTo(temp.get(j + 1).getDueDate()) > 0) {
                        task tempTask = temp.get(j);
                        temp.set(j, temp.get(j + 1));
                        temp.set(j + 1, tempTask);
                    }
                }
            }

            todoList[priorityIndex].clear();

            for (task task : temp) {
                todoList[priorityIndex].add(task);
            }
            System.out.println("\u001B[32mTo-Do-List sorted successfully!\u001B[0m");
        }

        // Print sorted list based on priority level
        // not sure if this is still necessary
        for (task task : todoList[priorityIndex]) {
            if (task.getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
                System.out.println(task);
            }
        }

    }

    private static int getPriorityIndex(String priorityLevel) {
        switch (priorityLevel.toLowerCase()) {
            case "high":
                return 0;
            case "medium":
                return 1;
            case "low":
                return 2;
            default:
                return -1;
        }
    }
}
