package com.N26.api.test.APIv3Tests;


import com.N26.api.cons.ApiMethods;
import com.N26.api.endpoints.APIv3Endpoints;
import com.N26.api.utilities.AssertionUtils;
import com.N26.api.utilities.RequestBuilderUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.asserts.SoftAssert;


public class Delete_Pet {
	SoftAssert softAssert = new SoftAssert();


	@org.testng.annotations.Test(groups = {"APIv3"})
	public void Delete_PetById()  {


		//Form the url
		String url = APIv3Endpoints.BaseUrl + APIv3Endpoints.Endpoint+"/910";


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.DELETE);
		ResponseOptions<Response> response = request.Execute();

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "200", url, softAssert);


		softAssert.assertAll();

	}


}