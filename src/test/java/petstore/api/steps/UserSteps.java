package petstore.api.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import petstore.api.models.GetUserResponseModel;
import petstore.api.models.PostUserBodyModel;
import petstore.api.models.PostUserResponseModel;
import petstore.api.tests.BaseTest;


import static io.restassured.RestAssured.given;
import static petstore.api.specs.UserSpec.userPostRequestSpec;

public class UserSteps {

    @Step("Создать нового пользователя")
    public static PostUserResponseModel createUser(PostUserBodyModel user) {
        return given()
                .spec(userPostRequestSpec)
                .body(user).log().all()
                .post("/user")
                .then().log().all()
                .statusCode(200)
                .extract().as(PostUserResponseModel.class);
    }

    private static Response getUserByUsername(String userName) {
        return given()
                .when()
                .get("/user/" + userName);
    }

    @Step("Получить существующего пользователя c username = {userName}")
    public static GetUserResponseModel successfullGetUserByUserName(String userName){
        return getUserByUsername(userName)
                .then().log().all()
                .statusCode(200)
                .extract().as(GetUserResponseModel.class);
    }
}
