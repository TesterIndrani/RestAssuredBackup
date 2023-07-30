package Petstore;
import static io.restassured.RestAssured.*;

public class DeleteUser {

	public static void main(String[] args) {
		
		baseURI = "https://petstore.swagger.io/v2";
		
		//Step 1: Create the required data
		
		
		//Step 2: Send the request and validate the response(using method chaining)
		delete("/store/order/{orderId}")
		.then().log().all();
	}

}
