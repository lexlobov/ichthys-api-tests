package clients;

import io.restassured.response.ValidatableResponse;
import models.athentication.User;

import static io.restassured.RestAssured.given;

public class UsersClient extends BaseSpec{

    private final String URI = "/api/v1/users";

    private ValidatableResponse getCurrentUser(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI + "/me")
                .then();
    }

    private User getCurrentUserModel(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI + "/me")
                .body().as(User.class);
    }
}
