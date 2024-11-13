package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import methods.Methods;
import io.cucumber.java.en.Then;

public class ContactUsStepDefinition extends Methods {

	@Given("^user navigates to the site <url>$")
	public void user_navigates_to_the_site(String url) {
		navigateToURL(url);
		clickCookieButtons("Accept all");
	}

	@When("^user selects country <country>$")
	public void user_selects_country(String country) {
		clickCountry(country);
	}

	@Then("^verify city <city> contact <contact_type> information <info>$")
	public void validate_login(String city, String type, String info) {
		verifyAddress(city, type, info);
	}

}
