package week3.day1_assignment;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Servicenow_Change_create {

	@Test
	public void Create_withoutbody() {

		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response = RestAssured.given().contentType(ContentType.JSON).post();
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		JsonPath jsonPath = response.jsonPath();
		Object CA_Num = jsonPath.get("result.number");
		System.out.println(CA_Num);

	}

}
