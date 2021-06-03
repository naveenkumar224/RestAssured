package week3_assignment;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateMultipleIssues {

	@DataProvider(name = "FetchData")
	public String[] multi_data() {
		String[] data = new String[2];
		data[0] = "./data/CreateIssueJira.json";
		data[1] = "./data/CreateIssueJira2.json";
		return data;

	}

	@Test(dataProvider = "FetchData")
	public void multiple_issue(String path) {

		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");
		Response response = RestAssured.given().contentType(ContentType.JSON).body(new File(path)).post();
		response.prettyPrint();

	}

}
