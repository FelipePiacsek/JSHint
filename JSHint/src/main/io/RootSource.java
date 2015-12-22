package main.io;

import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class RootSource {

    private JFileChooser fileChooser;

    public RootSource() {
        fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(DIRECTORIES_ONLY);
    }

    public List<File> getJSFileList() {
        final String path = getPath();
        List<File> listFiles = new ArrayList<File>();
        if (path != "") {
            final File[] files = new File(path).listFiles();
            for (File f : files) {
                if (!f.isDirectory() && f.getName().endsWith(".js")) {
                    listFiles.add(f);
                }
            }
        }
        return listFiles;
    }

    private String getPath() {
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

}
