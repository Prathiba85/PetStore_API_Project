package api.endpoints;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import api.payload.User;
import io.restassured.response.Response;


import io.restassured.http.ContentType;

//This is userEndPoints.java file 
//This file is created for CRUD Operations - Create ,Read ,update and Delete requests to the user API.
//We will call end points in test methods and validate in test methods
public class UserEndPoints {
	
	public static Response createUser(User Payload, String user)
	{
		//What type of data you are sending in given will be given in swagger documents
	Response response= given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.body(Payload)
		.when()
		.post(Routes.post_url);
		
		return response;
		
		
	}
	
	public static Response readUser(String username)
	{
		//What type of data you are sending in given will be given in swagger documents
	Response response= given()
		.pathParam("username",username)
		.when()
		.get(Routes.get_url);
	//System.out.println("*******************");
	//System.out.println(Routes.get_url);
		return response;
		
		
	}

	public static Response updateUser(User Payload, String username)
	{
		//What type of data you are sending in given will be given in swagger documents
	Response response= given()
		.contentType(ContentType.JSON)
		.accept(ContentType.JSON)
		.pathParam("username", username)
		.body(Payload)
		.when()
		.put(Routes.update_url);
		return response;
		
	}
	
	public static Response deleteUser(String username)
	{
		//What type of data you are sending in given will be given in swagger documents
	Response response= given()
		.pathParam("username",username)
		.when()
		.delete(Routes.delete_url);
		return response;
			
	}
	
	
	
}
