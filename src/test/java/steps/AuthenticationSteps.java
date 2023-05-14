package steps;

import clients.AuthenticationClient;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AuthenticationSteps extends BaseSteps{

    public AuthenticationSteps(AuthenticationClient client){
        this.client = client;
    }


    public void loginWithCorrectCredentials(String login, String password){
        ValidatableResponse response = client.login(login, password);
        int actualStatusCode = response.extract().statusCode();
        assertThat("Status code should be 201", actualStatusCode, equalTo(HttpStatus.SC_CREATED));
    }

    public void logout(String login, String password){
        getTokenFromAuth(login, password);
        ValidatableResponse response = client.logout(getToken());
        int actualStatusCode = response.extract().statusCode();
        assertThat("Status code should be 200", actualStatusCode, equalTo(HttpStatus.SC_OK));
    }


}
