package steps;

import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class AuthenticationSteps extends BaseSteps{

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

    public void loginReturns401WithIncorrectPassword(String login){
        String incorrectPassword = "12345";
        ValidatableResponse response = client.login(login, incorrectPassword);
        assertThat("Authorization with incorrect password should return 401 status code",
                response
                        .extract().statusCode()==HttpStatus.SC_UNAUTHORIZED);
        String message = response.extract().body().jsonPath().getString("message");
        assertThat("Message should be 'Unauthorized'", message.equals("Unauthorized"));
    }

    public void loginReturns400WithUserThatDoesntExist(){
        String notExistingEmail = "12345@example.com";
        String incorrectPassword = "12345";
        ValidatableResponse response = client.login(notExistingEmail, incorrectPassword);
        assertThat("Authorization with not existing email should return 400 status code",
                response
                        .extract().statusCode()==HttpStatus.SC_BAD_REQUEST);
        String message = response.extract().body().jsonPath().getString("message");
        assertThat("Message should be 'User not found'", message.equals("User not found"));
    }

}
