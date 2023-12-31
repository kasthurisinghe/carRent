package lk.ijse.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.dto.CreateUserDto;
import lk.ijse.modle.CreateUserModel;

import java.io.IOException;
import java.sql.SQLException;


public class CreateUser {
    public Button deleteUserbtn;
    public AnchorPane rootNode2;
    public Button backBtn;
    public TextField phoneNumber;
    public TextField UserId;
    public TextField address;
    public TextField userName;
    public PasswordField rePassword;
    public PasswordField password;
    public RadioButton male;
    public RadioButton female;
    public Label msg;
    public Button createUserBtn;
    public Button updateUserbtn;


    public void btnBackClickonAction(ActionEvent mouseEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/view/userLogin.fxml"));
        Scene scene= new Scene(root);

        Stage stage= (Stage) this.rootNode2.getScene().getWindow();
        stage.setScene(scene);

        stage.setTitle("Main Menu");
        stage.centerOnScreen();
    }

    public void btnCreateUserClockOnAction(ActionEvent actionEvent) throws SQLException, NoSuchAlgorithmException {
        String mobile=phoneNumber.getText();
        String id=UserId.getText();
        String addr=address.getText();
        String userna=userName.getText();
        String oriPassword=password.getText();
        String md5Pass=doHashing(oriPassword);
        String password2=rePassword.getText();
        String gender;

        if(male.isSelected()){
             gender=male.getText();
        }
        else {
            gender=female.getText();
        }

        if(password2.equals(oriPassword)&&(male.isSelected()|| female.isSelected())){
            if (mobile.length()==10 && (Integer.parseInt(mobile)>0)){

                CreateUserDto createUserDto =new CreateUserDto(id,userna,addr,mobile,md5Pass,gender);

                try {

                    boolean isSaved= CreateUserModel.save(createUserDto);

                    if (isSaved){
                        new Alert(Alert.AlertType.CONFIRMATION, "The user is saved").show();
                        clearFields();
                        msg.setText("");
                    }

                } catch (SQLException e) {
                    new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
                }

            }
            else {
                msg.setText("The mobile number that you entered is incorrect, please check the number and re enter the details.");
            }
        }
        else {
            if (!password2.equals(oriPassword)) {
                msg.setText("The passwords you entered do not match. Please re-enter your password correctly.");
            }
            else {
                msg.setText("Select your gender.");
            }
        }
    }
    public void txtClickOnId(ActionEvent actionEvent) throws SQLException, NoSuchAlgorithmException {
        String id=UserId.getText();
        CreateUserDto createUserDto = CreateUserModel.findUser(id);

        if (createUserDto !=null ){
            userName.setText(createUserDto.getUserna());
            UserId.setText(createUserDto.getId());
            address.setText(createUserDto.getAddr());
            phoneNumber.setText(createUserDto.getMobile());

            msg.setText("Passwords cannot be exposed.");

            if (createUserDto.getGender().equals("Male")){
                male.setSelected(true);
            }else {
                female.setSelected(true);
            }
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"The user ID "+id+" doesnt exist").show();
        }
    }
    public void btnDeleteClickOnAction(ActionEvent actionEvent) throws SQLException {
        String id =UserId.getText();
        boolean isDeleted= CreateUserModel.deleteUser(id);

        if (isDeleted){
            new Alert(Alert.AlertType.CONFIRMATION,"User deleted").show();
        }
        else {
            new Alert(Alert.AlertType.INFORMATION,"No registered users currently exist.").show();
        }
        clearFields();
    }
    private void clearFields(){

        phoneNumber.setText("");
        UserId.setText("");
        address.setText("");
        userName.setText("");
        password.setText("");
        rePassword.setText("");
        male.setSelected(false);
        female.setSelected(false);
        msg.setText("");
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
