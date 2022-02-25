package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

/**
 *
 * @author Moutaz
 */
public class PlayerInvitationController implements Initializable {
    @FXML
    private Button BackButton, InvitePlayerButton,recordedGamesButton;
    
    @FXML
    private TableView tableView;
    
    
    private TableColumn<Player,String> OnlinePlayers;
    
    private TableColumn<Player,Integer> Score;
    
    private ObservableList<Player> PlayersList;
    
    
    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException{
            MainScreen.session.viewOnlinePlayers = false;
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/mainMenu.fxml"));
            Parent fxmlViewChild = loader.load();

            Scene fxmlViewScene = new Scene(fxmlViewChild);

            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(fxmlViewScene);

            window.show();
            
    }
    
    @FXML
    private void inviteButtonAction(ActionEvent event) throws IOException{
        Player player = (Player)tableView.getSelectionModel().getSelectedItem();
        if(player!=null){
            MainScreen.session.invitationSendRequest(player.getID());
            //disableInvitation();
        }
    }
    
    
    @FXML
    private void acceptInvitaionButtonAction(ActionEvent event) throws IOException{
        MainScreen.session.viewOnlinePlayers = false;
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/playerVsPlayer.fxml"));
        Parent fxmlViewChild = loader.load();

        Scene fxmlViewScene = new Scene(fxmlViewChild);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);

        window.show();
            
    }
    
    @FXML
    private void recordedGamesButtonAction(ActionEvent event) throws IOException{
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/recordedGames.fxml"));
        Parent fxmlViewChild = loader.load();

        Scene fxmlViewScene = new Scene(fxmlViewChild);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(fxmlViewScene);

        window.show();
            
    }
    
    @FXML
    public void insertOnlinePlayers(ObservableList<Player> list){
        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                tableView.setItems(list);
            }
        });
    }
    
    @FXML
    public void disableInvitation(){
        InvitePlayerButton.setDisable(true);
    }
    
    @FXML
    public void enableInvitation(){
        InvitePlayerButton.setDisable(false);
    }
    
    
    @FXML
    private void inviteOnHover(MouseEvent event){
        InvitePlayerButton.setPrefWidth(208);
        InvitePlayerButton.setPrefHeight(49);
        audio("btnHover.mp3");
    }
    
    @FXML
    private void inviteOnExit(MouseEvent event){
        InvitePlayerButton.setPrefWidth(188);
        InvitePlayerButton.setPrefHeight(39);
    }
    
    @FXML
    private void inviteOnPress(MouseEvent event){
        //aboutButton
        InvitePlayerButton.setPrefWidth(168);
        InvitePlayerButton.setPrefHeight(29);
        InvitePlayerButton.setLayoutX(266);
        InvitePlayerButton.setLayoutY(316);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void inviteOnRelease(MouseEvent event){
        //aboutButton
        InvitePlayerButton.setPrefWidth(188);
        InvitePlayerButton.setPrefHeight(39);
        InvitePlayerButton.setLayoutX(266);
        InvitePlayerButton.setLayoutY(316);
    }
    
    
    @FXML
    private void backOnHover(MouseEvent event){
        audio("btnHover.mp3");
    }
    
    @FXML
    private void backOnPress(MouseEvent event){
        BackButton.setPrefWidth(52);
        BackButton.setPrefHeight(15); 
        audio("btnClick.mp3");
    }
    
    @FXML
    private void backOnRelease(MouseEvent event){
        BackButton.setPrefWidth(72);
        BackButton.setPrefHeight(25); 
    }
    
       @FXML
    private void recordOnHover(MouseEvent event){
           audio("btnHover.mp3");
    }
    
    @FXML
    private void recordOnPress(MouseEvent event){
        recordedGamesButton.setPrefWidth(112);
        recordedGamesButton.setPrefHeight(22);
        audio("btnClick.mp3");
    }
    
    @FXML
    private void recordOnRelease(MouseEvent event){
        recordedGamesButton.setPrefWidth(122);
        recordedGamesButton.setPrefHeight(29);
    }
    
    
     private void audio(String soundEffect){
        Media sound = new Media(getClass().getResource("/audio/"+soundEffect).toExternalForm());
        MediaPlayer mediaPlayer = new MediaPlayer(sound);
        mediaPlayer.play();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        OnlinePlayers = (TableColumn<Player,String>)tableView.getColumns().get(0);
        Score = (TableColumn<Player,Integer>)tableView.getColumns().get(1);
        OnlinePlayers.setCellValueFactory(new PropertyValueFactory<Player,String>("username"));
        Score.setCellValueFactory(new PropertyValueFactory<Player,Integer>("score"));
        PlayersList = FXCollections.observableArrayList();
        tableView.setItems(PlayersList);

    }
    

}
