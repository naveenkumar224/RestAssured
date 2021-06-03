package week3_assignment_chaining;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class GetTicket extends BaseClass {

	@Test(dependsOnMethods = "week3_assignment_chaining.UpdateTicket.Update")
	public void search() {
		RestAssured.given().contentType(ContentType.JSON).log().all().get(ticket_id);

	}

}
