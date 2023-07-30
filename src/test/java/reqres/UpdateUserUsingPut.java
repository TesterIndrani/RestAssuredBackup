package reqres;
import static io.restassured.RestAssured.*;
import org.json.simple.JSONObject;
//complete update using put()

import io.restassured.http.ContentType;

public class UpdateUserUsingPut {

	public static void main(String[] args) {

		baseURI = "https://reqres.in";

		//Step 1: Create the required data
		JSONObject obj = new JSONObject();
		obj.put("name", "morpheus");
		obj.put("job","zion resident");
		
		
		//Step 2: Send the request and validate the response(using method chaining)
		given().body(obj).contentType(ContentType.JSON).pathParam("userId", 2)
		.when().put("/api/users/{userId}")
		.then().assertThat().statusCode(200).log().all();
	}

}
