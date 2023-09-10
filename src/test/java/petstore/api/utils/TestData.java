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

    public PostUserResponseModel createUserResponseData = new PostUserResponseModel();

    {
        createUserResponseData.setCode("200");
        createUserResponseData.setType("unknown");
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

    public PutUserResponseModel updateUserResponseData = new PutUserResponseModel();

    {
        updateUserResponseData.setCode("200");
        updateUserResponseData.setType("unknown");
    }

    public DeleteUserResponseModel deleteUserResponseData = new DeleteUserResponseModel();

    {
        deleteUserResponseData.setCode("200");
        deleteUserResponseData.setType("unknown");
    }

    public UserNotFoundResponseModel notFoundUserResponseData = new UserNotFoundResponseModel();

    {
        notFoundUserResponseData.setCode("1");
        notFoundUserResponseData.setType("error");
        notFoundUserResponseData.setMessage("User not found");
    }

    public LoginUserResponseModel loggedUserResponseData = new LoginUserResponseModel();

    {
        loggedUserResponseData.setCode("200");
        loggedUserResponseData.setType("unknown");
        loggedUserResponseData.setMessage("logged in user session");
    }

    public LogoutUserResponseModel loggedOutUserResponseData = new LogoutUserResponseModel();

    {
        loggedOutUserResponseData.setCode("200");
        loggedOutUserResponseData.setType("unknown");
        loggedOutUserResponseData.setMessage("ok");
    }
}
