package BusinessLogic.Entities;

public class gjExoMedico extends gjExobot {
    public gjExoMedico() {
        super("ExoMedico");
        this.gjArmaNombre = "BioSensor/BioEscaner";
    }

    @Override
    public String gjRealizarAccion() {
        return "Asistir (Energía)";
    }
}
