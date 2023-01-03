package user.create;

import lombok.*;

@Data
@Getter
@Builder


public class CreateUserRequestBody {

    private String name;
    private String email;
    private String gender;
    private String status;

}
