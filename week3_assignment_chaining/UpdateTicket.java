package week3_assignment_chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class UpdateTicket extends BaseClass {

	@Test(dependsOnMethods = "week3_assignment_chaining.CreateTicket.create")
	public void Update() {
		RestAssured.given().contentType(ContentType.JSON)
				.body("{ \"fields\": { \"description\": \"Bug creation Using REST API for testing\" } }").when().log()
				.all().post(ticket_id);

	}

}
