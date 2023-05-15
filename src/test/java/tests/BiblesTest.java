package tests;

import org.junit.jupiter.api.Test;
import steps.BiblesSteps;

public class BiblesTest extends BaseTest{

    BiblesSteps steps = new BiblesSteps();

    @Test
    public void shouldBe3BiblesTest(){
        steps.biblesRequestContains3Bibles(steps.getTokenFromAuth(email, password));
    }
    @Test
    public void shouldBe3languagesOfBibles(){
        steps.biblesRequestReturnsDeEnRuBibles(steps.getTokenFromAuth(email, password));
    }

    @Test
    public void biblesRequestReturnsOkCode(){
        steps.biblesRequestReturns200StatusCode(steps.getTokenFromAuth(email, password));
    }
}
