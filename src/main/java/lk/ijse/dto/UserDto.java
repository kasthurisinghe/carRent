package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class UserDto {

    private String id;
    private String userna;
    private String addr;
    private String mobile;
    private String md5Pass;
    private String gender;

}
