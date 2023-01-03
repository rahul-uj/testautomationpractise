import user.UsersClient;
import user.create.CreateUserRequestBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SaveUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidId() {

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Mahesh").gender("male").email("Mahigmail.com").status("active").build();
        usersClient.create(requestBody)
                .then()
                    .statusCode(422)
                    .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                    .body("data", Matchers.hasItem(Matchers.hasEntry("message", "is invalid")));

    }
}
