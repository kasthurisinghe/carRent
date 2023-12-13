package lk.ijse.modle;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.UserLoginDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginModle {
    public static boolean findUser(UserLoginDto userLoginDto) throws SQLException {
        Connection connection= DbConnection.getInstance().getConnection();

        String sql="SELECT*FROM admin_user WHERE ID=?";
        PreparedStatement pstm = connection.prepareStatement(sql);
        pstm.setString(1, userLoginDto.getUserId());
        ResultSet resultSet = pstm.executeQuery();

        if (resultSet.next() ){
            String id=resultSet.getString(1);
            String pw=resultSet.getString(5);

            if (userLoginDto.getUserId().equals(id)&& pw.equals(userLoginDto.getPassword())){
                return true;
            }

        }return false;
    }
}
