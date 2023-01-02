package Users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response createUser(String body) {
        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer f71a00fb0610866efbd24ef6b398a488e1ec69958a34886ad59a9710f7d0729d")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
    }

    public Response getUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }

}
