package ticTac;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Moutaz
 */
public class LoginController implements Initializable {
    
    private TextField username;
    private TextField password;
    private Hyperlink signUpHyperlink;
    private Button loginButton;
    private Label usernameValid;
    private Label passwordValid;
    
    @FXML
    private void loginButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        
    }
    
    /* When this method is called, it will change the scene
       to sign up screen */
    public void changeToSignUpScreen(ActionEvent event) throws IOException{
        
        MainScreen mainScreen = new MainScreen();
        mainScreen.changeScene("signUp.fxml");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
    
    
    
}
