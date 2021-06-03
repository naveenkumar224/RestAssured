package week3_assignment_chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class DeleteTicket extends BaseClass {

	@Test(dependsOnMethods = "week3_assignment_chaining.GetTicket.search")
	public void delete() {

		RestAssured.given().contentType(ContentType.JSON).when().log().all().delete(ticket_id);

	}

}
