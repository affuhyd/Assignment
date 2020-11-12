package test.java.TestCases;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.Base.TestBase;
import main.java.Utilities.TestUtils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UploadCSV_TC extends TestBase {
	RequestSpecification requestSpecification;
	Response response;
	public UploadCSV_TC() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
	}

	@Test
	public void uploadCSVTest() {
		requestSpecification = given().multiPart("file", new File(TestUtils.filePath_CSV));
		response = requestSpecification.log().all().expect().statusCode(TestUtils.STATUSCODE_OK).when()
				.post(TestUtils.uploadcsvAPI);
		System.out.println("****************");
		System.out.println(response.asString());
		System.out.println(response.getStatusCode());
		Assert.assertEquals(response.getStatusCode(), TestUtils.STATUSCODE_OK);
	}

}
