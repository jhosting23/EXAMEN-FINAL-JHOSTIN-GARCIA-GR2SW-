package DataAccess.DTO;

public class gjExobotDTO {
    private int gjIdExobot;
    private int gjIdTipoExobot;
    private int gjIdUsuario;
    private boolean gjEntrenado;
    private int gjNumeroAccion;
    private int gjIdArma;

    public gjExobotDTO() {}

    public gjExobotDTO(int gjIdExobot, int gjIdTipoExobot, int gjIdUsuario, boolean gjEntrenado, int gjNumeroAccion, int gjIdArma) {
        this.gjIdExobot = gjIdExobot;
        this.gjIdTipoExobot = gjIdTipoExobot;
        this.gjIdUsuario = gjIdUsuario;
        this.gjEntrenado = gjEntrenado;
        this.gjNumeroAccion = gjNumeroAccion;
        this.gjIdArma = gjIdArma;
    }

    public int gjGetIdExobot() { return gjIdExobot; }
    public void gjSetIdExobot(int gjIdExobot) { this.gjIdExobot = gjIdExobot; }

    public int gjGetIdTipoExobot() { return gjIdTipoExobot; }
    public void gjSetIdTipoExobot(int gjIdTipoExobot) { this.gjIdTipoExobot = gjIdTipoExobot; }

    public int gjGetIdUsuario() { return gjIdUsuario; }
    public void gjSetIdUsuario(int gjIdUsuario) { this.gjIdUsuario = gjIdUsuario; }

    public boolean gjIsEntrenado() { return gjEntrenado; }
    public void gjSetEntrenado(boolean gjEntrenado) { this.gjEntrenado = gjEntrenado; }

    public int gjGetNumeroAccion() { return gjNumeroAccion; }
    public void gjSetNumeroAccion(int gjNumeroAccion) { this.gjNumeroAccion = gjNumeroAccion; }

    public int gjGetIdArma() { return gjIdArma; }
    public void gjSetIdArma(int gjIdArma) { this.gjIdArma = gjIdArma; }
}
