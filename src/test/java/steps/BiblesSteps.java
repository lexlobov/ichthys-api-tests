package steps;

import clients.BiblesClient;
import models.bibles.Bible;
import models.bibles.Verse;

import java.util.List;

import static org.apache.http.HttpStatus.SC_OK;
import static org.hamcrest.MatcherAssert.assertThat;
public class BiblesSteps extends BaseSteps{

    BiblesClient client = new BiblesClient();

    public  void searchedTextIsInTopFiveResults(String token, String  lang, String requestText, Verse expectedVerse){
        //Получаем bibleId для выбранного языка
        String bibleId = getBibleId(token, lang);
        //Получам первые 5 реузльтатов поиска
        List<Verse> topFiveSearchResults = client.search(token, bibleId, requestText)
                .extract().body().jsonPath().getList("", Verse.class).stream().limit(5).toList();

        assertThat("Searched text should be in first 5 results", topFiveSearchResults.stream().anyMatch(r->r.equals(expectedVerse)));
    }

    public void searchRequestReturns200StatusCode(String token, String  lang, String requestText){
        String bibleId = getBibleId(token, lang);
        assertThat("Status code should be 200", client.search(token, bibleId, requestText).extract().statusCode()==SC_OK);
    }

    public void biblesRequestReturns200StatusCode(String token){
        assertThat("Status code should be 200", client.getBibles(token).extract().statusCode()==SC_OK);
    }

    public void biblesRequestContains3Bibles(String token){
        List<Bible> bibles = client.getBiblesModel(token);
        assertThat("Should be 3 bible objects", bibles.size()==3);
    }

    public void biblesRequestReturnsDeEnRuBibles(String token){
        List<Bible> bibles = client.getBiblesModel(token);
        assertThat("Should be English version", bibles.stream().anyMatch(bible -> bible.getLanguage().equals("en")));
        assertThat("Should be German version", bibles.stream().anyMatch(bible -> bible.getLanguage().equals("de")));
        assertThat("Should be Russian version", bibles.stream().anyMatch(bible -> bible.getLanguage().equals("ru")));
    }

    public String getBibleId(String token,String lang){
        List<Bible> bibleObjects = client.getBibles(token)
                .log().status().log().headers()
                .extract().body().jsonPath().getList("", Bible.class);
        return bibleObjects.stream()
                .filter(bible -> bible.getLanguage().equals(lang))
                .findAny()
                .get()
                .getId();
    }
}
