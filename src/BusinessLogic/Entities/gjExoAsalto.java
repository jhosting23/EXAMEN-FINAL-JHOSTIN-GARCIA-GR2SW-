package BusinessLogic.Entities;

public class gjExoAsalto extends gjExobot {
    public gjExoAsalto() {
        super("ExoAsalto");
        this.gjArmaNombre = "Fusil/Revolver";
    }

    @Override
    public String gjRealizarAccion() {
        return "Disparar (Munición)";
    }
}
