package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class BaseSpec {

    private final String JSON = "application/json";
    protected final String baseUrl = "https://bvs-api.issart.com";

    protected RequestSpecification baseSpec(){
        return new RequestSpecBuilder()
                .setContentType(JSON)
                .setBaseUri(baseUrl)
                .build();
    }
}
