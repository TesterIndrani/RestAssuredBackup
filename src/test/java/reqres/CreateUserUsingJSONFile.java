package reqres;
import static io.restassured.RestAssured.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import io.restassured.http.ContentType;


public class CreateUserUsingJSONFile {

	public static void main(String[] args) throws FileNotFoundException  {

		baseURI = "https://reqres.in";
		
		//Step 1: Create required data
		FileInputStream fis = new FileInputStream("./src/test/resources/data.json");  //give the file path after project name
		
		
		//Step 2: send the request and validate the response
		given().body(fis).contentType(ContentType.JSON)		//choose body() argument as InputStream
		.when().post("/api/users")				//can choose post() argument as URI/URL
		.then().assertThat().statusCode(201).log().all();
		
	}

}
