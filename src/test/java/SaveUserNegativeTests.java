import Users.UsersClient;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class SaveUserNegativeTests {

    @Test
    public void shouldNotAllowToCreateUserWithInvalidId(){
        String body = "{\n" +
                "    \"id\": 0,\n" +
                "    \"name\": \"Mahesh\",\n" +
                "    \"email\": \"Mahigmail.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        new UsersClient().createUser(body)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }
}
