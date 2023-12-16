package lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomertm {

    private String custName;
    private String custAddr;
    private String custMobile;
    private String custNic;
    private String custRentedVehicles;

}
