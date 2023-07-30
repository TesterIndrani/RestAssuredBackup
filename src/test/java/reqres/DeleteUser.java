package reqres;
import static io.restassured.RestAssured.*;

public class DeleteUser {

	public static void main(String[] args) {
		baseURI = "https://reqres.in";

		//Step 1: Create the required data
		
		
		//Step 2: Send the request and validate the response(using method chaining)
		given().pathParam("userId", 2)
		.when().delete("/api/users/{userId}")
		.then().assertThat().statusCode(204).log().all();
	}

}
