package task;

import java.util.ArrayList;

public class DateSort {
    
    
    
    public static void sortByDateAll(ArrayList<task>[] todoList) {
        // Sort all priority levels
        for (String level : new String[]{"high", "medium", "low"}) {
            sortByDate(todoList, level);
        }
    }
    
    
    
    
    
    public static void sortByDate(ArrayList<task>[] todoList, String priorityLevel) {
        int priorityIndex = ToDoList.getPriorityIndex(priorityLevel);
        if (priorityIndex != -1) {
            ArrayList<task> tasks = todoList[priorityIndex];
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

            System.out.println("\t\u001B[32mTo-Do-List sorted by due-date successfully!\u001B[0m");
            System.out.println();
        }
    }
}

