package clients;

import io.restassured.response.ValidatableResponse;
import models.athentication.AuthenticationResponse;

import static io.restassured.RestAssured.given;

public class AuthenticationClient extends BaseSpec{

    private final String URI = "/api/v1/auth";

    public ValidatableResponse login(String email, String password){
        return given().spec(baseSpec())
                .when()
                .body(String.format("{\n" +
                        "  \"email\": \"%s\",\n" +
                        "  \"password\": \"%s\"\n" +
                        "}", email, password))
                .post(baseUrl + URI + "/login")
                .then();
    }

    public AuthenticationResponse loginUserModel(String email, String password){
        return given().spec(baseSpec())
                .when()
                .body(String.format("{\n" +
                        "  \"email\": \"%s\",\n" +
                        "  \"password\": \"%s\"\n" +
                        "}", email, password))

                .post(URI + "/login")

                .body().as(AuthenticationResponse.class);
    }

    public ValidatableResponse logout(String token){
        return given().spec(baseSpec())
                .when()
                .header("Authorization", String.format("Bearer %s", token))
                .get(URI + "/logout")
                .then();

    }

    public ValidatableResponse profile(String token){
        return given().spec(baseSpec())
                .when()
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI + "/profile")
                .then();
    }

    public ValidatableResponse refresh(String token){
        return given().spec(baseSpec())
                .when()
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI + "/refresh")
                .then();
    }
}
