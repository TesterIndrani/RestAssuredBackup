package Petstore;
import static io.restassured.RestAssured.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RequestChaining {

	public static void main(String[] args) throws FileNotFoundException {

		baseURI = "https://petstore.swagger.io/v2";
		
		 //Step 1: Create a post request-PetStore
	FileInputStream fis = new FileInputStream("./src/test/resources/petstore.json");  //give the file path after project name
		
		 Response resp = given().body(fis).contentType(ContentType.JSON)
						.when().post("/store/order");
		
		 //Step 2: Capture the data from response
		 	//resp.then().log().all();
		 	int value = resp.jsonPath().get("id");	
		 	//the JSON path need not be ".id" because Eclipse by default starts from inside the object
		 	System.out.println(value);		
		 	
		 	
		//Step 3: provide it as input to GET request
		 	/*Response resp2 = get("/store/order/"+value);	
		 	//Here, we are using get() method of RestAssured class and not of RequestSender Interface
		 	resp2.then().log().all();
 			*/
		 	
		 	given().pathParam("orderId", value)
		 	.when().get("/store/order/{orderId}")
		 	.then().log().all();
		 	
	}

}
