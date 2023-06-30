package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;
import api.utilities.*;

public class DDTests {
	
	@Test (priority =1, dataProvider= "Data",dataProviderClass=DataProviders.class)
	public void TC01_testPostUser(String userID,String userName,String fname,String lname,String useremail,String password,String phonenumber)
	{
		User userPayload = new User();
		
		userPayload.setId(Integer.parseInt(userID)); 
		userPayload.setUsername(userName);
		userPayload.setFirstName(fname);
		userPayload.setLastName(lname);
		userPayload.setEmail(useremail);
		userPayload.setPassword(password);
		userPayload.setPhone(phonenumber);

		Response response = UserEndPoints.createUser(userPayload, userName);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	
	@Test (priority =2, dataProvider= "UserNames",dataProviderClass=DataProviders.class)
	public void TC02_testPostUser(String username)
	{
		Response response = UserEndPoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}
}
