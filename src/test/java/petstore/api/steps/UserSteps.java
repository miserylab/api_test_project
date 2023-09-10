package petstore.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import petstore.api.models.*;

import static io.restassured.RestAssured.given;
import static petstore.api.specs.UserSpec.*;

public class UserSteps {

    @Step("Создать нового пользователя")
    public static PostUserResponseModel createUser(PostUserBodyModel user) {
        return given(userPostRequestSpec)
                .body(user)
                .post("/user")
                .then()
                .spec(userPostResponseSpec)
                .extract().as(PostUserResponseModel.class);
    }

    private static Response getUserByUsername(String username) {
        return given(userGetRequestSpec)
                .when()
                .get("/user/" + username);
    }

    @Step("Получить существующего пользователя c username = {username}")
    public static GetUserResponseModel successfullGetUserByUserName(String username) {
        return getUserByUsername(username)
                .then()
                .spec(userGetResponseSpec)
                .extract().as(GetUserResponseModel.class);
    }

    @Step("Получить несуществующего пользователя c username = {username}")
    public static UserNotFoundResponseModel unsuccessfullGetUserByUserName(String username) {
        return getUserByUsername(username)
                .then()
                .spec(getUserNotFoundResponseSpec)
                .extract().as(UserNotFoundResponseModel.class);
    }

    @Step("Изменить пользователя c username = {username}")
    public static PutUserResponseModel updateUser(String username, PutUserBodyModel user) {
        return given(userPutRequestSpec)
                .body(user)
                .put("/user/" + username)
                .then()
                .spec(userPutResponseSpec)
                .extract().as(PutUserResponseModel.class);
    }

    @Step("Удалить пользовтаеля с username = {username}")
    public static DeleteUserResponseModel deleleUser(String username) {
        return given(userDeleteRequestSpec)
                .delete("/user/" + username)
                .then()
                .spec(userDeleteResponseSpec)
                .extract().as(DeleteUserResponseModel.class);
    }

    @Step("Успешный логин пользователя с username = {username} и password = {password}")
    public static LoginUserResponseModel loginUser(String username, String password) {
        return given(userGetRequestSpec)
                .when()
                .params("username", username, "password", password)
                .get("/user/login")
                .then()
                .spec(userGetLoginResponseSpec)
                .extract().as(LoginUserResponseModel.class);
    }

    @Step("Успешный logout")
    public static LogoutUserResponseModel logoutUser() {
        return given(userGetRequestSpec)
                .when()
                .get("/user/logout")
                .then()
                .spec(userGetLogoutResponseSpec)
                .extract().as(LogoutUserResponseModel.class);
    }

}
