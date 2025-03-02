package base;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class APIBase {
    private static final String BASE_URL = "https://restcountries.com/v3.1/translation/";

    public static Response getCountryTranslation(String translation) {
        return RestAssured
                .given()
                .when()
                .get(BASE_URL + translation)
                .then()
                .extract()
                .response();
    }
}
