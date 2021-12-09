import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class SingleFile {
    final String currentDirectory = System.getProperty("user.dir");
    private File logFile;
    public FileWriter myWriter;

    public SingleFile(String content) throws IOException {
        logFile = new File(currentDirectory + "\\" + "logFile.txt");
        myWriter = new FileWriter(logFile, true);
        if (!logFile.exists()) {
            logFile.createNewFile();
        }
        myWriter.write(content);
        myWriter.write(System.getProperty("line.separator"));
        myWriter.close();
    }
    public SingleFile getInstance(){
        return this;

    }


}