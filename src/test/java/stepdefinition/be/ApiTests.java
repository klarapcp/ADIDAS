package stepdefinition.be;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.remote.http.HttpRequest;
import org.openqa.selenium.remote.http.HttpMethod;
import org.openqa.selenium.remote.http.HttpClient;
import org.openqa.selenium.remote.http.HttpResponse;

import com.google.gson.Gson;

import be.adidas.cedeno.klara.data.Pet;

import static org.junit.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

public class ApiTests {

	private Long responseWithProvidedStatusQuantity;
	private Long responseQuantity;
	
	@Given("I an existing and valid status")
	public void i_an_existing_and_valid_status() {
		// I would add an end point to get all possible status.
	}

	@When("I make a GET request by {string} status")
	public void i_make_a_get_request_by_status(String status) throws MalformedURLException {
//		Documentation: https://medium.com/@dkscodes/invoking-http-requests-from-selenium-using-httpclient-85c5e3a5a16f
		HttpRequest request = new HttpRequest(HttpMethod.GET, "/pet/findByStatus?status=available");

		URL url = new URL("https://petstore.swagger.io/v2");
		HttpClient client = HttpClient.Factory.createDefault().createClient(url);
		try {
			HttpResponse response = client.execute(request);

//			Json to java Object. Example: https://stackoverflow.com/questions/1688099/converting-json-data-to-java-object
			Pet[] pets = new Gson().fromJson(response.getContentString(), Pet[].class);
			List<Pet> petList = Arrays.asList(pets);
			responseWithProvidedStatusQuantity = petList.stream().filter(p -> p.getStatus().equalsIgnoreCase(status)).count();
			responseQuantity = Long.valueOf(petList.size());
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("I get as result a list of pets with {string} status for all of them")
	public void i_get_as_result_a_list_of_pets_with_status_for_all_of_them(String string) {
		// Write code here that turns the phrase above into concrete actions
		assertEquals(responseWithProvidedStatusQuantity, responseQuantity);
	}

}
