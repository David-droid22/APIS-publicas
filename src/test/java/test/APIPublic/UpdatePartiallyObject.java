package test.APIPublic;

import static io.restassured.RestAssured.given;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdatePartiallyObject {
	File putBody = new File("src/main/resources/updatePartiallyObject.json");
	@Test
	public void updateObjects() {
		RequestSpecification request = given().baseUri("https://api.restful-api.dev").basePath("/objects")
				.header("Content-Type", "application/json").body(putBody);

		Response response = request.when().patch("/ff8081819071bec7019084a3427825ab");

		response.prettyPrint();
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
}
