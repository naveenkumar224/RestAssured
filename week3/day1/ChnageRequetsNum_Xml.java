package week3.day1;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ChnageRequetsNum_Xml {

	@Test
	public void ChangeRequestxml() {

		RestAssured.baseURI = "https://dev116483.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Welcome@123");
		Response response = RestAssured.given().accept(ContentType.XML).get();
		System.out.println(response.statusCode());

		XmlPath xml = response.xmlPath();
		List<String> Change_num = xml.getList("response.result.number");
		System.out.println(Change_num.size());
		for (String temp2 : Change_num) {
			System.out.println(temp2);
		}

	}

}
