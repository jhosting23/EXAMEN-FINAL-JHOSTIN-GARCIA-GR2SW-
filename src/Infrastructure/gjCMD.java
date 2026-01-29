package Infrastructure;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class gjCMD {
    private static final String gjTRACER_FILE = gjAppConfig.gjPATH_TRACER;

    // ANSI Color Codes
    private static final String gjANSI_RESET = "\u001B[0m";
    private static final String gjANSI_RED = "\u001B[31m";
    private static final String gjANSI_BLUE = "\u001B[34m";

    public static void gjImprimir(String gjMensaje) {
        if (gjMensaje.contains("GOOD")) {
            System.out.println(gjANSI_BLUE + gjMensaje + gjANSI_RESET);
        } else if (gjMensaje.contains("ERROR")) {
            System.out.println(gjANSI_RED + gjMensaje + gjANSI_RESET);
        } else {
            System.out.println(gjMensaje);
        }

        gjGuardarEnArchivo(gjMensaje);
    }

    private static void gjGuardarEnArchivo(String gjMensaje) {
        try (FileWriter gjFw = new FileWriter(gjTRACER_FILE, true);
                PrintWriter gjPw = new PrintWriter(gjFw)) {

            gjPw.println(gjMensaje);
        } catch (IOException e) {
            System.err.println("Error writing to ExoTracer.txt: " + e.getMessage());
        }
    }
}
