package tasks.verifier;

import java.util.ArrayList;
import java.util.List;
import tasks.ITask;

public class TasksVerifier {

    private InsertionTasksVerifier insertions;

    private ReplacementTasksVerifier replacements;

    public TasksVerifier() {
        this.insertions = new InsertionTasksVerifier();
        this.replacements = new ReplacementTasksVerifier();
    }

    public List<ITask> getTasks(String fileContent) {
        List<ITask> tasks = new ArrayList<ITask>();
        tasks.addAll(insertions.getInsertionTasks(fileContent));
        tasks.addAll(replacements.getReplacementTasks(fileContent));
        return tasks;
    }
}
