import org.testng.Assert;
import user.UsersClient;
import user.create.CreateUserRequestBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.create.response.CreateUserErrorResponse;

public class SaveUserNegativeTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass() {
        usersClient = new UsersClient();
    }

    @Test
    public void shouldNotAllowToCreateUserWithInvalidId() {

        CreateUserRequestBody requestBody = CreateUserRequestBody.builder()
                .name("Mahesh").gender("male").email("Mahi.gmail.com").status("active").build();

        CreateUserErrorResponse errorResponse = usersClient.createUserExpectingResponse(requestBody);
        Assert.assertEquals(errorResponse.getStatusCode(),422);
        errorResponse.assertHasError("email","is invalid");

    }
}
