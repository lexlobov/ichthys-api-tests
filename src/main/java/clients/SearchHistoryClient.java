package clients;

import io.restassured.response.ValidatableResponse;
import models.search_history.SearchResult;

import static io.restassured.RestAssured.given;

public class SearchHistoryClient extends BaseSpec{


    private final String URI = "/api/v1/searchHistory";

    private ValidatableResponse getSearchHistory(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI)
                .then();
    }

    private SearchResult getSearchHistoryModel(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI)
                .body().as(SearchResult.class);
    }

    private ValidatableResponse getSearchHistoryMy(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI + "/my")
                .then();
    }

    private SearchResult getSearchHistoryMyModel(String token){
        return given().spec(baseSpec())
                .header("Authorization", String.format("Bearer %s", token))
                .get(baseUrl + URI + "/my")
                .body().as(SearchResult.class);
    }
}
