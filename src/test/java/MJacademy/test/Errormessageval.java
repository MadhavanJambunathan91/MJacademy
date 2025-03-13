package MJacademy.test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import MJacademy.Testcomponents.Basetest;
import MJacademy.pageobjects.Checkout;
import MJacademy.pageobjects.Productcatalogue;
import MJacademy.pageobjects.cartpage;
import MJacademy.pageobjects.confirmationpage;

public class Errormessageval extends Basetest {

	@Test(groups = {"Errormessage"},retryAnalyzer= MJacademy.Testcomponents.Retry.class)
	public void loginerrval() throws IOException {
		// TODO Auto-generated method stub
		      firstpage.loginaction("madhavan916@gmail.com","Test@54321");
		     Assert.assertEquals(firstpage.loginerrormessagevalidation(),"Incorrect email or password."); 
	}
		       
		     @Test
		 	public void producterrval() {
		 		// TODO Auto-generated method stub
		 		String productname = "IPHONE 13 PRO";
		 		      Productcatalogue productcatalogue = firstpage.loginaction("madhavan915@gmail.com","Test@54321");
		 		       List <WebElement>  products =   productcatalogue.getproductslist();
		 		        productcatalogue.addtocart(productname);
		 		        cartpage cartitemcount = productcatalogue.gotocart();
		 		      Boolean match = cartitemcount.producttitles("IPHONE 13 PRO");
		 		         Assert.assertTrue(match);
		 		         //Assert.assertFalse(match);
		 		         
		 	}    
	}


