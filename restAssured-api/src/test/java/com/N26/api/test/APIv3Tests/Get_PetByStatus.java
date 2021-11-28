package com.N26.api.test.APIv3Tests;



import com.N26.api.cons.ApiMethods;

import com.N26.api.endpoints.APIv3Endpoints;
import com.N26.api.utilities.AssertionUtils;
import com.N26.api.utilities.RequestBuilderUtil;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;

import org.testng.asserts.SoftAssert;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class Get_PetByStatus {
	SoftAssert softAssert = new SoftAssert();




	@org.testng.annotations.Test(groups = {"APIv3"})
	public void GetPetByStatus_Pending()  {

		//Form the url
		String url = APIv3Endpoints.BaseUrl + APIv3Endpoints.Endpoint +"/findByStatus";

		//Adding querry Param
		Map<String,String> querryParam = new HashMap<String,String>();
		querryParam.put("status", "pending");


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.GET);
		ResponseOptions<Response> response = request.ExecuteWithQueryParam(querryParam);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		//Verify the response
		JsonPath jsonPath = new JsonPath(response.body().asString());
		List<Object> Doc_Count = jsonPath.getList("status");
		AssertionUtils.IterateList(Doc_Count,"pending");

		softAssert.assertAll();

	}

	@org.testng.annotations.Test(groups = {"APIv3"})
	public void GetPetByStatus_Sold()  {

		//Form the url
		String url = APIv3Endpoints.BaseUrl + APIv3Endpoints.Endpoint +"/findByStatus";

		//Adding querry Param
		Map<String,String> querryParam = new HashMap<String,String>();
		querryParam.put("status", "sold");


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.GET);
		ResponseOptions<Response> response = request.ExecuteWithQueryParam(querryParam);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		//Verify the response
		JsonPath jsonPath = new JsonPath(response.body().asString());
		List<Object> Doc_Count = jsonPath.getList("status");
		AssertionUtils.IterateList(Doc_Count,"sold");

		softAssert.assertAll();

	}

	@org.testng.annotations.Test(groups = {"APIv3"})
	public void GetPetByStatus_Available()  {

		//Form the url
		String url = APIv3Endpoints.BaseUrl + APIv3Endpoints.Endpoint +"/findByStatus";

		//Adding querry Param
		Map<String,String> querryParam = new HashMap<String,String>();
		querryParam.put("status", "available");


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.GET);
		ResponseOptions<Response> response = request.ExecuteWithQueryParam(querryParam);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		//Verify the response
		JsonPath jsonPath = new JsonPath(response.body().asString());
		List<Object> Doc_Count = jsonPath.getList("status");
		AssertionUtils.IterateList(Doc_Count,"available");

		softAssert.assertAll();

	}

}