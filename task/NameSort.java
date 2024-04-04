package task;
import java.util.ArrayList;

public class NameSort extends ToDoList{
    //task sortArray[];

    public ArrayList<task> insertionSort(ArrayList<task> base) {
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

    public ArrayList<task> alphabetSort(String priorityString) {
        ArrayList<task> holder = getOneList(priorityString);
        insertionSort(holder);
        for(int i = 0; i < holder.size(); i++) {
            System.out.println(holder.get(i).toString());
        }
        return holder;
    }

    public ArrayList<task> alphabetSortAll() {
        ArrayList<task> output = getOneList("low");
        ArrayList<task> holderMid = getOneList("medium");
        ArrayList<task> holderHigh = getOneList("high");
        output.addAll(holderMid);
        output.addAll(holderHigh);
        insertionSort(output);
        for(int i = 0; i < output.size(); i++) {
            System.out.println(output.get(i).toString());
        }
        return output;
    }

    public ArrayList<task> tests() {
        return null;
    }
}
