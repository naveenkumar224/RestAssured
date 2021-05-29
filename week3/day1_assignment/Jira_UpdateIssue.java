package week3.day1_assignment;

import java.io.File;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Jira_UpdateIssue {

	@BeforeMethod
	public void UpdateIssue() {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(new File("./data/UpdateJiraTicket.json")).put("RA-5900");
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());

	}

	@Test
	public void UpdateValidation() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");
		Response response = RestAssured.given().contentType(ContentType.JSON).get("16012");
		JsonPath jsonPath = response.jsonPath();
		Object descr = jsonPath.get("fields.description");
		Object summary = jsonPath.get("fields.summary");
		System.out.println(descr);
		System.out.println(summary);

	}

}
