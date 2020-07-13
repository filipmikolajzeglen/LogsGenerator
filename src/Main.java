public class Main {
    public static void main(String[] args) {
        LogsGenerator logs = new LogsGenerator();
        logs.createLogs("TerminalAnalyse", "Błąd połączenia z terminalem");
        logs.createLogs("LogsAnalyse", "Błąd w logach");
        logs.createLogs("ZScalerAnalyse", "Błąd połączenia z zscaler");
        logs.createLogs("FileAnalyse", "Błąd plików na kasie");
        logs.createLogs("EPSIConfAnalyse", "Błąd konfiguracji epsi");
    }
}
