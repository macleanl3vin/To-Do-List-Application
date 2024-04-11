package task;

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
        return priorityLevel.toLowerCase().trim(); // Ensure lowercase and trimmed
    }

    public void setPriorityLevel(String priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    @Override
    public String toString() {
        // using math.max to calculate padding inbetween the task name and date
        // so everything is aligned
        int namePadding = Math.max(0, 20 - name.length());

        return String.format("%s%" + namePadding + "s\t%s\t%s", name, "", dueDate, priorityLevel);
    }
}
