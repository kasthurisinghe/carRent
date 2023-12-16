package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BookingDetailsDto {
    String carId;
    String cacusId;
    String rate;
    String bookingId;
    LocalDate endDat;
    LocalDate startDat;
    Integer price;
}
