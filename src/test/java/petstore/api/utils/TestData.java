package petstore.api.utils;

import petstore.api.models.*;

public class TestData {
    RandomUtils random = new RandomUtils();
    public PostUserBodyModel createUserData = new PostUserBodyModel();

    {
        createUserData.setId(random.getRandomNumber());
        createUserData.setUsername(random.getRandomUserName());
        createUserData.setFirstName(random.getRandomFirstName());
        createUserData.setLastName(random.getRandomLastName());
        createUserData.setEmail(random.getRandomEmail());
        createUserData.setPassword(random.getRandomPassword());
        createUserData.setPhone(random.getRandomPhone());
        createUserData.setUserStatus(random.getRandomNumber());
    }

    public PutUserBodyModel updateUserData = new PutUserBodyModel();

    {
        updateUserData.setId(random.getRandomNumber());
        updateUserData.setUsername(random.getRandomUserName());
        updateUserData.setFirstName(random.getRandomFirstName());
        updateUserData.setLastName(random.getRandomLastName());
        updateUserData.setEmail(random.getRandomEmail());
        updateUserData.setPassword(random.getRandomPassword());
        updateUserData.setPhone(random.getRandomPhone());
        updateUserData.setUserStatus(random.getRandomNumber());
    }

    public UserNotFoundResponseModel notFoundUserData = new UserNotFoundResponseModel();

    {
        notFoundUserData.setCode("1");
        notFoundUserData.setType("error");
        notFoundUserData.setMessage("User not found");
    }

    public LoginUserResponseModel loggedUserData = new LoginUserResponseModel();

    {
        loggedUserData.setCode("200");
        loggedUserData.setType("unknown");
        loggedUserData.setMessage("logged in user session");
    }

    public LogoutUserResponseModel loggedOutUserData = new LogoutUserResponseModel();

    {
        loggedOutUserData.setCode("200");
        loggedOutUserData.setType("unknown");
        loggedOutUserData.setMessage("ok");
    }
}
