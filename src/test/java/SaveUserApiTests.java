import Users.UsersClient;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class SaveUserApiTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void saveMaleUser(){

        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Poopye\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);
        usersClient.createUser(
                body)
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
        String body = String.format("{\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Olive\",\n" +
                "    \"email\": \"%s\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);
        usersClient.createUser(body)
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo(email));
    }





}
