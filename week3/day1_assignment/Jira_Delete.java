package week3.day1_assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Jira_Delete {

	@Test
	public void DeleteIssue() {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(new File("./data/CreateIssueJira.json")).delete("16013");
		System.out.println(response.getStatusCode());

	}

}
