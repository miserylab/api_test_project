package petstore.api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.BODY;
import static io.restassured.filter.log.LogDetail.STATUS;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static org.hamcrest.Matchers.notNullValue;
import static petstore.api.helpers.CustomAllureListener.withCustomTemplates;

public class UserSpec {

    public static RequestSpecification userPostRequestSpec = with()
            .log().uri()
            .log().method()
            .log().body()
            .filter(withCustomTemplates())
            .contentType(JSON);

    public static ResponseSpecification userPostResponseSpec = new ResponseSpecBuilder()
            .log(STATUS)
            .log(BODY)
            .expectStatusCode(200)
            .expectBody(matchesJsonSchemaInClasspath("schemas/success-user-create-response-schema.json"))
            .expectBody("code", notNullValue())
            .expectBody("type", notNullValue())
            .expectBody("message", notNullValue())
            .build();


}
