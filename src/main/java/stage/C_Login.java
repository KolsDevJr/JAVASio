package stage;

import dao.UserDAO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


import java.io.IOException;

public class C_Login {

    public C_Login(){

    }

    @FXML
    private Button button;
    @FXML
    private Label wrongLogin;
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;

    public void userLogin(ActionEvent event) throws IOException{
        checkLogin();
    }

    private void checkLogin() throws IOException{
        MainApp m = new MainApp();
        String logger=username.getText().toString();
        User log= UserDAO.getInstance().readUser(logger);
        String MotDePasse =log.getMdp();
        if (log != null){
            System.out.println("Exist");
            System.out.println(MotDePasse);
        }else{
            System.out.println("Exist Pas !");
        }
        if( password.getText().toString().equals(MotDePasse)){
            wrongLogin.setText("Bravo!");
            m.nextScene("profil-view.fxml");
        }
        else if(username.getText().isEmpty() || password.getText().isEmpty()){
            wrongLogin.setText("Veuillez entrer des données");
        }

        else {
            wrongLogin.setText("Mauvais Login ou mot de passe!");
        }
    }

}