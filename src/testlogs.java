/*
import java.io.*;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class testlogs {

    private static final SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss - dd.MM.yyyy");
    public static HashMap<String, String> logComponent;
    public static int index = 1;

    public HashMap<String, String> doLogComponentPack() {
        HashMap<String, String> logComponent = new HashMap<>();
        logComponent.put("TerminalAnalyse", "");
        logComponent.put("FileAnalyse", "");
        logComponent.put("LogsAnalyse", "");
        logComponent.put("ZScalerAnalyse", "");
        logComponent.put("VersionAnalyse", "");
        logComponent.put("EPSIConfAnalyse", "");
        return logComponent;
    }

    public void prepareLogs(String pathToFile, String component, String message) {
        HashMap<String, String> newlogComponent = doLogComponentPack();
        Set<Map.Entry<String, String>> entries = newlogComponent.entrySet();
        Iterator<Map.Entry<String, String>> logsIterator = entries.iterator();

        try {
            AtomicReference<String> inputLine = new AtomicReference<>("");
            BufferedReader inFile = new BufferedReader(new FileReader(pathToFile));
            FileOutputStream outputFile = new FileOutputStream(pathToFile, true);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());

            while (logsIterator.hasNext()) {
                Map.Entry<String, String> entry = logsIterator.next();
                if(component.equals(entry.getKey())) {
                    if(component.length() < 14) {
                        newlogComponent.put(component, "[" + time.format(timestamp) + " - " + component.toUpperCase() + "]:\t\t" + message + "\n");
                    } else {
                        newlogComponent.put(component, "[" + time.format(timestamp) + " - " + component.toUpperCase() + "]:\t" + message + "\n");
                    }
                }
            }

            logComponent = newlogComponent;
            logComponent.forEach((k, v) -> {
                inputLine.set(v);
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

    public void createLogs(String component, String message) {
        String pathToFile = "C:\\Users\\fzegle23\\Desktop\\AutoDiagnoza 0.4.3\\AutoDiagnose\\autoDiagnoseLogs";
        File file = new File(pathToFile);
        if (file.exists() && !file.isDirectory()) {
            System.out.print("Logs are already exist. ");
            prepareLogs(pathToFile, component, message);
        } else {
            try {
                System.out.print("Creating new logs. ");
                file.createNewFile();
                prepareLogs(pathToFile, component, message);
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Can not create autoDiagnoseLogs");
            }
        }
    }
}*/
