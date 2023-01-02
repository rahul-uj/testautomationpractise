import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTests {
    @Test
    public void getAllUsers() {
        given()
                .when()
                    .get("https://gorest.co.in/public/v1/users")
                .then()
                    .statusCode(200)
                .body("data", Matchers.hasSize(10))
                .body("data",Matchers.hasItem(Matchers.hasEntry("gender","male")))
                    .log().body();
    }

    @Test
    public void saveMaleUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer f71a00fb0610866efbd24ef6b398a488e1ec69958a34886ad59a9710f7d0729d")
                .body("{\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"Harish\",\n" +
                        "    \"email\": \"harisha122@gmail.com\",\n" +
                        "    \"gender\": \"male\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo("harisha122@gmail.com"));
    }

    @Test
    public void saveFemaleUser(){
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization","Bearer f71a00fb0610866efbd24ef6b398a488e1ec69958a34886ad59a9710f7d0729d")
                .body("{\n" +
                        "    \"id\": 0,\n" +
                        "    \"name\": \"Gowri\",\n" +
                        "    \"email\": \"gowri101122@gmail.com\",\n" +
                        "    \"gender\": \"female\",\n" +
                        "    \"status\": \"active\"\n" +
                        "}")
                .when()
                .post("https://gorest.co.in/public/v1/users")
                .then()
                .log()
                .body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email",Matchers.equalTo("gowri101122@gmail.com"));
    }
}
