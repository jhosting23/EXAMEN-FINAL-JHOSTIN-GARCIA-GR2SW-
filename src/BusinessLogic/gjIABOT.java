package BusinessLogic;

import BusinessLogic.Entities.gjExobot;
import BusinessLogic.Entities.gjSoldadoExperto;

public class gjIABOT {

    public void gjEntrenar(gjExobot gjExobot, gjSoldadoExperto gjSoldado) {
        if (gjExobot != null) {
            gjExobot.gjSetEntrenado(true);
        }
    }
}
