package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class UserLogin {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label notificationMessage;

    @FXML
    private Label createAccount;

    @FXML
    private Button login;

    @FXML
    private TextField txtUserId;

    @FXML
    private PasswordField txtUserPassword;

    public void btnLoginOnAction(ActionEvent actionEvent) throws  IOException{
            notificationMessage.setText("");
            String userID = txtUserId.getText();
            String password=txtUserPassword.getText();

            if ((userID.length()!=0)&&(password.length()!=0)){
                Parent root= FXMLLoader.load(this.getClass().getResource("/view/mainMenu.fxml"));

                Scene scene=new Scene(root);

                Stage stage= (Stage) this.rootPane.getScene().getWindow();
                stage.setScene(scene);

                stage.setTitle("Main Menu");
                stage.centerOnScreen();
            } else if (userID.length()==0) {
                notificationMessage.setText("Please enter the User Name");
            } else if (password.length()==0) {
                notificationMessage.setText("Please enter the Password");
            } else {
                setNotification();
            }
            txtUserId.setText("");
    }

    public  void setNotification(){
        notificationMessage.setText("Invalid Entry Please check the Credentials and Re-enter");
    }

    public void labelCreateAnAccount(MouseEvent mouseEvent) throws IOException {
        Parent root= FXMLLoader.load(this.getClass().getResource("/view/createUser.fxml"));
        Scene scene=new Scene(root);

        Stage stage= (Stage) this.rootPane.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Create User Account");
        stage.centerOnScreen();

    }
}
