package Users.create;

import lombok.*;

@Data
@Setter
@Getter
@Builder


public class CreateUserRequestBody {

    private String name;
    private String email;
    private String gender;
    private String status;

}
