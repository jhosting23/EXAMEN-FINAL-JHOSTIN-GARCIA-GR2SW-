package BusinessLogic.Entities;

public class gjExoComando extends gjExobot {
    public gjExoComando() {
        super("ExoComando");
        this.gjArmaNombre = "Laser/Bayoneta";
    }

    @Override
    public String gjRealizarAccion() {
        return "Disparar (Munición)";
    }
}
