package ConsoleApp;

import java.util.Scanner;
import DataAccess.DAO.gjUsuarioDAO;
import DataAccess.DTO.gjUsuarioDTO;
import Infrastructure.gjAppMSG;
import Infrastructure.gjCMD;

public class gjLogin {

    public boolean gjAutenticar() {
        Scanner gjScanner = new Scanner(System.in);
        int gjIntentos = 0;
        final int gjMAX_INTENTOS = 3;

        while (gjIntentos < gjMAX_INTENTOS) {
            System.out.print("Ingrese Cedula o en dado caso su Username: ");
            String gjUser = gjScanner.nextLine();

            System.out.print("Ingrese Clave: ");
            String gjPass = gjScanner.nextLine();

            gjUsuarioDAO gjDao = new gjUsuarioDAO();
            gjUsuarioDTO gjDto = gjDao.gjLogin(gjUser, gjPass);

            if (gjDto != null) {
                gjCMD.gjImprimir(gjAppMSG.gjMSG_LOGIN_EXITO);
                return true;
            } else {
                gjCMD.gjImprimir(gjAppMSG.gjMSG_LOGIN_FALLO);
                gjIntentos++;
                System.out.println("Intentos restantes: " + (gjMAX_INTENTOS - gjIntentos));
            }
        }
        return false;
    }
}
