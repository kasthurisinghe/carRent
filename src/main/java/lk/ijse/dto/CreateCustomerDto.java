package lk.ijse.dto;

import javafx.scene.control.TextField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class CreateCustomerDto {
    private String cstId;
    private String customerName;
    private String customerAddress;
    private String customerNic;
    private String customerMobile;

}
