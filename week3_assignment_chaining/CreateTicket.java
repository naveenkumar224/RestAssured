package week3_assignment_chaining;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateTicket extends BaseClass {

	@Test
	public void create() {
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(new File("./data/CreateIssueJira.json")).when().log().all().post();
		JsonPath jsonPath = response.jsonPath();
		ticket_id = jsonPath.get("id");
		System.out.println(ticket_id);

	}

}
