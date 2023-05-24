package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.BiblesSteps;

public class BiblesTest extends BaseTest{

    BiblesSteps steps = new BiblesSteps();

    @Test
    @DisplayName("Список библий должен состоять из 3")
    public void shouldBe3BiblesTest(){
        steps.biblesRequestContains3Bibles(steps.getTokenFromAuth(email, password));
    }
    @Test
    @DisplayName("Должно быть 3 доступных языка для библий")
    public void shouldBe3languagesOfBibles(){
        steps.biblesRequestReturnsDeEnRuBibles(steps.getTokenFromAuth(email, password));
    }

    @Test
    @DisplayName("Запрос библий возвращает 200 код")
    public void biblesRequestReturnsOkCode(){
        steps.biblesRequestReturns200StatusCode(steps.getTokenFromAuth(email, password));
    }
}
