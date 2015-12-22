package tasks;

import static tasks.TaskType.INSERTION;
import java.util.ArrayList;
import java.util.List;

public class GlobalVariableTask implements ITask {

    private List<String> variables;

    public GlobalVariableTask() {
        this.variables = new ArrayList<String>();
    }

    @Override
    public TaskType getType() {
        return INSERTION;
    }

    @Override
    public String getText() {
        StringBuilder sb = new StringBuilder();
        if (!this.variables.isEmpty()) {
            sb.append("/* global ");
            sb.append(this.variables.toString().replace("[", "").replace("]", ""));
            sb.append(" */");
        }
        return sb.toString();
    }

    public void addVariable(final String variable) {
        this.variables.add(variable);
    }

}
