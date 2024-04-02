package task;

import java.util.Collections;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<task>[] todoList;

    public ToDoList() {
        todoList = new ArrayList[3]; // create and array to hold 3 ArrayLists
        for (int i = 0; i < 3; i++) {
            todoList[i] = new ArrayList<task>(); // or new ArrayList<>()
        }
    }

    public void addTask(task task) {
        String priorityLevel = task.getPriorityLevel(); // get the priority level of the task
        int priorityIndex = getPriorityIndex(priorityLevel); // get the index that corresponds to the priority level

        if (priorityIndex != -1) { // this may change because we will have something else making sure priorityLevel
                                   // is valid.
            todoList[priorityIndex].add(task);
        } else {
            System.out.println("Invalid priority level");
        }
    }

    // Search method that returns the task
    public task search(String taskName) {
        for (int i = 0; i < todoList.length; i++) {
            ArrayList<task> tasks = todoList[i];
            for (int j = 0; j < tasks.size(); j++) {
                task currentTask = tasks.get(j);
                if (currentTask.getName().equals(taskName)) {
                    return currentTask;
                }
            }
        }
        System.out.println("Task '" + taskName + "' not found.");
        return null;
    }

    // Delete method that deletes specified task
    public void delete(String taskName) {
        int j;
        for (int i = 0; i < todoList.length;) {
            ArrayList<task> tasks = todoList[i];
            for (j = 0; j < tasks.size(); j++) {
                task currentTask = tasks.get(j);
                if (currentTask.getName().equals(taskName)) {
                    break;
                }
            }
            for (int k = j; k < tasks.size() - 1; k++) {
                todoList[i].set(k, todoList[i].get(k + 1));
            }
            todoList[i].remove(tasks.size() - 1);
            return;
        }
        System.out.println("Task '" + taskName + "' not found.");
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

    public void sortByPriority(String priorityLevel) {
        int priorityIndex = getPriorityIndex(priorityLevel);
        if (priorityIndex != -1) {
            ArrayList<ArrayList<task>> sortedList = new ArrayList<>();
            for (int i = 0; i < 3; i++) {
                sortedList.add(new ArrayList<task>());
            }

            // For high priority tasks
            if (priorityIndex == 0) {
                for (int i = 0; i < 3; i++) {
                    for (task task : todoList[i]) {
                        if (task.getPriorityLevel().equalsIgnoreCase("high")) {
                            sortedList.get(0).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("medium")) {
                            sortedList.get(1).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("low")) {
                            sortedList.get(2).add(task);
                        }
                    }
                }
            }
            // for medium priority, not sure how we want to sort this....
            else if (priorityIndex == 1) {
                for (int i = 0; i < 3; i++) {
                    for (task task : todoList[i]) {
                        if (task.getPriorityLevel().equalsIgnoreCase("low")) {
                            sortedList.get(0).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("medium")) {
                            sortedList.get(1).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("high")) {
                            sortedList.get(2).add(task);
                        }
                    }
                }
            }
            // low priority tasks
            else if (priorityIndex == 2) {
                for (int i = 0; i < 3; i++) {
                    for (task task : todoList[i]) {
                        if (task.getPriorityLevel().equalsIgnoreCase("low")) {
                            sortedList.get(0).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("medium")) {
                            sortedList.get(1).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("high")) {
                            sortedList.get(2).add(task);
                        }
                    }
                }
            }

            // replace the original unsorted todoList with the sorted one recently made
            todoList = sortedList.toArray(new ArrayList[3]);
        } else {
            System.out.println("Invalid priority level");
        }
    }

    public ArrayList<task> getOneList(String string) {
        int currentArray = getPriorityIndex(string);
        return todoList[currentArray];
    }

    // sorting by date soonest first and put into temp array and then print that.
    public void sortByDateThenPrint() {
        ArrayList<task> temp = new ArrayList<task>();
        for (int i = 0; i < 3; i++) {
            for (task task : todoList[i]) {
                temp.add(task);
            }
        }
        // bubble sort temp list by the date
        for (int i = 0; i < temp.size(); i++) {
            for (int j = 0; j < temp.size() - 1; j++) {
                if (temp.get(j).getDueDate().compareTo(temp.get(j + 1).getDueDate()) > 0) {
                    task tempTask = temp.get(j);
                    temp.set(j, temp.get(j + 1));
                    temp.set(j + 1, tempTask);
                }
            }
        }
        // print sorted list
        for (task task : temp) {
            System.out.println(task.toString());
        }

    }

}
