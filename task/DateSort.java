package task;

import java.util.ArrayList;

public class DateSort {
    // Sort all priority levels
    public static void sortByDateAll(ArrayList<task>[] toDoList) {
        for (String level : new String[] { "high", "medium", "low" }) {
            sortByDate(toDoList, level);
        }
    }

    public static void sortByDate(ArrayList<task>[] toDoList, String priorityLevel) {
        int priorityIndex = ToDoList.getPriorityIndex(priorityLevel);

        if (priorityIndex != -1) {
            ArrayList<task> tasks = toDoList[priorityIndex];
            // Bubble sort tasks list by the due date
            int n = tasks.size();
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i - 1; j++) {
                    if (tasks.get(j).getDueDate().compareTo(tasks.get(j + 1).getDueDate()) > 0) {
                        // Swap elements directly within the ArrayList
                        task tempTask = tasks.get(j);
                        tasks.set(j, tasks.get(j + 1));
                        tasks.set(j + 1, tempTask);
                    }
                }
            }
        }
    }
}
