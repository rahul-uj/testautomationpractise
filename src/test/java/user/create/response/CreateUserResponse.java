package user.create.response;

import lombok.Getter;
import lombok.Setter;

@Getter
public class CreateUserResponse {

@Setter
    private int statuscode;

    private  String meta;
    private Data data;
}
