package task;
import java.util.ArrayList;
import java.util.Arrays;

public class matrix {
    //matrix object containing three arrayLists
    public void toDoList() {
        ArrayList<ArrayList<task>> matrix = new ArrayList<ArrayList<task>>();
        ArrayList<task> low = new ArrayList<task>();
        ArrayList<task> medium = new ArrayList<task>();
        ArrayList<task> high = new ArrayList<task>();
        matrix.add(low);
        matrix.add(medium);
        matrix.add(high);
    }

    private task[] getPrioList(String string) {
        switch(string) {
            case "low":
                return null;
            case "medium":
                return null;
            case "high":
                return null;
        }
        return null;
    }

    public void printOnePrio(String string) {
        if (string.equals("low") || string.equals("medium") || string.equals("high")) {
            System.out.println(getPrioList(string));
        } else {
            System.out.println(string + " is not a valid command. Enter \"high\", \"medium\", or \"low\".");
        }
    }
}
