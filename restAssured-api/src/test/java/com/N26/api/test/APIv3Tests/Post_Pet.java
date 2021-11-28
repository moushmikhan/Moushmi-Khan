package com.N26.api.test.APIv3Tests;


import com.N26.api.cons.ApiMethods;
import com.N26.api.endpoints.APIv3Endpoints;
import com.N26.api.utilities.AssertionUtils;
import com.N26.api.utilities.RequestBuilderUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


public class Post_Pet {
	SoftAssert softAssert = new SoftAssert();

	@org.testng.annotations.Test(groups = {"APIv3"})
	public void Post_Pet()  {


		//Form the url
		String url = APIv3Endpoints.BaseUrl + APIv3Endpoints.Endpoint;

		//Response Body
		String Body = "{\n" +
				"  \"id\": 901,\n" +
				"  \"name\": \"bruno\",\n" +
				"  \"category\": {\n" +
				"    \"id\": 1,\n" +
				"    \"name\": \"Dogs\"\n" +
				"  },\n" +
				"  \"photoUrls\": [\n" +
				"    \"string\"\n" +
				"  ],\n" +
				"  \"tags\": [\n" +
				"    {\n" +
				"      \"id\": 0,\n" +
				"      \"name\": \"string\"\n" +
				"    }\n" +
				"  ],\n" +
				"  \"status\": \"available\"\n" +
				"}";


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.POST);
		ResponseOptions<Response> response = request.ExecuteWithBody(Body);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		//Verify the response
		Assert.assertTrue(response.body().prettyPrint().contains("bruno"));

		softAssert.assertAll();

	}


}