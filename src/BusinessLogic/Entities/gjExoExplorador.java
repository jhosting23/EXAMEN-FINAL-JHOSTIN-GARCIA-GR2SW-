package BusinessLogic.Entities;

public class gjExoExplorador extends gjExobot {
    public gjExoExplorador() {
        super("ExoExplorador");
        this.gjArmaNombre = "GPS/Giroscopio";
    }

    @Override
    public String gjRealizarAccion() {
        return "Detectar (Energía)";
    }
}
