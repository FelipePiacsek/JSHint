package tasks;

import java.util.List;
import java.util.Map;

public class TaskManager {

    public String execute(String oldFileContent, List<ITask> tasks) {
        StringBuilder newFileContent = new StringBuilder();
        for (ITask task : tasks) {
            switch (task.getType()) {
                case INSERTION:
                    newFileContent.append(task.getText());
                    newFileContent.append("\n");
                    break;
                case REMOVAL:
                    break;
                case REPLACE:
                    Map<String, String> replacements = ((ReplacementsTask) task).getReplacements();
                    for (String key : replacements.keySet()) {
                        oldFileContent = oldFileContent.replaceAll(key, replacements.get(key));
                    }
                    break;
                default:
                    break;

            }
        }
        newFileContent.append(oldFileContent);
        return newFileContent.toString();
    }
}
