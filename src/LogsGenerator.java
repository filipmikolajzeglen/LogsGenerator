import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;

public class LogsGenerator {

    private static final SimpleDateFormat time = new SimpleDateFormat("yyyy.MM.dd, HH:mm:ss");
    private static HashMap<String, String> cacheLogs = new HashMap<>();

    public static void doLogs(String pathToFile) {
        try {
            AtomicReference<String> inputLine = new AtomicReference<>("");
            BufferedReader inFile = new BufferedReader(new FileReader(pathToFile));
            FileOutputStream outputFile = new FileOutputStream(pathToFile);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            cacheLogs.forEach((component, message) -> {
                if (!component.equals("LogsAnalyse")) {
                    if (component.length() < 15) {
                        inputLine.set(inputLine + "[" + time.format(timestamp) + "]" + "[" + component.toUpperCase() + "]:\t\t" + message + "\n");
                    } else {
                        inputLine.set(inputLine + "[" + time.format(timestamp) + "]" + "[" + component.toUpperCase() + "]:\t" + message + "\n");
                    }
                } else {
                    inputLine.set(inputLine + "[" + time.format(timestamp) + "]" + "[" + component.toUpperCase() + "]:\n" + message + "\n");
                }
            });

            outputFile.write(inputLine.get().getBytes());
            inFile.close();
            outputFile.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void createLogs(String component, String message) {
        cacheLogs.put(component, message);
        String pathToFile = "C:\\pathTo\\Logs";
        File file = new File(pathToFile);
        if (file.exists() && !file.isDirectory()) {
            System.out.print("Logs are already exist. ");
            doLogs(pathToFile);
        } else {
            try {
                System.out.print("Creating new logs. ");
                file.createNewFile();
                doLogs(pathToFile);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can not create autoDiagnoseLogs");
            }
        }
    }
}