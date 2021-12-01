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


public class Get_Elevation {
	SoftAssert softAssert = new SoftAssert();




	@org.testng.annotations.Test(groups = {"APIv3"})
	public void GetElevation_2XXResponse()  {

		//Form the url
		String url = APIv2Endpoints.BaseUrl + APIv2Endpoints.Elevation ;

		//Adding querry Param
		Map<String,String> querryParam = new HashMap<String,String>();
		querryParam.put("api_key", APIv2Endpoints.apiKey);
		querryParam.put("geometry", "13.349762,38.11295");
		querryParam.put("format_out", "point");


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.GET);
		ResponseOptions<Response> response = request.ExecuteWithQueryParam(querryParam);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		//Verify the response
		JsonPath jsonPath = new JsonPath(response.body().asString());
		String Doc_Count = jsonPath.get("attribution");
		Doc_Count.equals("service by https://openrouteservice.org | data by http://srtm.csi.cgiar.org");
		softAssert.assertTrue(Doc_Count!=null,"type is null");

		softAssert.assertAll();

	}

	@org.testng.annotations.Test(groups = {"APIv3"})
	public void GetElevation_InvalidQueryParameter_5XXError()  {

		//Form the url
		String url = APIv2Endpoints.BaseUrl + APIv2Endpoints.Elevation ;

		//Adding querry Param
		Map<String,String> querryParam = new HashMap<String,String>();
		querryParam.put("api_key", APIv2Endpoints.apiKey);
		querryParam.put("geometry", ",38.11295");
		querryParam.put("format_out", "point");


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.GET);
		ResponseOptions<Response> response = request.ExecuteWithQueryParam(querryParam);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "500", url, softAssert);


		//Verify the response
		softAssert.assertTrue(response.body().asString().contains("{\"code\":4000,\"message\":\"ValueError: ,38.11295 is not a comma separated list of long, lat\"}"),"Error message is different");


		softAssert.assertAll();

	}

}