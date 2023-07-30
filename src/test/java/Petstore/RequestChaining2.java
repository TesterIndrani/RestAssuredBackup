package Petstore;
import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSender;
import io.restassured.specification.RequestSpecification;

public class RequestChaining2 {

	public static void main(String[] args) throws FileNotFoundException {
		baseURI = "https://petstore.swagger.io/v2";
		
		//Step 1: Create a post request-PetStore
	FileInputStream fis = new FileInputStream("./src/test/resources/petstore.json");  //give the file path after project name
		
		 Response resp = given().body(fis).contentType(ContentType.JSON)
						.when().post("/store/order");
		 				resp.then().log().all();
		
		 //Step 2: Capture the data from POST response
		 	//resp.then().log().all();
		 	int value = resp.jsonPath().get("id");	
		 	//the JSON path need not be ".id" because Eclipse by default starts from inside the object
		 	System.out.println("id value in POST response = " + value);		
		 	
		 	
		//Step 3: provide it as input to GET request
		 	 Response resp2 = given().pathParam("orderId", value)
		 			 		 .when().get("/store/order/{orderId}");
		 			 		 resp2.then().log().all();
		 	
		
		//Step 4: Capture the data from GET response
		 	int value2 = resp2.jsonPath().get("id");	
		 	//the JSON path need not be ".id" because Eclipse by default starts from inside the object
		 	System.out.println("id value in GET response = " + value2);	
		 	
		 	
		//Step 5: Provide it as input for DELETE request
		 		Response resp3 = given().pathParam("orderId2", value2)
		 						.when().delete("/store/order/{orderId2}");
				    			resp3.then().log().all();
	}

}
