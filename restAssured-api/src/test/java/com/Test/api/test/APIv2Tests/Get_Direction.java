package com.Test.api.test.APIv2Tests;



import com.Test.api.cons.ApiMethods;

import com.Test.api.endpoints.APIv2Endpoints;
import com.Test.api.utilities.AssertionUtils;
import com.Test.api.utilities.RequestBuilderUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.Map;



public class Get_Direction {
	SoftAssert softAssert = new SoftAssert();




	@org.testng.annotations.Test(groups = {"APIv3"})
	public void GetDirection_ValidRequest()  {

		//Form the url
		String url = APIv2Endpoints.BaseUrl + APIv2Endpoints.Direction +"?api_key=&start=8.681495&end=8.687872,49.420318";

		//Adding querry Param
		Map<String,String> querryParam = new HashMap<String,String>();
		querryParam.put("api_key", APIv2Endpoints.apiKey);
		querryParam.put("start", "8.681495, 47.326512");
		querryParam.put("end", "8.687872,49.420318");


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.GET);
		ResponseOptions<Response> response = request.ExecuteWithQueryParam(querryParam);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		//Verify the response
		JsonPath jsonPath = new JsonPath(response.body().asString());
		String type = jsonPath.get("type");
		softAssert.assertTrue(type.contains("FeatureCollection"),"type is null");
		softAssert.assertTrue(type!=null,"type is null");

		softAssert.assertAll();

	}



}