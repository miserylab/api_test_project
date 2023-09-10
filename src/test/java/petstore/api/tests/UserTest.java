package petstore.api.tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import petstore.api.models.*;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static petstore.api.steps.UserSteps.*;

@Epic("User")
@Feature("Petstore User CRUD")
@Story("User CRUD")
@Tag("api")
public class UserTest extends BaseTest {

    @Test
    @DisplayName("Успешное создание пользователя")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfulCreateUser() {
        PostUserBodyModel requestBody = testData.createUserData;

        createUser(testData.createUserData);
        GetUserResponseModel retrievedUser = successfullGetUserByUserName(requestBody.getUsername());

        step("Проверить, что у созданного пользователя значения совпадают с указанными в requestBody", () -> {
            assertEquals(requestBody.getId(), retrievedUser.getId());
            assertEquals(requestBody.getUsername(), retrievedUser.getUsername());
            assertEquals(requestBody.getFirstName(), retrievedUser.getFirstName());
            assertEquals(requestBody.getLastName(), retrievedUser.getLastName());
            assertEquals(requestBody.getEmail(), retrievedUser.getEmail());
            assertEquals(requestBody.getPassword(), retrievedUser.getPassword());
            assertEquals(requestBody.getPassword(), retrievedUser.getPassword());
            assertEquals(requestBody.getUserStatus(), retrievedUser.getUserStatus());
        });
    }

    @Test
    @DisplayName("Успешное изменение пользователя")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfulUpdateUser() {
        PostUserBodyModel requestPostBody = testData.createUserData;
        PutUserBodyModel requestPutBody = testData.updateUserData;

        createUser(testData.createUserData);
        updateUser(requestPostBody.getUsername(), testData.updateUserData);
        GetUserResponseModel updatedUser = successfullGetUserByUserName(requestPutBody.getUsername());

        step("Проверить, что у изменённого пользователя значения совпадают с указанными в requestPutBody", () -> {
            assertEquals(requestPutBody.getId(), updatedUser.getId());
            assertEquals(requestPutBody.getUsername(), updatedUser.getUsername());
            assertEquals(requestPutBody.getFirstName(), updatedUser.getFirstName());
            assertEquals(requestPutBody.getLastName(), updatedUser.getLastName());
            assertEquals(requestPutBody.getEmail(), updatedUser.getEmail());
            assertEquals(requestPutBody.getPassword(), updatedUser.getPassword());
            assertEquals(requestPutBody.getPassword(), updatedUser.getPassword());
            assertEquals(requestPutBody.getUserStatus(), updatedUser.getUserStatus());
        });
    }

    @Test
    @DisplayName("Успешное удаление пользователя")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfulDeleteUser() {
        PostUserBodyModel requestBody = testData.createUserData;

        createUser(testData.createUserData);
        deleleUser(requestBody.getUsername());
        UserNotFoundResponseModel deletedUser = unsuccessfullGetUserByUserName(requestBody.getUsername());

        step("Проверить, что в ответе на запрос с указанием username удалённого пользователя выдаются корректные значения полей", () -> {
            assertEquals(testData.notFoundUserData.getCode(), deletedUser.getCode());
            assertEquals(testData.notFoundUserData.getType(), deletedUser.getType());
            assertEquals(testData.notFoundUserData.getMessage(), deletedUser.getMessage());
        });
    }
}
