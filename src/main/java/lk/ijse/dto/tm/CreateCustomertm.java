package lk.ijse.dto.tm;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCustomertm {
    private String custId;
    private String custName;
    private String custAddr;
    private String custNic;
    private String custMobile;


}
