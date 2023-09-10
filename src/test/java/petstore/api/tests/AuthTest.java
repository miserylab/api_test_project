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
@Tag("api")
public class AuthTest extends BaseTest {

    @Test
    @Feature("Log in")
    @Story("Log in with credentials")
    @DisplayName("Успешный логин пользователя")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfullLogin() {
        PostUserBodyModel requestBody = testData.createUserData;

        createUser(testData.createUserData);
        LoginUserResponseModel loggedUser = loginUser(requestBody.getUsername(), requestBody.getPassword());

        step("Проверить, что в ответе на запрос с указанием username удалённого пользователя выдаются корректные значения полей", () -> {
            assertEquals(loggedUser.getCode(), testData.loggedUserData.getCode());
            assertEquals(loggedUser.getType(), testData.loggedUserData.getType());
            assertThat(loggedUser.getMessage(), startsWith(testData.loggedUserData.getMessage()));
        });
    }

    @Test
    @Feature("Log out")
    @Story("Logout")
    @DisplayName("Успешный логаут пользователя")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfullLogout() {
        PostUserBodyModel requestBody = testData.createUserData;

        createUser(testData.createUserData);
        loginUser(requestBody.getUsername(), requestBody.getPassword());
        LogoutUserResponseModel loggedOutUser = logoutUser();

        step("Проверить, что в ответе на запрос выдаются корректные значения полей", () -> {
            assertEquals(loggedOutUser.getCode(), testData.loggedOutUserData.getCode());
            assertEquals(loggedOutUser.getType(), testData.loggedOutUserData.getType());
            assertEquals(loggedOutUser.getMessage(), testData.loggedOutUserData.getMessage());
        });

    }
}
