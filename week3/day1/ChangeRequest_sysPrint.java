package week3.day1;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ChangeRequest_sysPrint {

	@Test
	public void ChangeRequest() {

		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response = RestAssured.get();
		System.out.println(response.statusCode());
		JsonPath json = response.jsonPath();
		List<String> sysid = json.getList("result.sys_id");
		List<String> description = json.getList("result.description");
		for (String temp1 : description) {
			System.out.println(temp1);
		}
		for (String temp2 : sysid) {
			System.out.println(temp2);
		}

	}

}
