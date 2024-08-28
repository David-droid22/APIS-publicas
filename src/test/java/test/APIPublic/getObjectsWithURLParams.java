package test.APIPublic;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getObjectsWithURLParams {
    @Test
    public void getSingleObject(){
        RequestSpecification request = given()
        		.baseUri("https://api.restful-api.dev")
        		.basePath("/objects")
        		.formParam("id", 1)
        		.formParam("id", 2);

        Response response = request.when().get();

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,200);


    }
}
