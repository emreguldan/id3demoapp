package tr.com.id3.guldan.emre.id3demoapp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterUserDto {
    private String email;
    private String password;
    private String name;
    private String surname;
    private String identificationNumber;
}
