package week3.day1;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateChange_File {

	@DataProvider(name = "GetData")
	public String[] FileData() {
		String[] data = new String[2];
		data[0] = "./data/Createchange1.json";
		data[1] = "./data/Createchange2.json";
		return data;

	}

	@Test(dataProvider = "GetData")
	public void CreateChange(String path) {
		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response = RestAssured.given().contentType(ContentType.JSON).body(new File(path)).post();
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

}
