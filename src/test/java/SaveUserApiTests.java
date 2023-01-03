import org.testng.Assert;
import user.UsersClient;
import user.create.CreateUserRequestBody;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import user.create.response.CreateUserResponse;

import java.util.UUID;

import static org.testng.Assert.*;


public class SaveUserApiTests {

    private UsersClient usersClient;

    @BeforeClass
    public void beforeClass(){
        usersClient = new UsersClient();
    }

    @Test
    public void saveMaleUser(){

        String email = String.format("%s@gmail.com", UUID.randomUUID());

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Poopye").gender("male").email(email).status("active").build();
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);
        assertEquals(createUserResponse.getStatuscode(),201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getEmail(),requestBody.getEmail());
    }
    @Test
    public void saveFemaleUser(){

        String email = String.format("%s@gmail.com",UUID.randomUUID());

        CreateUserRequestBody requestBody =  CreateUserRequestBody.builder()
                .name("Olive").gender("female").email(email).status("active").build();
        CreateUserResponse createUserResponse = usersClient.createUser(requestBody);
        assertEquals(createUserResponse.getStatuscode(),201);
        assertNotNull(createUserResponse.getData().getId());
        assertEquals(createUserResponse.getData().getEmail(),requestBody.getEmail());

    }
}
