package api.test;

import static io.restassured.RestAssured.given;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.Routes;
import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class User_Tests {
	Faker fs;
	User userPayload;
	String username;
	String firstName;
	String lastName;
	String email;
	String password;
	String phone;
	int userStatus =0;
	
	@BeforeClass
	public void setupData()
	{
		fs = new Faker();
		userPayload = new User();
		userPayload.setId(fs.idNumber().hashCode()); 
		userPayload.setUsername(fs.name().username());
		userPayload.setFirstName(fs.name().firstName());
		userPayload.setLastName(fs.name().lastName());
		userPayload.setEmail(fs.internet().safeEmailAddress());
		userPayload.setPassword(fs.internet().password(5, 10));
		userPayload.setPhone(fs.phoneNumber().cellPhone());

		
	}
	
	@Test (priority =1)
	public void TC01_testPostUser()
	{
		Response response = UserEndPoints.createUser(userPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test (priority =2)
	public void TC02testGetUserByname()
	
	{
		String user = this.userPayload.getUsername();
		Response response = UserEndPoints.readUser(user);
		System.out.println("***********************************");
		System.out.println(user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(),200);
	}
	
	@Test (priority =3)
	public void TC03_testUpdateUser()
	{
		userPayload.setFirstName(fs.name().firstName());
		userPayload.setLastName(fs.name().lastName());
		userPayload.setEmail(fs.internet().safeEmailAddress());
		String user = this.userPayload.getUsername();
		Response response = UserEndPoints.updateUser(userPayload, user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//check the data after updates
		
		Response responseafterupdate= given()
				.pathParam("username",user)
				.when()
				.get(Routes.get_url);
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
	}
	@Test (priority =4)
	public void TC004_DeleteUserByName()
	{
		String user = this.userPayload.getUsername();
		Response response = UserEndPoints.deleteUser(user);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	}



