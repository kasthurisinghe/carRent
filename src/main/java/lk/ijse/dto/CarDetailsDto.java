package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CarDetailsDto {
    private String regNum;
    private String idNum;
    private String modle;
    private String color;
    private String brand;
    private String typeOf;
}
