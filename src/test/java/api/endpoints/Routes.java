package api.endpoints;

public class Routes {
//Swagger URL - https://petstore.swagger.io
	//Create user -https://petstore.swagger.io/v2/user
	//get user - https://petstore.swagger.io/v2/user/{username}
	//update url -https://petstore.swagger.io/v2/user/{username}
	//Delete url - https://petstore.swagger.io/v2/user/{username}
		
	public static String base_url = "https://petstore.swagger.io/v2";
// user module - Routes - We are going to create routes for all request.
	
	public static String post_url = base_url+"/user";
	public static String get_url =base_url+"/user/{username}";
	public static String update_url =base_url+"/user/{username}";
	public static String delete_url = base_url+"/user/{username}";
	
	// Store module - Here you can create Store module URL's
	
	//Pet module - Here you will create Pet module URLs
	
	
}
