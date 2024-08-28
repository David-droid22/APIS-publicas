package test.APIPublic;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetSingleObject{
	@org.testng.annotations.Parameters({"id","expectedStatusCode"})
    @Test
    public void getSingleObject(String id,int expectedStatusCode){
        RequestSpecification request = given().baseUri("https://api.restful-api.dev").basePath("/objects");

        Response response = request.when().get(id);

        response.prettyPrint();
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode,expectedStatusCode);

        JSONObject jsonResponse = new JSONObject(response.asString());
        String name = jsonResponse.getString("name");
        System.out.println(name);
        
        JSONObject jsonData = jsonResponse.getJSONObject("data");
        String cpuModel = jsonData.getString("color");
        System.out.println(cpuModel);
    }
}
