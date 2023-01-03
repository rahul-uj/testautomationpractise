import Users.UsersClient;
import Users.create.CreateUserRequestBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaveUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }
    @Test
    public void shouldNotAllowToCreateUserWithInvalidId(){
        String name = "Mahesh";
        String email = "Mahigmail.com";
        String gender = "male";
        String status = "active";

        CreateUserRequestBody requestBody = new CreateUserRequestBody(name, email, gender, status);
        usersClient.createUser(requestBody)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field","email")))
                .body("data",Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }
}
