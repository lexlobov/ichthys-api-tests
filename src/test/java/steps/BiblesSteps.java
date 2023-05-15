package steps;

import clients.BiblesClient;
import com.google.gson.reflect.TypeToken;
import models.bibles.Bible;
import models.bibles.Verse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
public class BiblesSteps extends BaseSteps{

    BiblesClient client = new BiblesClient();

    public  void searchedTextIsInTopFiveResults(String token, String  lang, String requestText, Verse expectedVerse){
        //Type bibles = new TypeToken<ArrayList<Bible>>() {}.getType();
        List<Bible> bibleObjects = client.getBibles(getToken())
                .log().all()
                .extract().body().jsonPath().getList("", Bible.class);

        String bibleId = bibleObjects.stream()
                .filter(bible -> bible.getLanguage().equals(lang))
                .findAny()
                .get()
                .getId();
        Type searchAnswers = new TypeToken<ArrayList<Verse>>() {}.getType();
        List<Verse> searchResults = client.search(getToken(), bibleId, requestText).extract().as(searchAnswers);
        List<Verse> topFiveSearchResults = searchResults.stream().limit(5).toList();

        assertThat("Searched text should be in first 5 results", topFiveSearchResults.stream().anyMatch(r->r.equals(expectedVerse)));


    }
}
