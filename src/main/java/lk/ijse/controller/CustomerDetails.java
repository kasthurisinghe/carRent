package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    public Label notifyMessage;

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
        clearFields();

    }

    public void btnFindCustomerClickOnAction(ActionEvent actionEvent) throws SQLException {
        String id=txtCstId.getText();

        CreateCustomerDto createCustomerDto=CreateCustomerModle.findCustomer(id);

        if (createCustomerDto!=null) {
            txtCstId.setText(createCustomerDto.getCstId());
            txtCustomerName.setText(createCustomerDto.getCustomerName());
            txtCustomerAddress.setText(createCustomerDto.getCustomerAddress());
            txtCustomerNic.setText(createCustomerDto.getCustomerNic());
            txtCustomerMobile.setText(createCustomerDto.getCustomerMobile());
        }
        else {
            new Alert(Alert.AlertType.ERROR, "Incorrect Customer ID number ").show();
        }

        clearFields();
    }

    public void btnUpdateClickOnAction(ActionEvent actionEvent) throws SQLException {
        String custId=txtCstId.getText();
        String custName=txtCustomerName.getText();
        String custAddr=txtCustomerAddress.getText();
        String custNic=txtCustomerNic.getText();
        String custMobile=txtCustomerMobile.getText();

        CreateCustomerDto createCustomerDto =new CreateCustomerDto(custId,custName,custAddr,custNic,custMobile);
        CreateCustomerModle.updateCustomer(createCustomerDto);
        clearFields();
    }

    public void btnDeleteClickOnAction(ActionEvent actionEvent) throws SQLException {
        String id=txtCstId.getText();

        CreateCustomerModle.deleteCustomer(id);
        clearFields();
    }
    private void clearFields(){

        txtCstId.setText("");
        txtCustomerName.setText("");
        txtCustomerAddress.setText("");
        txtCustomerMobile.setText("");
        txtCustomerNic.setText("");
        notifyMessage.setText("");
    }

}
