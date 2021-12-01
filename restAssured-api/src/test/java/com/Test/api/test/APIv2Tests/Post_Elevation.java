package com.Test.api.test.APIv2Tests;


import com.Test.api.cons.ApiMethods;
import com.Test.api.endpoints.APIv2Endpoints;
import com.Test.api.utilities.AssertionUtils;
import com.Test.api.utilities.RequestBuilderUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.testng.asserts.SoftAssert;


public class Post_Elevation {
	SoftAssert softAssert = new SoftAssert();


	@org.testng.annotations.Test(groups = {"APIv3"})
	public void Put_Elevation_405MethodNotAllowed()  {


		//Form the url
		String url = APIv2Endpoints.BaseUrl + APIv2Endpoints.Direction;

		//Response Body
		//Response Body
		String Body = "{\"coordinates\":[[8.681495,49.49960],[8.686507,49.41943],[8.687872,49.420318]]}";


		//Make the RestAssured call
		RequestBuilderUtil request = new RequestBuilderUtil(url, ApiMethods.PUT);
		ResponseOptions<Response> response = request.ExecuteWithBody(Body);

		//Status Code Assertion
		AssertionUtils.statusCodeValidation(response, "405", url, softAssert);



	}


}