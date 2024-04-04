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
        for(int i = 0; i < todoList.length; i++) {
            for(task task : todoList[i]) {
                holder.add(task);
            }
        }
        insertionSort(holder);
        for(int i = 0; i < holder.size(); i++) {
            if (priorityLevel.equalsIgnoreCase("All") || holder.get(i).getPriorityLevel().equalsIgnoreCase(priorityLevel)) {
                System.out.println(holder.get(i).toString());
            }  
        }

    }
}
