package DataAccess;

import Infrastructure.gjAppConfig;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class gjDataFileHelper {
    private static final String gjFILE_PATH = gjAppConfig.gjPATH_MUNISION;

    public static String gjBuscarMunicion(String gjArmaNombre) {
    
        try (BufferedReader gjBr = new BufferedReader(new FileReader(gjFILE_PATH))) {
            String gjLine;
            while ((gjLine = gjBr.readLine()) != null) {
            
                String[] gjParts = gjArmaNombre.split("/");
                for (String gjPart : gjParts) {
                    if (gjLine.contains(gjPart.trim())) {
                        return gjLine.trim(); 
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
