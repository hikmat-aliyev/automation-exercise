package apiClient;

import config.TestConfig;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class ProductApiClient {

    public static Response getAllProducts() {
        return given().when().log().all().get(TestConfig.APP_URL + "/api/productsList");
    }
}
