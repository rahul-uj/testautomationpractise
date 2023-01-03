import Users.UsersClient;
import Users.create.CreateUserRequestBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;


public class SaveUserApiTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void saveMaleUser(){

        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Poopye").gender("male").email(email).status("active").build();
        usersClient.createUser(
                requestBody)
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo(email));
    }
    @Test
    public void saveFemaleUser(){

        String email = String.format("%s@gmail.com",UUID.randomUUID());

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Olive").gender("female").email(email).status("active").build();
        usersClient.createUser(requestBody)
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo(email));
    }
}
