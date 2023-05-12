package tests;

import clients.AuthenticationClient;
import org.junit.jupiter.api.Test;
import steps.AuthenticationSteps;


public class AuthenticationTest extends BaseTest{

    AuthenticationClient client = new AuthenticationClient();
    AuthenticationSteps steps = new AuthenticationSteps(client);

    @Test
    public void authenticationWithCorrectCredentialsTest(){
        steps.getTokenFromAuth(email, password);
        steps.loginWithCorrectCredentials(email, password);
    }
}
