package main.io;

import static java.util.Collections.unmodifiableList;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RootSource {

    private JFileChooser fileChooser;

    private List<File> listFiles;

    public RootSource() {
        this.fileChooser = new JFileChooser();
        this.fileChooser.setFileSelectionMode(DIRECTORIES_ONLY);
        this.listFiles = new ArrayList<File>();
    }

    private String selectBasePath() {
        int returnVal = fileChooser.showOpenDialog(null);
        while (returnVal != JFileChooser.APPROVE_OPTION && returnVal != JFileChooser.CANCEL_OPTION) {
            JOptionPane.showMessageDialog(null, "Selecione um diretório válido.");
            returnVal = fileChooser.showOpenDialog(null);
        }
        String path = "";
        if (returnVal != JFileChooser.CANCEL_OPTION) {
            path = fileChooser.getSelectedFile().getPath();
        }
        return path;
    }

    private void getFilesFromPath(String path) {
        final File[] files = new File(path).listFiles();
        for (File f : files) {
            if (f.isDirectory()) {
                getFilesFromPath(f.getPath());
            } else if (f.getName().endsWith(".js")) {
                listFiles.add(f);
            }
        }
    }

    public List<File> getJSFileList() {
        String basePath = selectBasePath();
        if (basePath != "" && basePath != null) {
            getFilesFromPath(basePath);
        }
        return unmodifiableList(this.listFiles);
    }

}
