package clients;

import com.google.gson.reflect.TypeToken;
import io.restassured.response.ValidatableResponse;
import models.bibles.Bible;
import models.bibles.Book;
import models.bibles.Verse;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class BiblesClient extends BaseSpec{

    private final String URI = "/api/v1/bibles";

    public ValidatableResponse getBibles(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI)
                .then();
    }

    public List<Bible> getBiblesModel(String token){
        Type bibles = new TypeToken<ArrayList<Bible>>() {}.getType();
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI)
                .body().as(bibles);
    }

    public Bible getBibleModel(String token, String bibleId){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .pathParam("id", bibleId)
                .get(baseUrl + URI + "/{id}" + "/books")
                .body().as(Bible.class);
    }

    public ValidatableResponse getBible(String token, String bibleId){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .pathParam("id", bibleId)
                .get(baseUrl + URI + "/{id}" + "/books")
                .then();
    }

    public Book getBookModel(String token, String bibleId, String bookId){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .pathParam("id", bibleId)
                .pathParam("bookId", bookId)
                .get(baseUrl + URI + "/{id}" + "/books")
                .body().as(Book.class);
    }

    public ValidatableResponse getBook(String token, String bibleId, String bookId){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .pathParam("id", bibleId)
                .pathParam("bookId", bookId)
                .get(baseUrl + URI + "/{id}" + "/books/" + "{bookId}")
                .then();
    }

    public ValidatableResponse search(String token, String bibleId, String text){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .pathParam("id", bibleId)
                .queryParam("text", text)
                .get(baseUrl + URI + "/{id}" + "/search")
                .then();
    }

    public List<Verse> searchModel(String token, String bibleId, String text){
        Type verses = new TypeToken<ArrayList<Verse>>() {}.getType();
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .pathParam("id", bibleId)
                .queryParam("text", text)
                .get(baseUrl + URI + "/{id}" + "/search")
                .body().as(verses);
    }




}
