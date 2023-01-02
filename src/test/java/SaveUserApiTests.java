import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SaveUserApiTests {

    @Test
    public void saveMaleUser(){
        String body = "{\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Poopye\",\n" +
                "    \"email\": \"sailor@gmail.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        createUser(
                body)
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo("sailor@gmail.com"));
    }
    @Test
    public void saveFemaleUser(){
        String body = "{\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Olive\",\n" +
                "    \"email\": \"olive@gmail.com\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        createUser(body)
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo("olive@gmail.com"));
    }
    private Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer f71a00fb0610866efbd24ef6b398a488e1ec69958a34886ad59a9710f7d0729d")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }


}
