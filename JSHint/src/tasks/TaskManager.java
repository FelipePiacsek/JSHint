package tasks;

import java.util.List;

public class TaskManager {

    public String execute(String oldFileContent, List<ITask> tasks) {
        StringBuilder newFileContent = new StringBuilder();
        for (ITask task : tasks) {
            newFileContent.append(task.getText());
            newFileContent.append("\n");
        }
        newFileContent.append(oldFileContent);
        return newFileContent.toString();
    }
}
