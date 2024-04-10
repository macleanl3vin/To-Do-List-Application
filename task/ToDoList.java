package task;

import java.util.ArrayList;

public class ToDoList {
    private ArrayList<task>[] todoList;

    public ToDoList() {
        todoList = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            todoList[i] = new ArrayList<task>();
        }
    }

    // Add methods that adds tasks to todo list
    public void addTask(task task) {
        String priorityLevel = task.getPriorityLevel(); // get the priority level of the task
        int priorityIndex = getPriorityIndex(priorityLevel); // get the index that corresponds to the priority level

        if (priorityIndex != -1) { // this may change because we will have something else making sure priorityLevel
                                   // is valid.
            todoList[priorityIndex].add(task);
        } else {
            System.out.println("\t\t\u001B[31mInvalid priority level\u001B[0m");
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
            System.out.println("\t\t\u001B[31mTask '" + taskName + "' not found\u001B[0m");
            System.out.println();
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
        System.out.println("\t\t\u001B[31mTask '" + taskName + "' not found\u001B[0m");
        System.out.println();
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
        String[] priorityLevels = { "\u001B[33mHigh\u001B[0m", "\u001B[33mMedium\u001B[0m",
                "\u001B[33mLow\u001B[0m" };
        boolean tasksExist = false;

        for (int i = 0; i < todoList.length; i++) {
            if (!todoList[i].isEmpty()) {
                tasksExist = true;
                break;
            }
        }

        if (tasksExist) {
            if (todoList[0].get(0).getPriorityLevel().equals("high")) {
                String[] priorityLevelsHigh = { "\u001B[33mHigh\u001B[0m", "\u001B[33mMedium\u001B[0m",
                        "\u001B[33mLow\u001B[0m" };

                for (int i = 0; i < todoList.length; i++) {
                    if (!todoList[i].isEmpty()) {
                        printByPriorityLevel(priorityLevelsHigh, i);
                    }
                }
            } else if (todoList[0].get(0).getPriorityLevel().equals("low")) {
                String[] priorityLevelsLow = { "\u001B[33mLow\u001B[0m", "\u001B[33mMedium\u001B[0m",
                        "\u001B[33mHigh\u001B[0m" };
                for (int i = 0; i <= 2; i++) {
                    if (!todoList[i].isEmpty()) {
                        printByPriorityLevel(priorityLevelsLow, i);
                    }
                }
            } else {
                String[] priorityLevelsLow = { "\u001B[33mMedium\u001B[0m", "\u001B[33mLow\u001B[0m",
                        "\u001B[33mHigh\u001B[0m" };
                for (int i = 0; i <= 2; i++) {
                    if (!todoList[i].isEmpty()) {
                        printByPriorityLevel(priorityLevelsLow, i);
                    }
                }
            }
        } else {
            for (int i = 0; i < 3; i++) {
                System.out.println("\u001B[35m-----------------------------------\u001B[0m");
                System.out.println("\u001B[37;1mPriority Level:\u001B[0m " + priorityLevels[i]);
                System.out.println();
                System.out.println("\t\u001B[31mNo tasks in this priority level.\u001B[0m");
                System.out.println();
                System.out.println("\u001B[37;1mTotal tasks in Priority Level " + priorityLevels[i] + ": 0");
                System.out.println("\u001B[35m-----------------------------------\u001B[0m");
            }
        }
        System.out.println();
    }

    private void printByPriorityLevel(String[] priorityLevels, int priorityIndex) {
        System.out.println("\u001B[35m-----------------------------------\u001B[0m");
        System.out.println("\u001B[37;1mPriority Level:\u001B[0m " +
                priorityLevels[priorityIndex]);
        System.out.println();

        if (!todoList[priorityIndex].isEmpty()) {
            for (task task : todoList[priorityIndex]) {
                System.out.println("\t" + task.toString());
            }
            System.out.println();
            System.out.println("\u001B[37;1mTotal tasks in Priority Level " +
                    priorityLevels[priorityIndex] + ": "
                    + todoList[priorityIndex].size());
        } else {
            System.out.println("\tNo tasks in this priority level.");
            System.out.println("\u001B[37;1mTotal tasks in Priority Level " +
                    priorityLevels[priorityIndex] + ": 0");
        }
        System.out.println("\u001B[35m-----------------------------------\u001B[0m");
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
            // for medium priority tasks
            else if (priorityIndex == 1) {
                for (int i = 0; i < 3; i++) {
                    for (task task : todoList[i]) {
                        if (task.getPriorityLevel().equalsIgnoreCase("medium")) {
                            sortedList.get(0).add(task);
                        } else if (task.getPriorityLevel().equalsIgnoreCase("low")) {
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
            todoList = sortedList.toArray(new ArrayList[3]);
        } else {
            System.out.println("\t\t\u001B[31mInvalid Priority Level.\u001B[0m");
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
