package petstore.api.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import petstore.api.models.LoginUserResponseModel;
import petstore.api.models.LogoutUserResponseModel;
import petstore.api.models.PostUserBodyModel;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.startsWith;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static petstore.api.steps.UserSteps.*;

@Epic("Authorization")
@Owner("o.demina")
@Tag("api")
public class AuthTest extends BaseTest {

    @Test
    @Feature("Log in")
    @Story("Log in with credentials")
    @DisplayName("Успешный логин пользователя")
    @Severity(BLOCKER)
    void successfullLogin() {
        PostUserBodyModel requestBody = testData.createUserData;

        createUser(testData.createUserData);
        LoginUserResponseModel loggedUserResponse = loginUser(requestBody.getUsername(), requestBody.getPassword());

        step("Проверить, что в ответе на запрос с указанием username удалённого пользователя выдаются корректные значения полей", () -> {
            assertEquals(loggedUserResponse.getCode(), testData.loggedUserResponseData.getCode());
            assertEquals(loggedUserResponse.getType(), testData.loggedUserResponseData.getType());
            assertThat(loggedUserResponse.getMessage(), startsWith(testData.loggedUserResponseData.getMessage()));
        });
    }

    @Test
    @Feature("Log out")
    @Story("Logout")
    @DisplayName("Успешный логаут пользователя")
    @Severity(BLOCKER)
    void successfullLogout() {
        PostUserBodyModel requestBody = testData.createUserData;

        createUser(testData.createUserData);
        loginUser(requestBody.getUsername(), requestBody.getPassword());
        LogoutUserResponseModel loggedOutUserResponse = logoutUser();

        step("Проверить, что в ответе на запрос выдаются корректные значения полей", () -> {
            assertEquals(loggedOutUserResponse.getCode(), testData.loggedOutUserResponseData.getCode());
            assertEquals(loggedOutUserResponse.getType(), testData.loggedOutUserResponseData.getType());
            assertEquals(loggedOutUserResponse.getMessage(), testData.loggedOutUserResponseData.getMessage());
        });

    }
}
