package MJacademy.test;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MJacademy.Testcomponents.Basetest;
import MJacademy.pageobjects.Checkout;
import MJacademy.pageobjects.Landing_page;
import MJacademy.pageobjects.Orderhistory;
import MJacademy.pageobjects.Productcatalogue;
import MJacademy.pageobjects.cartpage;
import MJacademy.pageobjects.confirmationpage;

public class Submitorder_using_dataprovider_json extends Basetest {

	String productname = "Banarsi Saree";
	@Test (dataProvider = "getdata", groups = {"purchase"})
	public void submitorder(HashMap<String,String> input) throws IOException {
		// TODO Auto-generated method stub
		      Productcatalogue productcatalogue = firstpage.loginaction(input.get("username"),input.get("Password"));
		       List <WebElement>  products =   productcatalogue.getproductslist();
		        productcatalogue.addtocart(input.get("productname"));
		        cartpage cartitemcount = productcatalogue.gotocart();
		      Boolean match = cartitemcount.producttitles(input.get("productname"));
		         Assert.assertTrue(match);
		         Checkout payment = cartitemcount.gotocheckout();
		         payment.checkoutaction("India");
		         confirmationpage lastpage = payment.submitorder();
		         String  Conmessage =  lastpage.getconfirmationmessage();
		         Assert.assertTrue(Conmessage.equalsIgnoreCase("Thankyou for the order."));
              
	}
	
	//Taking screenshot and attached to extend reports
	
	@Test(dependsOnMethods= {"submitorder"})
	public void Orderhistroy() {
		
		Productcatalogue productcatalogue = firstpage.loginaction("madhavan915@gmail.com","Test@54321");
		Orderhistory orderedpdt=productcatalogue.gotomyorders();
		Assert.assertTrue(orderedpdt.orderdetails(productname));
	}
	   @DataProvider
	public Object[][] getdata() throws IOException {
		    
		 List<HashMap<String,String>> data  = getjsondatatomap(System.getProperty("user.dir")+ "\\src\\test\\java\\MJacademy\\data\\Purchaseorder.json");
		   
		   return  new Object [] [] {{data.get(0)}, {data.get(1)} };
		   
	   }
		   
//		   HashMap<String,String> maps = new HashMap<String,String>();
//		   
//		   maps.put("username","madhavan915@gmail.com");
//		   maps.put("Password","Test@54321");
//		   maps.put("productname", "ZARA COAT 3");
//		   
//		   HashMap<String,String> maps1 = new HashMap<String,String>();
//		   
//		   maps1.put("username", "vojep73224@pokeline.com");
//		   maps1.put("Password","Test@54321");
//		   maps1.put("productname", "ADIDAS ORIGINAL");
		 //return  new Object [] [] {{"madhavan915@gmail.com","Test@54321","ZARA COAT 3"}, {"vojep73224@pokeline.com","Test@54321","ADIDAS ORIGINAL"} };
		   
	   

}
