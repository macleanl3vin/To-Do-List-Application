package task;
import java.util.ArrayList;

public class NameSort extends ToDoList{
    //task sortArray[];

    public ArrayList<task> alphabetSort(String priorityString) {
        ArrayList<task> holder = getOneList(priorityString);
        task temp;
        for (int i = 0; i < holder.size(); i++) {
            for (int j = i + 1; j < holder.size(); j++) {
                if (holder.get(i).getName().compareTo(holder.get(j).getName()) > 0) {
                    temp = holder.get(i);
                    holder.set(i, holder.get(j));
                    holder.set(j, temp);
                }
            }
        }
        return holder;
    }

    public ArrayList<task> tests() {
        return null;
    }
}
