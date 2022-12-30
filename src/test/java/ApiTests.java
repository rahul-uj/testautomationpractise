import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {
    @Test
    public void getAllUsers() {
        given()
                .when()
                    .get("https://gorest.co.in/public/v2/users")
                .then()
                    .statusCode(200)
                    .log().body();
    }

    @Test
    public void saveUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer f71a00fb0610866efbd24ef6b398a488e1ec69958a34886ad59a9710f7d0729d")
                .body("{\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"Jayanthi\",\n" +
                        "    \"email\": \"jayanthi@gmail.com\",\n" +
                        "    \"gender\": \"female\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v2/users")
                .then()
                .log()
                .body()
                .statusCode(201);
    }
}
