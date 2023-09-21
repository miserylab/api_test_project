package petstore.api.utils;

import petstore.api.models.*;

import static petstore.api.utils.RandomUtils.*;

public class TestData {
    public PostUserBodyModel createUserData = PostUserBodyModel.builder()
            .id(getRandomNumber())
            .username(getRandomUserName())
            .firstName(getRandomFirstName())
            .lastName(getRandomLastName())
            .email(getRandomEmail())
            .password(getRandomPassword())
            .phone(getRandomPhone())
            .userStatus(getRandomNumber())
            .build();

    public PostUserResponseModel createUserResponseData = PostUserResponseModel.builder()
            .code("200")
            .type("unknown")
            .build();

    public PutUserBodyModel updateUserData = PutUserBodyModel.builder()
            .id(getRandomNumber())
            .username(getRandomUserName())
            .firstName(getRandomFirstName())
            .lastName(getRandomLastName())
            .email(getRandomEmail())
            .password(getRandomPassword())
            .phone(getRandomPhone())
            .userStatus(getRandomNumber())
            .build();

    public PutUserResponseModel updateUserResponseData = PutUserResponseModel.builder()
            .code("200")
            .type("unknown")
            .build();

    public DeleteUserResponseModel deleteUserResponseData = DeleteUserResponseModel.builder()
            .code("200")
            .type("unknown")
            .build();

    public UserNotFoundResponseModel notFoundUserResponseData = UserNotFoundResponseModel.builder()
            .code("1")
            .type("error")
            .message("User not found")
            .build();

    public LoginUserResponseModel loggedUserResponseData = LoginUserResponseModel.builder()
            .code("200")
            .type("unknown")
            .message("logged in user session")
            .build();

    public LogoutUserResponseModel loggedOutUserResponseData = LogoutUserResponseModel.builder()
            .code("200")
            .type("unknown")
            .message("ok")
            .build();
}
