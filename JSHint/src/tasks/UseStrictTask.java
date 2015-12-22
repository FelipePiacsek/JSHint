package tasks;

import static tasks.TaskType.INSERTION;

public class UseStrictTask implements ITask {

    @Override
    public TaskType getType() {
        return INSERTION;
    }

    @Override
    public String getText() {
        return "'use strict';";
    }
}
