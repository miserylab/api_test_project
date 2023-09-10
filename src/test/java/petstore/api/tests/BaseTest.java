package petstore.api.tests;

import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;
import petstore.api.config.WebConfig;
import petstore.api.utils.TestData;

public class BaseTest {
    TestData testData = new TestData();
    private static final WebConfig config = ConfigFactory.create(WebConfig.class);

    @BeforeAll
    static void beforeAll() {
        RestAssured.baseURI = config.getBaseUri();
        RestAssured.basePath = config.getBasePath();
    }
}
