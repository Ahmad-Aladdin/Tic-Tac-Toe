package controller;

import ticTac.Connection.Session;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Moutaz
 */
public class MainScreen extends Application {
    
    private Parent root;
    private Scene scene;
    public static Session session;
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setResizable(false);
        stage.setTitle("Tic Tac Toe");
        session = new Session(stage);
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/login.fxml"));
        Parent fxmlViewChild = loader.load();
        session.controlManager.setLoginController(loader);
        
        scene = new Scene(fxmlViewChild, 690, 390);
        stage.setScene(scene);
        
        Image icon = new Image("/images/icon.png");
	    stage.getIcons().add(icon);
        
        
        stage.show();
    }
    
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    void changeScene(String mainMenufxml) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void stop(){
        try {
            super.stop();
            session.CloseConnection();
        } catch (Exception ex) {
            Logger.getLogger(MainScreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}