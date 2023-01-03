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
        String name = "Poopye";
        String status = "active";
        String gender = "male";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, email, gender, status);
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
        String name = "Olive";
        String gender = "female";
        String status = "active";


        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, email, gender, status);
        usersClient.createUser(requestBody)
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo(email));
    }





}
