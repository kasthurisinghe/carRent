package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CreateCustomerDto;
import lk.ijse.dto.tm.CreateCustomertm;
import lk.ijse.modle.CreateCustomerModle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public TableView <CreateCustomertm>tblCustomer;
    public TableColumn colCustomername;
    public TableColumn colAddress;
    public TableColumn colMobile;
    public TableColumn colNic;
    public TableColumn colRented;
    public TableColumn colCustomerId;

    public  void  initialize() throws SQLException {
//        loadAllCustomers();
    }

//    private void loadAllCustomers() throws SQLException {
//        Connection connection= DbConnection.getInstance().getConnection();
//
//        String sql="SELECT * FROM customer";
//        Statement stm = connection.createStatement();
////        Statement: It is used when you want to use SQL statements many times. The PreparedStatement interface accepts input parameters at runtime.
////PreparedStatement: It is used for accessing your database. Statement interface cannot accept parameters and useful when you are using static SQL statements at runtime. If you want to run SQL query only once then this interface is preferred over PreparedStatement.
//        ResultSet resultSet=stm.executeQuery(sql);
//        List<CreateCustomerModle> customerList=new ArrayList<>();
//
//
//
////        while (resultSet.next()){
////            String id=resultSet.getString(1);
////            String name=resultSet.getString(2);
////            String mobile=resultSet.getString(3);
////            String address=resultSet.getString(4);
////            String nic=resultSet.getString(5);
////
////            String sql1="SELECT * FROM customer";
////            Statement stm = connection.createStatement();
////
////            String rented=
////
////            new CreateCustomertm(id,name,mobile,address,nic,rented);
//        }
//
//    }

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
