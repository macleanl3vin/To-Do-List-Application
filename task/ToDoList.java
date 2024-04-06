package task;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<task>[] todoList;

    public ToDoList() {
        todoList = new ArrayList[3]; // create and array to hold 3 ArrayLists
        for (int i = 0; i < 3; i++) {
            todoList[i] = new ArrayList<task>();
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
    public ArrayList<task> search(String taskName) {
        ArrayList<task> matchingTasks = new ArrayList<>();

        for (int i = 0; i < todoList.length; i++) {
            ArrayList<task> tasks = todoList[i];
            for (int j = 0; j < tasks.size(); j++) {
                task currentTask = tasks.get(j);
                if (currentTask.getName().equals(taskName)) {
                    matchingTasks.add(currentTask);
                }
            }
        }
        if (matchingTasks.isEmpty()) {
            System.out.println("Task '" + taskName + "' not found.");
            return null;
        }
        return matchingTasks;
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
        String[] priorityLevels = { "\u001B[33mHigh\u001B[0m", "\u001B[33mMedium\u001B[0m", "\u001B[33mLow\u001B[0m" };

        System.out.println();
        for (int i = 0; i < 3; i++) {
            System.out.println("\u001B[35m-----------------------------------\u001B[0m");
            System.out.println("\u001B[37;1mPriority Level:\u001B[0m " + priorityLevels[i]);
            System.out.println();

            for (task task : todoList[i]) {
                System.out.println("\t" + task.toString());
            }
            System.out.println();
            System.out.println(
                    "\u001B[37;1mTotal tasks in Priority Level " + priorityLevels[i] + ": " + todoList[i].size());
            System.out.println("\u001B[35m-----------------------------------\u001B[0m");
        }
        System.out.println();

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

    // date sort methods
    // takes either high,med,low, or all as a parameter and then sorts tasks
    // matching that priority by date and prints
    public void sortTasksByDate(String priorityLevel) {
        DateSort.sortByDateThenPrint(todoList, priorityLevel);
    }

    public void sortTasksByName(String priorityLevel) {
        NameSort.sortByNameThenPrint(todoList, priorityLevel);
    }

}
