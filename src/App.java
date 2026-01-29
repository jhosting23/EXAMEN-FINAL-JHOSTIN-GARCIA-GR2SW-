import ConsoleApp.gjLogin;
import UserInterface.gjExoTrooperForm;
import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        gjLogin gjLoginService = new gjLogin();

        if (gjLoginService.gjAutenticar()) {

            SwingUtilities.invokeLater(() -> {
                gjExoTrooperForm gjForm = new gjExoTrooperForm();
                gjForm.setVisible(true);
            });
        } else {
            System.exit(0);
        }
    }
}
