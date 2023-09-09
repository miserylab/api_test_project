package petstore.api.tests;


import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import petstore.api.models.GetUserResponseModel;
import petstore.api.models.PostUserBodyModel;

import static io.qameta.allure.Allure.step;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static petstore.api.steps.UserSteps.createUser;
import static petstore.api.steps.UserSteps.successfullGetUserByUserName;

@Epic("User")
@Feature("Petstore User CRUD")
@Story("User CRUD")
@Tag("api")
public class UserTest  extends  BaseTest{

    @Test
    @DisplayName("Успешное создание пользователя")
    @Owner("o.demina")
    @Severity(BLOCKER)
    void successfulCreateUser() {
        PostUserBodyModel requestBody = testData.createUserData;
        createUser(requestBody);
        GetUserResponseModel retrievedUser = successfullGetUserByUserName(requestBody.getUsername());

        step("Verify created user values", () -> {
        assertEquals(requestBody.getId(),retrievedUser.getId());
        assertEquals(requestBody.getUsername(),retrievedUser.getUsername());
        assertEquals(requestBody.getFirstName(),retrievedUser.getFirstName());
        assertEquals(requestBody.getLastName(),retrievedUser.getLastName());
        assertEquals(requestBody.getEmail(),retrievedUser.getEmail());
        assertEquals(requestBody.getPassword(),retrievedUser.getPassword());
        assertEquals(requestBody.getPassword(),retrievedUser.getPassword());
        assertEquals(requestBody.getUserStatus(),retrievedUser.getUserStatus());
        });
    }

}
