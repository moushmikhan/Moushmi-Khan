package com.N26.api.utilities;

import com.N26.api.cons.ApiMethods;
import com.morningstar.automation.base.core.utils.Logger;
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseOptions;
import io.restassured.specification.RequestSpecification;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilderUtil {

	private RequestSpecBuilder builder = new RequestSpecBuilder();
	private String apiMethod;
	private String url;

	
	
	public RequestBuilderUtil(String url, String apiMethod) {
		
		this.url = url;
		this.apiMethod = apiMethod;
		Map<String,String> header = getBffAuthenticationHeaders();


//		if (header != null)
			builder.addHeaders(header);



		
		
		
	}

	public static Map<String, String> getBffAuthenticationHeaders() {
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept-Encoding", "gzip, deflate");
		headers.put("Content-Type", "application/x-www-form-urlencoded");
		headers.put("Content-Type", " application/json");
		return headers;
	}
	
	private ResponseOptions<Response> executeAPI(){
		
		RequestSpecification requestSpecification = builder.build().log().all();
		RequestSpecification request = RestAssured.given().urlEncodingEnabled(false);
		request.spec(requestSpecification);
		
		if (this.apiMethod.equalsIgnoreCase(ApiMethods.POST)) {
			System.out.println("Request is POST request");
			return request.post(this.url);
		} else if (this.apiMethod.equalsIgnoreCase(ApiMethods.GET)) {
			System.out.println("Request is GET request");
			return request.get(this.url);
		} else if (this.apiMethod.equalsIgnoreCase(ApiMethods.PUT)) {
			System.out.println("Request is PUT request");
			return request.put(this.url);
		} else if (this.apiMethod.equalsIgnoreCase(ApiMethods.DELETE)) {
			System.out.println("Request is DELETE request");
			return request.delete(this.url);
		}
		
		return null;
	}
	
	
	public ResponseOptions<Response> Execute() {
		return executeAPI();
	}
	
	
	public ResponseOptions<Response> ExecuteWithQueryParam(Map<String, String> queryParams) {
		builder.addQueryParams(queryParams);
		return executeAPI();
	}
	
	
	public ResponseOptions<Response> ExecuteWithPathParam(Map<String, String> pathParams) {
		builder.addParams(pathParams);
		return executeAPI();
	}
	
	
	public ResponseOptions<Response> ExecuteWithBody(Map<String, String> body) {
		builder.setBody(body);
		return executeAPI();
	}
	
	
	public ResponseOptions<Response> ExecuteWithBody(String body) {
		builder.setBody(body);
		return executeAPI();
	}


	public ResponseOptions<Response> ExecuteWithQueryParamAndBody(Map<String, String> queryParams,Map<String, String> body) {
		builder.setBody(body);
		builder.addQueryParams(queryParams);
		return executeAPI();
	}


	public ResponseOptions<Response> ExecuteWithQueryParamAndBody(Map<String, String> queryParams, String body) {
		builder.setBody(body);
		builder.addQueryParams(queryParams);
		return executeAPI();
	}
	

	public RequestSpecBuilder getRequestBuilder() {
		return builder;
	}
	
	public ResponseOptions<Response> ExecuteWithBasicAuthentication(String username, String password) {
		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName(username);
		auth.setPassword(password);
		builder.setAuth(auth);
		return executeAPI();
	}


}
