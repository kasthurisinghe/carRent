package lk.ijse.modle;

import javafx.scene.control.Alert;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CreateCustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CreateCustomerModle {

    public static boolean saveCustomer(CreateCustomerDto createCustomerDto) throws SQLException {
        String sql="INSERT INTO Customer VALUES(?,?,?,?,?)";

        Connection connection= DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, createCustomerDto.getCstId());
        pstm.setString(2, createCustomerDto.getCustomerName());
        pstm.setString(3, createCustomerDto.getCustomerAddress());
        pstm.setString(4, createCustomerDto.getCustomerNic());
        pstm.setString(5, createCustomerDto.getCustomerMobile());

        return pstm.executeUpdate()>0;
    }

    public static CreateCustomerDto findCustomer(String id) throws SQLException {
        try {
            String sql="SELECT* FROM customer WHERE Customer_ID=?";

            Connection connection= DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);
            pstm.setString(1,id);

            ResultSet resultSet = pstm.executeQuery();
            if (resultSet.next()){
                String custId=resultSet.getString(1);
                String custName=resultSet.getString(2);
                String custAddr=resultSet.getString(3);
                String custNic=resultSet.getString(4);
                String custPhone=resultSet.getString(5);

                CreateCustomerDto createCustomerDto=new CreateCustomerDto(custId,custName,custAddr,custNic,custPhone);
                return createCustomerDto;
            }

        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();

        }return null;
    }

    public static boolean updateCustomer(CreateCustomerDto createCustomerDto) throws SQLException {
        try {
            String sql="UPDATE Customer SET Customer_name=?,address=?,NIC=?,Phone_Number=? WHERE Customer_ID=?";

            Connection connection= DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);


            pstm.setString(1, createCustomerDto.getCustomerName());
            pstm.setString(2, createCustomerDto.getCustomerAddress());
            pstm.setString(3, createCustomerDto.getCustomerNic());
            pstm.setString(4, createCustomerDto.getCustomerMobile());
            pstm.setString(5, createCustomerDto.getCstId());

            if (pstm.executeUpdate()>0){
                new Alert(Alert.AlertType.CONFIRMATION, "Customer successfully updated").show();
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }
        return false;
    }

    public static boolean deleteCustomer(String id) throws SQLException {
        try {
            Connection connection= DbConnection.getInstance().getConnection();
            String sql="DELETE FROM Customer WHERE Customer_ID=?";

            PreparedStatement statement = connection.prepareCall(sql);
            statement.setString(1, id);

            if (statement.executeUpdate() > 0) {
                new Alert(Alert.AlertType.CONFIRMATION,"Customer Deleted successfully").show();
                return true;
            }
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        return false;
    }
}
