package lk.ijse.modle;

import javafx.scene.control.Alert;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.CarDetailsDto;
import lk.ijse.dto.CreateCustomerDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CarDetailsModle {

    public static boolean carSave(CarDetailsDto carDetailsDto) throws SQLException {

            String sql="INSERT INTO car_details VALUES(?,?,?,?,?,?)";

            Connection connection= DbConnection.getInstance().getConnection();
            PreparedStatement pstm = connection.prepareStatement(sql);

            pstm.setString(1, carDetailsDto.getRegNum());
            pstm.setString(2, carDetailsDto.getIdNum());
            pstm.setString(3, carDetailsDto.getModle());
            pstm.setString(4, carDetailsDto.getBrand());
            pstm.setString(5, carDetailsDto.getColor());
            pstm.setString(6, carDetailsDto.getTypeOf());



            if (pstm.executeUpdate()>0){
                return true;
            }
            return false;
    }
}
