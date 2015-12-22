package tasks.verifier;

import java.util.ArrayList;
import java.util.List;
import tasks.GlobalVariableTask;
import tasks.ITask;
import tasks.UseStrictTask;

public class InsertionTasksVerifier {

    public List<ITask> getInsertionTasks(String fileContent) {
        return findTasks(fileContent);
    }

    private List<ITask> findTasks(String fileContent) {
        List<ITask> tasks = new ArrayList<ITask>();

        ITask global = verifyGlobal(fileContent);
        ITask useStrict = verifyUseStrict(fileContent);

        if (useStrict != null) {
            tasks.add(useStrict);
        }

        if (global != null) {
            tasks.add(global);
        }

        return tasks;
    }

    private ITask verifyUseStrict(String fileContent) {
        UseStrictTask task = null;
        if (!fileContent.contains("'use strict';")) {
            task = new UseStrictTask();
        }
        return task;
    }

    private ITask verifyGlobal(String fileContent) {
        GlobalVariableTask task = null;
        if (!fileContent.contains("/* global")) {
            task = new GlobalVariableTask();
            if (fileContent.contains("React.")) {
                task.addVariable("React");
            }

            if (fileContent.contains("moment.")) {
                task.addVariable("moment");
            }

            if (fileContent.contains("_.")) {
                task.addVariable("_");
            }

            String lookUp = null;
            if (fileContent.contains("render:")) {
                lookUp = "render:";
            } else if (fileContent.contains("render :")) {
                lookUp = "render :";
            }
            if (lookUp != null) {
                String reactComponentName = fileContent.substring(fileContent.indexOf(lookUp) + lookUp.length(), fileContent.lastIndexOf("})")).trim();

                if (!reactComponentName.contains("function(")) {
                    task.addVariable(reactComponentName);
                }

                if (reactComponentName.contains("function(") && reactComponentName.contains(".apply")) {
                    reactComponentName = reactComponentName.substring(reactComponentName.lastIndexOf("return ") + 7, reactComponentName.indexOf(".apply")).trim();
                    task.addVariable(reactComponentName);
                }
            }
        }
        return task;
    }
}
