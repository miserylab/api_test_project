package petstore.api.utils;

import petstore.api.models.*;

import static petstore.api.utils.RandomUtils.*;

public class TestData {
    public PostUserBodyModel createUserData = new PostUserBodyModel();

    {
        createUserData.setId(getRandomNumber());
        createUserData.setUsername(getRandomUserName());
        createUserData.setFirstName(getRandomFirstName());
        createUserData.setLastName(getRandomLastName());
        createUserData.setEmail(getRandomEmail());
        createUserData.setPassword(getRandomPassword());
        createUserData.setPhone(getRandomPhone());
        createUserData.setUserStatus(getRandomNumber());
    }

    public PostUserResponseModel createUserResponseData = new PostUserResponseModel();

    {
        createUserResponseData.setCode("200");
        createUserResponseData.setType("unknown");
    }

    public PutUserBodyModel updateUserData = new PutUserBodyModel();

    {
        updateUserData.setId(getRandomNumber());
        updateUserData.setUsername(getRandomUserName());
        updateUserData.setFirstName(getRandomFirstName());
        updateUserData.setLastName(getRandomLastName());
        updateUserData.setEmail(getRandomEmail());
        updateUserData.setPassword(getRandomPassword());
        updateUserData.setPhone(getRandomPhone());
        updateUserData.setUserStatus(getRandomNumber());
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
