package task;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        task task1 = new task("Hw", "2024-03-30", "Low");
        task task2 = new task("Project 2", "2024-04-15", "High");
        task task3 = new task("Study for test", "2024-04-01", "Medium");
        task task4 = new task("Grocery shopping", "2024-03-25", "Medium");
        task task5 = new task("Write report", "2024-04-10", "High");
        task task6 = new task("Exercise", "2024-03-28", "Low");
        task task7 = new task("Meeting with c", "2024-04-05", "High");
        task task8 = new task("Call mom", "2024-03-29", "Low");
        task task9 = new task("Read book", "2024-04-02", "Medium");
        task task10 = new task("Clean room", "2024-03-27", "Low");
        task task11 = new task("Plan vacation", "2024-04-20", "High");
        task task12 = new task("Wrap presents", "2024-04-08", "Medium");
        task task13 = new task("Pay bills", "2024-03-31", "High");
        task task14 = new task("Attend workshop", "2024-04-03", "Medium");
        task task15 = new task("Take out trash", "2024-03-26", "Low");

        ToDoList exampleToDoList = new ToDoList();
        exampleToDoList.addTask(task1);
        exampleToDoList.addTask(task2);
        exampleToDoList.addTask(task3);
        exampleToDoList.addTask(task4);
        exampleToDoList.addTask(task5);
        exampleToDoList.addTask(task6);
        exampleToDoList.addTask(task7);
        exampleToDoList.addTask(task8);
        exampleToDoList.addTask(task9);
        exampleToDoList.addTask(task10);
        exampleToDoList.addTask(task11);
        exampleToDoList.addTask(task12);
        exampleToDoList.addTask(task13);
        exampleToDoList.addTask(task14);
        exampleToDoList.addTask(task15);

        // ArrayList<task> temp = exampleToDoList.getOneList("high");

        // print sorted list
        // for (task task : temp) {
        // System.out.println(task.toString());
        // }
        exampleToDoList.sortByPriority("low");
        exampleToDoList.printToDoList();
                
        /*  
            datesorting

        //exampleToDoList.sortTasksByDate("high");
        //exampleToDoList.sortTasksByDate("low");
        //exampleToDoList.sortTasksByDate("medium");
        //exampleToDoList.sortTasksByDate("all");     
        */

        // System.out.println(exampleToDoList.search("Pay bills"));
        // exampleToDoList.alphabetSort("high");

    }
}
