package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import lk.ijse.db.DbConnection;
import lk.ijse.dto.BookingDetailsDto;
import lk.ijse.modle.BookingModle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class BookingDetails {
    public Button BtnDelete;
    public Button BtnUpdate;
    public Button BtnRent;
    public TextField txtCarId;
    public TextField TxtCustomerId;
    public TextField txtRate;
    public TextField txtBookingId;

    public TableColumn tblBookingId;
    public TableColumn tblCarId;
    public TableColumn tblCustomerId;
    public TableColumn tblDate;
    public TableColumn tblRate;
    public TableColumn tblTotalPrice;
    public Label msgLab;
    public TableView table;
    public DatePicker endDate;
    public DatePicker startDate;

    public void txtClickOnAction(ActionEvent actionEvent) {
    }


    public void btnDeleteClickOnAction(ActionEvent actionEvent) {
    }

    public void btnUpdateClickOnAction(ActionEvent actionEvent) {
    }

    public void btnRentClickOnAction(ActionEvent actionEvent) throws SQLException {
        try {
            String carId=txtCarId.getText();
            String cacusId=TxtCustomerId.getText();
            String rate=txtRate.getText();
            String bookingId=txtBookingId.getText();
            LocalDate endDat=endDate.getValue();
            LocalDate startDat=startDate.getValue();
            long daysBetween = ChronoUnit.DAYS.between(startDat, endDat);
            Integer price= (int) (Integer.parseInt(rate)*daysBetween);

            BookingDetailsDto bookingDetailsDto=new BookingDetailsDto(carId,cacusId,rate,bookingId,endDat,startDat,price);
            boolean isSaved= BookingModle.saveBooking(bookingDetailsDto);

            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION,"saved").show();
            }
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        } catch (SQLException e) {
            new Alert(Alert.AlertType.ERROR,e.getMessage()).show();
        }

    }


    public void txtIdClickOnAction(ActionEvent actionEvent) {
    }
}
