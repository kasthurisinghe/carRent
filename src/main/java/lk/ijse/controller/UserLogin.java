package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;


public class UserLogin {
    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label createAccount;

    @FXML
    private Button login;

    @FXML
    private TextField txtUserId;

    @FXML
    private PasswordField txtUserPassword;
    public void btnLoginOnAction(ActionEvent actionEvent) {

            String userName = txtUserId.getText();
            System.out.println(userName);

            txtUserId.setText("");

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
