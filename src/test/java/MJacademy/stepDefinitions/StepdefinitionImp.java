package MJacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import MJacademy.Testcomponents.Basetest;
import MJacademy.pageobjects.Checkout;
import MJacademy.pageobjects.Landing_page;
import MJacademy.pageobjects.Productcatalogue;
import MJacademy.pageobjects.cartpage;
import MJacademy.pageobjects.confirmationpage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepdefinitionImp extends Basetest {
	
	public Landing_page firstpage;
	public Productcatalogue productcatalogue;
	public confirmationpage lastpage;
	
	@Given ("I landed on ecommerce page")
	public void I_landed_on_ecommerce_page () throws IOException {
		
		firstpage=launchapplication();
	}
		
	@Given("i login with {string} and {string}")
	public void logged_in_using_madhavan915_gmail_com_and_password_test(String name, String password) {
	    productcatalogue = firstpage.loginaction(name, password);
	    
	}
	
	/* @Given("^Logged in using name (.+) and password (.+) $")
	 
	 //"^Logged in using name (.+) and password (.+) $"
	 
	 public void Logged_using_name_and_password (String name, String password) throws IOException { 
		 
		 productcatalogue = firstpage.loginaction(name, password);
		 
	 }*/
	 
	@When ("I add the {string} in cart")
	 
	// "^I add products to cart productname (.+) to cart.$"
	 
	 public void i_add_the_adidas_original_in_cart (String productname) {
		 
		List<WebElement> products = productcatalogue.getproductslist();
		productcatalogue.addtocart(productname);
		
			
	 }
	 
	 @When ("checkout {string} and submit order")
	 
	 //"^And In checkout verify productname (.+) and submit the order.$"
	 
	  public void checkout_submit_order (String productname)  {
		 
		  cartpage cartitemcount = productcatalogue.gotocart();
			Boolean match = cartitemcount.producttitles(productname);
			Assert.assertTrue(match);
			Checkout payment = cartitemcount.gotocheckout();
			payment.checkoutaction("India");
			 lastpage = payment.submitorder();	 
			 
	 }
	 	 
	 @Then("I verify the {string}")
	 
	 public void message_displayed_on_confirmation_page (String string) {
		 
			String Conmessage = lastpage.getconfirmationmessage();
			Assert.assertTrue(Conmessage.equalsIgnoreCase("Thankyou for the order."));
	 }
}
