package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.AuthenticationSteps;

public class AuthenticationNegativeTest extends BaseTest{

    AuthenticationSteps steps = new AuthenticationSteps();

    @Test
    @DisplayName("Аутентификация с некорректным паролем")
    public void authenticationWithIncorrectPasswordTest(){
        steps.loginReturns401WithIncorrectPassword(email);
    }

    @Test
    @DisplayName("Аутентификация с незарегистрированным email")
    public void authenticationWithNotExistingEmailTest(){
        steps.loginReturns400WithUserThatDoesntExist();
    }
}
