package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import lk.ijse.dto.CreateCustomerDto;
import lk.ijse.modle.CreateCustomerModle;

import java.sql.SQLException;

public class CustomerDetails {
    public Button createCustomerBtn;
    public Button mainMenuCustomerbtn;
    public Button findCustomerbtn;
    public Button updateCustomerbtn;
    public Button deleteCustomerbtn;
    public TextField txtCustomerName;
    public TextField txtCustomerMobile;
    public TextField txtCustomerAddress;
    public TextField txtCustomerNic;
    public TextField txtCstId;

    public void btnCreateCustomerClickOnAction(ActionEvent actionEvent) throws SQLException {
        try {
            String custId=txtCstId.getText();
            String custName=txtCustomerName.getText();
            String custAddr=txtCustomerAddress.getText();
            String custNic=txtCustomerNic.getText();
            String custMobile=txtCustomerMobile.getText();

            CreateCustomerDto createCustomerDto=new CreateCustomerDto(custId,custName,custAddr,custNic,custMobile);
            boolean isSaved= CreateCustomerModle.saveCustomer(createCustomerDto);

            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Details saved.").show();
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }

    public void btnFindCustomerClickOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateClickOnAction(ActionEvent actionEvent) {
    }

    public void btnDeleteClickOnAction(ActionEvent actionEvent) {
    }

    public void btnMainMenuClickOnAction(ActionEvent actionEvent) {
    }

    public void txtIdClickOnAction(ActionEvent actionEvent) {
    }
}
