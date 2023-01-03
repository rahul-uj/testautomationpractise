package user;

import user.create.CreateUserRequestBody;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import user.create.response.CreateUserResponse;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public CreateUserResponse createUser(CreateUserRequestBody body) {
        Response response = create(body);
        CreateUserResponse createUserResponse = response.as(CreateUserResponse.class);
        createUserResponse.setStatuscode(response.statusCode());
        return createUserResponse;
    }

    public Response create(CreateUserRequestBody body) {
        Response response = given().accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer f71a00fb0610866efbd24ef6b398a488e1ec69958a34886ad59a9710f7d0729d")
                .body(body)
                .when()
                .post("https://gorest.co.in/public/v1/users");
         response.then().log().body();
         return  response;
    }

    public Response getUsers() {
        return given()
                .when()
                .get("https://gorest.co.in/public/v1/users");
    }

}
