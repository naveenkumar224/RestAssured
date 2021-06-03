package week3_assignment_chaining;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;

public class BaseClass {

	public static String ticket_id;

	@BeforeMethod
	public void precondition() {
		RestAssured.baseURI = "https://api-may2020.atlassian.net/rest/api/2/issue/";
		RestAssured.authentication = RestAssured.preemptive().basic("Hari.radhakrishnan@testleaf.com",
				"ODWNgjWGBWQ6PLeMtv2W4C66");

	}

}
