package lk.ijse.modle;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UserModel {
    public static boolean save(String id, String userna, String addr, String mobile, String md5Pass, String gender) throws SQLException {

        String sql="INSERT INTO admin_user VALUES(?,?,?,?,?,?)";

        Connection connection= DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1,id);
        pstm.setString(2,userna);
        pstm.setString(3,addr);
        pstm.setString(4,mobile);
        pstm.setString(5,md5Pass);
        pstm.setString(6,gender);

        return pstm.executeUpdate()>0;
    }

    public static UserDto findUser(String id) throws SQLException {
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

            UserDto userDto=new UserDto(idDb,uName,address,phone,password,gend);
            return userDto;
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
