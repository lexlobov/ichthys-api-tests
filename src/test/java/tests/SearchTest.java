package tests;

import models.bibles.Verse;
import org.junit.jupiter.api.Test;
import steps.BiblesSteps;

public class SearchTest extends BaseTest {


    Verse expectedVerse = Verse.builder().verseNumber(3).bookNumber(1).chapterNumber(1).text("Да будет свет").build();
    BiblesSteps steps = new BiblesSteps();

    @Test
    public void searchedTextIsInFirstFiveSearchResults(){
        steps.searchedTextIsInTopFiveResults(steps.getTokenFromAuth(email, password),"ru", expectedVerse.getText(), expectedVerse);
    }
}
