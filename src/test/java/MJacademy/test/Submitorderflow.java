package MJacademy.test;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import MJacademy.Testcomponents.Basetest;
import MJacademy.pageobjects.Checkout;
import MJacademy.pageobjects.Landing_page;
import MJacademy.pageobjects.Orderhistory;
import MJacademy.pageobjects.Productcatalogue;
import MJacademy.pageobjects.cartpage;
import MJacademy.pageobjects.confirmationpage;

public class Submitorderflow extends Basetest {
	
	//public WebDriver driver;

	String productname = "ADIDAS ORIGINAL";

	@Test
	public void submitorder() throws IOException {
		// TODO Auto-generated method stub
		Productcatalogue productcatalogue = firstpage.loginaction("madhavan915@gmail.com", "Test@54321");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> products = productcatalogue.getproductslist();
		productcatalogue.addtocart(productname);
		cartpage cartitemcount = productcatalogue.gotocart();
		Boolean match = cartitemcount.producttitles(productname);
		Assert.assertTrue(match);
		Checkout payment = cartitemcount.gotocheckout();
		payment.checkoutaction("India");
		confirmationpage lastpage = payment.submitorder();
		String Conmessage = lastpage.getconfirmationmessage();
		Assert.assertTrue(Conmessage.equalsIgnoreCase("Thankyou for the order."));

	}

	@Test(dependsOnMethods = { "submitorder" })
	public void Orderhistroy() {

		Productcatalogue productcatalogue = firstpage.loginaction("madhavan915@gmail.com", "Test@54321");
		Orderhistory orderedpdt = productcatalogue.gotomyorders();
		Assert.assertTrue(orderedpdt.orderdetails(productname));
	}

}
