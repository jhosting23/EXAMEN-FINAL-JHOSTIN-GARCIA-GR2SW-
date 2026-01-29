package BusinessLogic.Entities;

import BusinessLogic.gjIAEXO;

public abstract class gjExobot extends gjIAEXO {
    protected int gjIdExobot;
    protected String gjTipoExobot;
    protected boolean gjEntrenado;
    protected int gjNumeroAccion;
    protected String gjArmaNombre;

    public gjExobot(String gjTipoExobot) {
        this.gjTipoExobot = gjTipoExobot;
        this.gjNumeroAccion = 0;
        this.gjEntrenado = false;
    }

    public abstract String gjRealizarAccion();

    public int gjGetIdExobot() {
        return gjIdExobot;
    }

    public void gjSetIdExobot(int id) {
        this.gjIdExobot = id;
    }

    public String gjGetTipoExobot() {
        return gjTipoExobot;
    }

    public boolean gjIsEntrenado() {
        return gjEntrenado;
    }

    public void gjSetEntrenado(boolean entrenado) {
        this.gjEntrenado = entrenado;
    }

    public int gjGetNumeroAccion() {
        return gjNumeroAccion;
    }

    public void gjIncrementarAccion() {
        this.gjNumeroAccion++;
    }

    public String gjGetArmaNombre() {
        return gjArmaNombre;
    }

    public void gjSetArmaNombre(String arma) {
        this.gjArmaNombre = arma;
    }
}
