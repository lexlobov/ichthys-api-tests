package steps;

import clients.BiblesClient;
import models.bibles.Bible;
import models.bibles.Verse;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
public class BiblesSteps extends BaseSteps{

    BiblesClient client = new BiblesClient();

    public  void searchedTextIsInTopFiveResults(String token, String  lang, String requestText, Verse expectedVerse){
        //Получаем список библий
        List<Bible> bibleObjects = client.getBibles(token)
                .log().status().log().headers()
                .extract().body().jsonPath().getList("", Bible.class);
        //Получаем bibleId для выбранного языка
        String bibleId = bibleObjects.stream()
                .filter(bible -> bible.getLanguage().equals(lang))
                .findAny()
                .get()
                .getId();
        //Получам первые 5 реузльтатов поиска
        List<Verse> topFiveSearchResults = client.search(token, bibleId, requestText)
                .extract().body().jsonPath().getList("", Verse.class).stream().limit(5).toList();

        assertThat("Searched text should be in first 5 results", topFiveSearchResults.stream().anyMatch(r->r.equals(expectedVerse)));
    }
}
