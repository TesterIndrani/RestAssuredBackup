package reqres;
import org.json.simple.JSONObject;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
//static import is used to import all static members of a class. Hence, we can access all static members without className

public class CreateUser {

	public static void main(String[] args) {
	
		//Step 1: Create the required data
		JSONObject obj = new JSONObject();
		obj.put("name", "Indrani");
		obj.put("job","Automation Tester");
		
		//Step 2: Send the request (using method chaining)
		Response resp = given().body(obj).contentType(ContentType.JSON)		
		.when().post("https://reqres.in/api/users");		
		
		//Step 3: Validate the response
		resp.then().assertThat().statusCode(201).log().all();
		System.out.println("PASS");
}
}
