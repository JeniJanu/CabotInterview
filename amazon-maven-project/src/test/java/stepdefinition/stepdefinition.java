package stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import genericlibrary.Webdriverutils;

public class stepdefinition {
	Webdriverutils utilsweb = new Webdriverutils ();
	
		@Given("^Launch the \"([^\"]*)\" with  \"([^\"]*)\"$")
		public void launch_the_browser_with_url(String url, String browser) throws Exception{
			utilsweb.getDriver(false, browser).get(url);
			System.out.format("URL: \n", url);
			}
		@When("user searches a \"([^\"]*)\" product")
		public void user_searches_a_product(String product) {
			System.out.format("Product \n", product);
			}
		/*@And("User clicks buynow")
		public void user_clicks_buynow{
			System.out.format("Buynow \n", buynow);
		}
		@Then("user click make payment")
		public void user_click_makepayment{
			System.out.format("Makepayment \n", makepayment);
		}*/


}

