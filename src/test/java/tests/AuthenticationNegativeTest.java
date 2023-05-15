package tests;

import org.junit.jupiter.api.Test;
import steps.AuthenticationSteps;

public class AuthenticationNegativeTest extends BaseTest{

    AuthenticationSteps steps = new AuthenticationSteps();

    @Test
    public void authenticationWithIncorrectPasswordTest(){
        steps.loginReturns401WithIncorrectPassword(email);
    }

    @Test void authenticationWithNotExistingEmailTest(){
        steps.loginReturns400WithUserThatDoesntExist();
    }
}
