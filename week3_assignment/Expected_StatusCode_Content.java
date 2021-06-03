package week3_assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class Expected_StatusCode_Content {

	@Test
	public void Status_Code() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");
		RestAssured.given().contentType(ContentType.JSON).queryParam("jql", "project=\"RA\"")
				.queryParam("maxResults", "20").when().log().all().get().then().statusCode(200)
				.contentType(ContentType.JSON).extract().response();
	}
}
