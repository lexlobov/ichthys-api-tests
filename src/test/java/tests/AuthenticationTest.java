package tests;

import clients.AuthenticationClient;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AuthenticationSteps;


public class AuthenticationTest extends BaseTest{

    AuthenticationSteps steps = new AuthenticationSteps();

    @Test
    @DisplayName("Аутентификация с корректным email и паролем")
    public void authenticationWithCorrectCredentialsReturns201CodeTest(){
        steps.loginWithCorrectCredentials(email, password);
    }

    @Test
    @DisplayName("Логаут возвращает 200 код")
    public void logoutReturns200CodeTest(){
        steps.logout(email, password);
    }
}
