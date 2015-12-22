package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import main.io.FileSaver;
import main.io.RootSource;
import tasks.ITask;
import tasks.TaskManager;
import tasks.verifier.TasksVerifier;

public class Aplicacao {

    private static RootSource rootSource = new RootSource();

    private static TasksVerifier taskVerifier = new TasksVerifier();

    private static TaskManager taskManager = new TaskManager();

    private static FileSaver fileSaver = new FileSaver();

    public static void main(String[] args) throws IOException {
        List<File> files = rootSource.getJSFileList();
        for (File file : files) {
            System.out.println(file.getName());
            String fileContent = new String(Files.readAllBytes(Paths.get(file.getPath())));
            List<ITask> tasks = taskVerifier.getTasks(fileContent);
            String newContent = taskManager.execute(fileContent, tasks);
            fileSaver.saveFile(file, newContent);
        }
    }

}
