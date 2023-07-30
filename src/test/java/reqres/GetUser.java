package reqres;
import static io.restassured.RestAssured.*;
//static import is used to import all static members of a class. Hence, we can access all static members without className

public class GetUser 
{

	public static void main(String[] args) 
	{
		baseURI = "https://reqres.in";

		//Step 1: Create the required data
		
		
		//Step 2: Send the request and validate the response(using method chaining)
		given().pathParam("userId", 2)
		.when().get("/api/users/{userId}")
		.then().assertThat().statusCode(200).log().all();
		
	}
}
