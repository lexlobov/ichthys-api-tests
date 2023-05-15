package clients;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static org.hamcrest.Matchers.lessThan;

public class BaseSpec {

    protected final String baseUrl = "https://bvs-api.issart.com";

    protected RequestSpecification baseSpec(){
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(baseUrl)
                .build();
    }

    protected ResponseSpecification responseSpec(){
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectResponseTime(lessThan(5000l))
                .build();
    }

}
