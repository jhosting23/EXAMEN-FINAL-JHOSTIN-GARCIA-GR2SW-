package DataAccess.DTO;

public class gjUsuarioDTO {
    private int gjIdUsuario;
    private String gjNombre;
    private String gjUsername;
    private String gjPassword;

    public gjUsuarioDTO() {}

    public gjUsuarioDTO(int gjIdUsuario, String gjNombre, String gjUsername, String gjPassword) {
        this.gjIdUsuario = gjIdUsuario;
        this.gjNombre = gjNombre;
        this.gjUsername = gjUsername;
        this.gjPassword = gjPassword;
    }

    public int gjGetIdUsuario() {
        return gjIdUsuario;
    }

    public void gjSetIdUsuario(int gjIdUsuario) {
        this.gjIdUsuario = gjIdUsuario;
    }

    public String gjGetNombre() {
        return gjNombre;
    }

    public void gjSetNombre(String gjNombre) {
        this.gjNombre = gjNombre;
    }

    public String gjGetUsername() {
        return gjUsername;
    }

    public void gjSetUsername(String gjUsername) {
        this.gjUsername = gjUsername;
    }

    public String gjGetPassword() {
        return gjPassword;
    }

    public void gjSetPassword(String gjPassword) {
        this.gjPassword = gjPassword;
    }
}
