package org.verizon.CustomerServiceProvider;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertTrue;
public class CatalogStepDefinition {
	

	public class CatalogStepDefinitions {

	    private Response response;
		private String requestBody;

	    @When("I send a GET request to {string}")
	    public void sendGetRequest(String endpoint) {
	        response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .get(endpoint);
	    }

	    @Then("the response status code should be {int}")
	    public void checkResponseStatusCode(int expectedStatusCode) {
	        int actualStatusCode = response.getStatusCode();
	        assertEquals(expectedStatusCode, actualStatusCode);
	    }

	    @Then("the response should contain a list of products/plans/features")
	    public void checkResponseBody() {
	        // You can add code here to parse the response body and verify its content
	        // For example, using JSON parsing libraries like Jackson or Gson
	        // and performing assertions on the content
	    }

	    @Given("the request body contains product/plan/feature details")
	    public void setRequestBody() {
	        // You can create the request body here to be used in the subsequent steps
	    }

	    @When("I send a POST request to {string}")
	    public void sendPostRequest(String endpoint) {
	       
			response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	            .post(endpoint);
	    }

	    @Then("the response status code should be 201")
	    public void checkPostResponseStatusCode() {
	        assertEquals(201, response.getStatusCode());
	    }

	    @Then("the response should contain the newly added product/plan/feature details")
	    public void checkPostResponseBody() {
	        // You can add code here to parse the response body and verify its content
	        // For example, using JSON parsing libraries like Jackson or Gson
	        // and performing assertions on the content
	    }

	    @When("I send a PUT request to {string}")
	    public void sendPutRequest(String endpoint) {
	       
			response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .body(requestBody)
	            .put(endpoint);
	    }

	    @Then("the response should contain the updated product/plan/feature details")
	    public void checkPutResponseBody() {
	        // You can add code here to parse the response body and verify its content
	        // For example, using JSON parsing libraries like Jackson or Gson
	        // and performing assertions on the content
	    }

	    @When("I send a DELETE request to {string}")
	    public void sendDeleteRequest(String endpoint) {
	        response = RestAssured.given()
	            .contentType(ContentType.JSON)
	            .delete(endpoint);
	    }

	    @Then("the response status code should be 204")
	    public void checkDeleteResponseStatusCode() {
	        assertEquals(204, response.getStatusCode());
	    }
	}

}
