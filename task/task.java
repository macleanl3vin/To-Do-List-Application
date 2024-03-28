package task;

import java.util.ArrayList;

public class task {
    private String name;
    private String dueDate;
    private String priorityLevel;

    public task(String name, String dueDate, String priorityLevel) {
        this.name = name;
        this.dueDate = dueDate;
        this.priorityLevel = priorityLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    // Delete method to remove task
    public static void delete(ArrayList<task> tasks, String taskName) {
        for (int i = 0; i < tasks.size(); i++) {
            task currentTask = tasks.get(i);
            if (currentTask.getName().equals(taskName)) {
                tasks.remove(i);
                System.out.println("Task '" + taskName + "' deleted successfully.");
                return;
            }
        }
        System.out.println("Task '" + taskName + "' not found.");
    }

    @Override
    public String toString() {
        // using math.max to calculate padding inbetween the task name and date
        // so everything is aligned
        int namePadding = Math.max(0, 20 - name.length());

        return String.format("%s%" + namePadding + "s\t%s\t%s", name, "", dueDate, priorityLevel);
    }
}
