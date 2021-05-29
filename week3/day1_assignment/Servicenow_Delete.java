package week3.day1_assignment;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class Servicenow_Delete {

	@BeforeMethod
	public void Create_withoutbody() {

		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.delete("6fe7616f1b543010889ac991604bcb66");
		System.out.println(response.statusCode());

	}

	@Test
	public void DeleteValidation() {
		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response1 = RestAssured.get("6fe7616f1b543010889ac991604bcb66");
		System.out.println(response1.statusCode());
		System.out.println(response1.prettyPrint());

	}

}
