package week3.day1_assignment;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Servicenow_Update_Patch {

	@Test
	public void Create_withoutbody() {

		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response = RestAssured.given().contentType(ContentType.JSON)
				.body(new File("./data/Update_ShortDescription.json")).patch("9794a9ab1b543010889ac991604bcb57");
		System.out.println(response.statusCode());
		// System.out.println(response.prettyPrint());
		JsonPath jsonPath = response.jsonPath();
		Object SD = jsonPath.get("result.short_description");
		Object number = jsonPath.get("result.number");
		System.out.println(SD);
		System.out.println(number);

	}

}
