package test.APIPublic;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateBody {
	File putBody = new File("src/main/resources/updateObject.json");
	@Test
	public void updateObjects() {
		RequestSpecification request = given().baseUri("https://api.restful-api.dev").basePath("/objects")
				.header("Content-Type", "application/json").body(putBody);

		Response response = request.when().put();

		response.prettyPrint();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
