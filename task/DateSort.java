package task;

import java.util.ArrayList;


public class DateSort {
    

    public static void sortByDateThenPrint(ArrayList<task>[] todoList, String priorityLevel) {
        ArrayList<task> temp = new ArrayList<>();
        for (ArrayList<task> taskList : todoList) {
            temp.addAll(taskList);
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
    
        // Print sorted list based on priority level
        for (task task : temp) {
            if (priorityLevel.equalsIgnoreCase("All") || task.getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
                System.out.println(task);
            }
        }
    }
}
