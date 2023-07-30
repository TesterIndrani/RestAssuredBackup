package reqres;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
//partial update using patch()

import io.restassured.http.ContentType;

public class UpdateUserUsingPatch {

	public static void main(String[] args) {

		baseURI = "https://reqres.in";

		//Step 1: Create the required data
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job","citizen");
		
		
		//Step 2: Send the request and validate the response(using method chaining)
		given().body(obj).contentType(ContentType.JSON).pathParam("userId", 2)
		.when().patch("/api/users/{userId}")
		.then().assertThat().statusCode(200).log().all();
	}

}
