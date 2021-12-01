package com.Test.api.test.APIv2Tests;


import com.Test.api.cons.ApiMethods;
import com.Test.api.endpoints.APIv2Endpoints;
import com.Test.api.utilities.AssertionUtils;
import com.Test.api.utilities.RequestBuilderUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.asserts.SoftAssert;


public class DeleteDirection {
	SoftAssert softAssert = new SoftAssert();


	@org.testng.annotations.Test(groups = {"APIv3"})
	public void DeleteDirection_405Error()  {


		//Form the url
		String url = APIv2Endpoints.BaseUrl + APIv2Endpoints.Direction +"/910";


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.DELETE);
		ResponseOptions<Response> response = request.Execute();

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "405", url, softAssert);


		softAssert.assertAll();

	}


}