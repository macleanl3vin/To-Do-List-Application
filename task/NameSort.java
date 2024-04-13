package task;

import java.util.ArrayList;

public class NameSort {

    public static ArrayList<task> insertionSort(ArrayList<task> base) {
        task temp;
        for (int i = 0; i < base.size(); i++) {
            for (int j = i + 1; j < base.size(); j++) {
                if (base.get(i).getName().compareTo(base.get(j).getName()) > 0) {
                    temp = base.get(i);
                    base.set(i, base.get(j));
                    base.set(j, temp);
                }
            }
        }
        return base;
    }

    // Sorts all tasks by name
    public static void sortByNameThenPrint(ArrayList<task>[] todoList, String priorityLevel) {
        ArrayList<task> holder = new ArrayList<task>();
        for (int i = 0; i < todoList.length; i++) {
            for (task task : todoList[i]) {
                holder.add(task);
            }
        }
    }

    public static void sortByNamePriority(ArrayList<task>[] todoList, String priorityLevel) {
        ArrayList<task> holder = new ArrayList<>();
        for (ArrayList<task> tasks : todoList) {
            for (task t : tasks) {
                if (t.getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
                    holder.add(t);
                }
            }
        }

        

        insertionSort(holder);
        int priorityIndex = ToDoList.getPriorityIndex(priorityLevel);

        todoList[priorityIndex].clear();

        for (task task : holder) {
            todoList[priorityIndex].add(task);
        }

    }
}
