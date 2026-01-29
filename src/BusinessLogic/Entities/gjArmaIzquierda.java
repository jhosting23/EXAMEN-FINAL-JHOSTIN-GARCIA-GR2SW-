package BusinessLogic.Entities;

public abstract class gjArmaIzquierda {
    protected String gjTipo;

    public gjArmaIzquierda(String gjTipo) {
        this.gjTipo = gjTipo;
    }

    public String gjGetTipo() {
        return gjTipo;
    }

    public abstract void gjRealizarAccion();
}
