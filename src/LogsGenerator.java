import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class LogsGenerator {

    private static final SimpleDateFormat time = new SimpleDateFormat("yyyy.MM.dd, HH:mm:ss");

    public void doLogs(String pathToFile, String component, String message) {
        try {
            String inputLine = "";
            BufferedReader inFile = new BufferedReader(new FileReader(pathToFile));
            FileOutputStream outputFile = new FileOutputStream(pathToFile, true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            if (component.length() < 15) {
                inputLine += "[" + time.format(timestamp) + "]" + "[" + component.toUpperCase() + "]:\t\t" + message + "\n";
            } else {
                inputLine += "[" + time.format(timestamp) + "]" + "[" + component.toUpperCase() + "]:\t" + message + "\n";
            }

            outputFile.write(inputLine.getBytes());
            inFile.close();
            outputFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public void createLogs(String component, String message) {
        String pathToFile = "C:\\pathtofile\\Logs";
        File file = new File(pathToFile);
        if (file.exists() && !file.isDirectory()) {
            System.out.print("Logs are already exist. ");
            doLogs(pathToFile, component, message);
        } else {
            try {
                System.out.print("Creating new logs. ");
                file.createNewFile();
                doLogs(pathToFile, component, message);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can not create autoDiagnoseLogs");
            }
        }
    }
}