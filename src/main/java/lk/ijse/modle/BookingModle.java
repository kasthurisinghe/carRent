package lk.ijse.modle;

import lk.ijse.db.DbConnection;
import lk.ijse.dto.BookingDetailsDto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookingModle {

    public static boolean saveBooking(BookingDetailsDto bookingDetailsDto) throws SQLException {
        String sql="INSERT INTO booking_details VALUES(?,?,?,?,?,?,?)";

        Connection connection= DbConnection.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setString(1, bookingDetailsDto.getCarId());
        pstm.setString(2, bookingDetailsDto.getRate());
        pstm.setString(3, bookingDetailsDto.getCacusId());
        pstm.setString(4, String.valueOf(bookingDetailsDto.getStartDat()));
        pstm.setString(5, String.valueOf(bookingDetailsDto.getEndDat()));
        pstm.setString(6, bookingDetailsDto.getBookingId());
        pstm.setString(7, String.valueOf(bookingDetailsDto.getPrice()));

        if (pstm.executeUpdate()>0){
            return true;
        }
        return false;
    }
}
