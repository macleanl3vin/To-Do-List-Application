package task;

import java.util.ArrayList;
//import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import java.io.IOException;

public class TextFileSave {

    private void readFile(ToDoList baseList) {
        Scanner reader = new Scanner("TaskFile");
        while(reader.hasNextLine()) {
            String data = reader.nextLine();
            String[] dataTasks = data.split("; ");
            for(int i = 0; i < dataTasks.length; i++) {
                String[] taskElems = dataTasks[i].split(", ");
                String date = taskElems[0];
                String name = taskElems[1];
                String priority = taskElems[2];
                task tempTask = new task(name, date, priority);
                baseList.addTask(tempTask);
            }
            reader.close();
        }
    }
    
    private void writeFile(ArrayList<ArrayList<task>> baseList) {
        //createWriter();
        try {
            FileWriter writer = new FileWriter("TaskFile");
            for(int i = 0; i < 3; i++) {
                ArrayList<task> tasks = baseList.get(i);
                for(int j = 0; j < baseList.get(j).size(); j++) {
                    task currentTask = tasks.get(j);
                    writer.write("" + currentTask.getDueDate() + ", " + currentTask.getName() + ", " + currentTask.getPriorityLevel() + "; ");
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("A Save File Write Error Has Occured");
            e.printStackTrace();
        }
    }

}