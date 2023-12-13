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
import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserLoginDto;
import lk.ijse.modle.UserLoginModle;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    public void btnLoginOnAction(ActionEvent actionEvent) throws IOException, SQLException, NoSuchAlgorithmException {
            notificationMessage.setText("");
            String userID = txtUserId.getText();
            String password=txtUserPassword.getText();

            if (checkUser(password,userID)){
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
            txtUserPassword.setText("");
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
    private boolean checkUser(String password, String userId) throws SQLException, NoSuchAlgorithmException {
        String pw1=doHashing(password);

        UserLoginDto userLoginDto=new UserLoginDto(userId,pw1);

        boolean isThere=UserLoginModle.findUser(userLoginDto);
        if (isThere){
            return true;
        }
        else {
            return false;
        }
    }

    private static String doHashing(String password) throws NoSuchAlgorithmException {
        String hashValue;

//            Initialize the MessageDigest object for MD5 hashing.
        MessageDigest md = MessageDigest.getInstance("MD5");

//            Input the data you want to hash into a byte array.
        String originalString = password;
        byte[] bytesOfMessage = originalString.getBytes();

//            Use the digest method to perform the hashing.
        byte[] digest = md.digest(bytesOfMessage);

//            Finally, convert the byte array to a hexadecimal String.
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        hashValue = sb.toString();

        return hashValue;
    }
}
