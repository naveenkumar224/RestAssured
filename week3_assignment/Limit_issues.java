package week3_assignment;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Limit_issues {

	@Test
	public void LimitingJiraIssues() {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/search";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");
		Response response = RestAssured.given().contentType(ContentType.JSON).log().all()
				.queryParam("jql", "project=\"RA\"").queryParam("maxResults", "20").get();
		// response.prettyPrint();
		JsonPath jsonPath = response.jsonPath();
		List<String> Count_Issues = jsonPath.getList("issues.id");
		System.out.println("The Total Count of issues present in the Reponse : " + Count_Issues.size());
		for (String Issue_id : Count_Issues) {
			System.out.println(Issue_id);

		}

	}

}
