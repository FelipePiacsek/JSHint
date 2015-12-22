package tasks.verifier;

import java.util.ArrayList;
import java.util.List;
import tasks.ITask;
import tasks.ReplacementsTask;

public class ReplacementTasksVerifier {

    public List<ITask> getReplacementTasks(String fileContent) {
        return findTasks(fileContent);
    }

    private List<ITask> findTasks(String fileContent) {
        List<ITask> tasks = new ArrayList<ITask>();
        ReplacementsTask task = new ReplacementsTask();

        // task.addReplacements("===", "==");
        task.addReplacements(" == ", " === ");

        // task.addReplacements("!==", "!=");
        task.addReplacements(" != ", " !== ");

        // task.addReplacements("\"", "'");

        tasks.add(task);

        return tasks;
    }

}
