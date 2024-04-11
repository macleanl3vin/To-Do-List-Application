package task;

import java.util.ArrayList;

public class DateSort {
    public static void sortByDateThenPrint(ArrayList<task>[] todoList, String priorityLevel) {
        ArrayList<task> temp = new ArrayList<task>();

        int priorityIndex = ToDoList.getPriorityIndex(priorityLevel);
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
            System.out.println("\t\u001B[32mTo-Do-List sorted by due-date successfully!\u001B[0m");
            System.out.println();
        }
    }
}
