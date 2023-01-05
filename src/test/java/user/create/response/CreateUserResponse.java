package user.create.response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import user.create.CreateUserRequestBody;

import static org.testng.Assert.*;

@Getter
public class CreateUserResponse {

@Setter
    private int statuscode;

    private  String meta;
    private Data data;

    public void assertUser(CreateUserRequestBody requestBody) {
        assertNotNull(this.getData().getId());
        assertEquals(this.getData().getName(),requestBody.getName());
        assertEquals(this.getData().getGender(),requestBody.getGender());
        assertEquals(this.getData().getEmail(),requestBody.getEmail());
        assertEquals(this.getData().getStatus(),requestBody.getStatus());
        assertEquals(this.getStatuscode(),201);
    }
}
