package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import main.io.FileSaver;
import main.io.RootSource;
import tasks.ITask;
import tasks.InsertTasksVerifier;
import tasks.TaskManager;

public class Aplicacao {

    private static RootSource rootSource = new RootSource();

    private static InsertTasksVerifier taskVerifier = new InsertTasksVerifier();

    private static TaskManager taskManager = new TaskManager();

    private static FileSaver fileSaver = new FileSaver();

    public static void main(String[] args) throws IOException {
        List<File> files = rootSource.getJSFileList();
        for (File file : files) {
            String fileContent = new String(Files.readAllBytes(Paths.get(file.getPath())));
            List<ITask> tasks = taskVerifier.getInsertionTasks(fileContent);
            String newContent = taskManager.execute(fileContent, tasks);
            fileSaver.saveFile(file, newContent);
        }
    }

}
