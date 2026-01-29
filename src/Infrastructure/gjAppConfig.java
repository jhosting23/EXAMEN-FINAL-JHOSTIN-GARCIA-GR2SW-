package Infrastructure;

public class gjAppConfig {
    public static final String gjDB_URL;
    public static final String gjDRIVER;
    public static final String gjPATH_MUNISION;
    public static final String gjPATH_TRACER;

    static {
        java.util.Properties gjProps = new java.util.Properties();
        try (java.io.FileInputStream gjFis = new java.io.FileInputStream("app.properties")) {
            gjProps.load(gjFis);
        } catch (java.io.IOException e) {
            // System.err.println("Error loading app.properties: " + e.getMessage());
        }
        gjDB_URL = gjProps.getProperty("gjDB_URL", "jdbc:sqlite:database\\gjExoTrooper.sqlite");
        gjDRIVER = gjProps.getProperty("gjDRIVER", "org.sqlite.JDBC");

        String munPath = gjProps.getProperty("gjPATH_MUNISION", "src/Storage/DataFiles/ExoMunision.txt");
        if (!new java.io.File(munPath).exists() && new java.io.File("Storage/DataFiles/ExoMunision.txt").exists()) {
            munPath = "Storage/DataFiles/ExoMunision.txt";
        }
        gjPATH_MUNISION = munPath;

        String tracerPath = gjProps.getProperty("gjPATH_TRACER", "src/Storage/DataFiles/ExoTracer.txt");
        if (!new java.io.File(tracerPath).exists() && new java.io.File("Storage/DataFiles/ExoTracer.txt").exists()) {
            tracerPath = "Storage/DataFiles/ExoTracer.txt";
        }
        gjPATH_TRACER = tracerPath;
    }
}
