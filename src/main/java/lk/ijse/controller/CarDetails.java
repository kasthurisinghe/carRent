package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lk.ijse.dto.CarDetailsDto;
import lk.ijse.modle.CarDetailsModle;

import java.sql.SQLException;

public class CarDetails {
    public TextField regNo;
    public TextField VehiIdNo;
    public ComboBox typeComb;
    public Button checkVehiButton;
    public Button updateButton;
    public Button registerButton;
    public Button deleteButton;
    public TextField txtModle;
    public TextField txtColour;
    public TextField txtBrand;
    public Label notifyMsg;

    String vehiType="";

    public void initialize(){

        ObservableList<String> listTypeVehi= FXCollections.observableArrayList("Sedan", "Hatchback", "Sport", "Convertible");

        typeComb.setItems(listTypeVehi);
    }

    public void selectType(ActionEvent actionEvent) {
        vehiType=typeComb.getSelectionModel().getSelectedItem().toString();
    }

    public void btnDetailsCliskOnAction(ActionEvent actionEvent) throws SQLException {
        String id =VehiIdNo.getText();

    }

    public void btnUpdateClickOnAction(ActionEvent actionEvent) {
    }

    public void btnRegsterClickOnAction(ActionEvent actionEvent) {
        try {
            String regNum=regNo.getText();
            String idNum=VehiIdNo.getText();
            String modle=txtModle.getText();
            String color= txtColour.getText();
            String brand= txtBrand.getText();
            String typeOf=vehiType;

            if (!regNum.equals("")&& !idNum.equals("") && !modle.equals("") && !color.equals("") && !color.equals("")){
                CarDetailsDto carDetailsDto = new CarDetailsDto(regNum, idNum, modle, color, brand, typeOf);


                boolean isSaved = CarDetailsModle.carSave(carDetailsDto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "saved").show();
                    clearFields();
                }
            }
            else {
                notifyMsg.setText("Plese enter all the fields of the form");
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
            System.out.println("no?");
        }
    }

    public void bntDeleteClickOnAction(ActionEvent actionEvent) {
    }
    private void clearFields(){

        txtBrand.setText("");
        txtColour.setText("");
        txtModle.setText("");
        regNo.setText("");
        VehiIdNo.setText("");
        typeComb.setValue(null);
    }
}
