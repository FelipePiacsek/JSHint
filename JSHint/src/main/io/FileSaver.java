package main.io;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileSaver {

    public void saveFile(File oldFile, String newContent) throws IOException {
        Path newFile = Paths.get(oldFile.getPath());
        String lines[] = newContent.split("\\r?\\n");
        Files.write(newFile, Arrays.asList(lines), Charset.forName("UTF-8"));
    }
}
