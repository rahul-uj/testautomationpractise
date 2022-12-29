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
}
