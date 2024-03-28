package task;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<task>[] todoList;


    public ToDoList() {
        todoList = new ArrayList[3]; //create and array to hold 3 ArrayLists
        for (int i = 0; i < 3; i++) {
            todoList[i] = new ArrayList<task>(); // or new ArrayList<>()
        }
    }
    
    
    public void addTask(task task){
        String priorityLevel = task.getPriorityLevel(); //get the priority level of the task
        int priorityIndex = getPriorityIndex(priorityLevel); //get the index that corresponds to the priority level
        
        if (priorityIndex != -1) {                  //this may change because we will have something else making sure priorityLevel is valid.
            todoList[priorityIndex].add(task);
        }
        else{                              
            System.out.println("Invalid priority level");
        }
    }


    private int getPriorityIndex(String priorityLevel) {
        switch (priorityLevel.toLowerCase()) {
            case "high":
                return 0;
            case "medium":
                return 1;
            case "low":
                return 2;
            default:
                return -1;
        }
    }

    public void printToDoList() {
        for (int i = 0; i < 3; i++) {
            for (task task : todoList[i]) {
                System.out.println(task.toString()); // Utilize toString() method here
            }
            System.out.println("Total tasks in Priority Level " + i + ": " + todoList[i].size());

        }
        
    }

   //sorting by date soonest first and put into temp array and then print that.
    public void sortByDateThenPrint() {
        ArrayList<task> temp = new ArrayList<task>();
        for (int i = 0; i < 3; i++){
            for (task task : todoList[i]){
                temp.add(task);
            }
        }
        //bubble sort temp list by the date
        for (int i = 0; i < temp.size(); i++){
            for (int j = 0; j < temp.size() - 1; j++){
                if (temp.get(j).getDueDate().compareTo(temp.get(j + 1).getDueDate()) > 0){
                    task tempTask = temp.get(j);
                    temp.set(j, temp.get(j + 1));
                    temp.set(j + 1, tempTask);
                }
            }
        }
        //print sorted list
        for (task task : temp){
            System.out.println(task.toString());
        }

    }
    
}

   
