package com.N26.api.utilities;

import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import org.junit.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;


public class AssertionUtils {



	public static void statusCodeValidation(ResponseOptions<Response> response, String expectedStatusCode, String url, SoftAssert softAssert) {

			int eStatuscode = Integer.parseInt(expectedStatusCode);
			int aStatuscode = response.getStatusCode();

			softAssert.assertEquals(aStatuscode, eStatuscode,
					"Status Code verification failed. Actual:: " + aStatuscode
							+ " Expected:: " + eStatuscode + "for URL "+ url);
			softAssert.assertAll();

		}




	public static void IterateList(List<Object> tagvalue, String ExpectedtagValue) {
		for (int i = 0; i < tagvalue.size(); i++) {
			String ActualValue = tagvalue.get(i).toString();
			Assert.assertTrue(ExpectedtagValue.equals(ActualValue));
			Assert.assertTrue(ActualValue!=null);


		}
	}


}


