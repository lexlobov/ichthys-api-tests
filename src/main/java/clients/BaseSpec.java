package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseSpec {

    protected final String baseUrl = "https://bvs-api.issart.com";

    protected RequestSpecification baseSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .build();
    }

}
