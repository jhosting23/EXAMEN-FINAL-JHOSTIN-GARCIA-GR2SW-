package BusinessLogic.Entities;

public class gjExoInfanteria extends gjExobot {
    public gjExoInfanteria() {
        super("ExoInfanteria");
        this.gjArmaNombre = "Misil/Mortero";
    }

    @Override
    public String gjRealizarAccion() {
        return "Disparar (Munición)";
    }
}
