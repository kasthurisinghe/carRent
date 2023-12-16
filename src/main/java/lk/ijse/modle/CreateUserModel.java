package lk.ijse.modle;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.CreateUserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class CreateUserModel {
    public static boolean save(CreateUserDto createUserDto) throws SQLException {

        String sql="INSERT INTO admin_user VALUES(?,?,?,?,?,?)";

        Connection connection= DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, createUserDto.getId());
        pstm.setString(2, createUserDto.getUserna());
        pstm.setString(3, createUserDto.getAddr());
        pstm.setString(4, createUserDto.getMobile());
        pstm.setString(5, createUserDto.getMd5Pass());
        pstm.setString(6, createUserDto.getGender());

        return pstm.executeUpdate()>0;
    }

    public static CreateUserDto findUser(String id) throws SQLException {
        Connection connection=DbConnection.getInstance().getConnection();

        String sql="SELECT*FROM admin_user where id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next() ){

            String idDb=resultSet.getString(1);
            String uName=resultSet.getString(2);
            String address=resultSet.getString(3);
            String phone=resultSet.getString(4);
            String password=resultSet.getString(5);
            String gend=resultSet.getString(6);

            CreateUserDto createUserDto =new CreateUserDto(idDb,uName,address,phone,password,gend);
            return createUserDto;
        }
        return null;
    }

    public static boolean deleteUser(String id) throws SQLException {
        Connection connection=DbConnection.getInstance().getConnection();

        String sql="DELETE FROM admin_user where id=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1,id);

        if (pstm.executeUpdate()>0){
            return  true;
        }
        return false;
    }
}
