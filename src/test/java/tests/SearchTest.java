package tests;

import models.bibles.Verse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.BiblesSteps;

public class SearchTest extends BaseTest {


    Verse expectedVerse = Verse.builder().verseNumber(3).bookNumber(1).chapterNumber(1).text("Да будет свет").build();
    BiblesSteps steps = new BiblesSteps();

    @Test
    @DisplayName("Искомый текст должен быть в пяти верхних результатах поисковой выдачи")
    public void searchedTextIsInFirstFiveSearchResults(){
        steps.searchedTextIsInTopFiveResults(steps.getTokenFromAuth(email, password),"ru", expectedVerse.getText(), expectedVerse);
    }

    @Test
    @DisplayName("Поисковой запрос возвращает 200 код")
    public void searchRequestReturns200(){
        steps.searchRequestReturns200StatusCode(steps.getTokenFromAuth(email, password), "ru", expectedVerse.getText());
    }
}
