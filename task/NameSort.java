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

    public static void sortByNameThenPrint(ArrayList<task>[] todoList, String priorityLevel) {
        ArrayList<task> holder = new ArrayList<task>();
        for (int i = 0; i < todoList.length; i++) {
            for (task task : todoList[i]) {
                holder.add(task);
            }
        }
        insertionSort(holder);
        for (int i = 0; i < holder.size(); i++) {
            if (priorityLevel.equalsIgnoreCase("All")
                    || holder.get(i).getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
                System.out.println(holder.get(i).toString());
            }
        }

    }

}

// public static void sortByNameThenPrint(ArrayList<task>[] todoList, String
// priorityLevel) {
// ArrayList<task> holder = new ArrayList<task>();
// for (int i = 0; i < todoList.length; i++) {
// for (task task : todoList[i]) {
// holder.add(task);
// }
// }
// holder = insertionSort(holder); // Sorting holder using insertion sort

// // Replace the original todoList with the sorted holder
// for (int i = 0; i < todoList.length; i++) {
// todoList[i].clear();
// }
// for (task t : holder) {
// int priorityIndex = getPriorityIndex(t.getPriorityLevel());
// todoList[priorityIndex].add(t); // Adding sorted tasks back to todoList based
// on priority level
// }

// // Printing sorted list based on priority level
// for (int i = 0; i < holder.size(); i++) {
// if (priorityLevel.equalsIgnoreCase("All")
// || holder.get(i).getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
// System.out.println(holder.get(i).toString());
// }
// }
// }
