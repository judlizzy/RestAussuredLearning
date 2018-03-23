import org.testng.Assert;
import org.testng.annotations.Test;
import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class SimplePostTest {
	
	/*@Test
	public void RegistrationSuccessful()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");

		requestParams.put("Email",  "sample2ee26d9@gmail.com");
		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200); //expected 201
		String successCode = response.jsonPath().get("SuccessCode");
		Assert.assertEquals( "Correct Success code was returned", successCode, "OPERATION_SUCCESS");
	}*/
	
	@Test
	public void RegistrationSuccessful1()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "sdimpleuser2dd2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "sample2ee26d9@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.get("/register");

		int statusCode = response.getStatusCode();
		System.out.println("The status code recieved: " + statusCode);

		System.out.println("Response body: " + response.body().asString());
	}
	

	@Test
	public void RegistrationSuccessful2()
	{		
		RestAssured.baseURI ="http://restapi.demoqa.com/customer";
		RequestSpecification request = RestAssured.given();

		JSONObject requestParams = new JSONObject();
		requestParams.put("FirstName", "Virender"); // Cast
		requestParams.put("LastName", "Singh");
		requestParams.put("UserName", "63userf2d3d2011");
		requestParams.put("Password", "password1");	
		requestParams.put("Email",  "ed26dff39@gmail.com");

		request.body(requestParams.toJSONString());
		Response response = request.post("/register");

		ResponseBody body = response.getBody();
		System.out.println("Response :"+response.body().asString());

		if(response.statusCode() == 200)
		{
			System.out.println("Response message 200");
			// Deserialize the Response body into RegistrationFailureResponse
			
			/*//added from else
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			System.out.println("SuccessCode value: "+responseBody.SuccessCode);
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	*/
	
			/*//original
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			// Use the RegistrationFailureResponse class instance to Assert the values of 
			// Response.
			System.out.println("FaultId value: "+responseBody.FaultId);
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);	*/
		}
		else if (response.statusCode() == 201)
		{
			System.out.println("Response message is 201");
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of 
			// Response.
			System.out.println("SuccessCode value: "+responseBody.SuccessCode);
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);	
		}	
	} 

}


