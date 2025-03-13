package MJacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MJacademy.abstractcomponent.Abstractcomponent;

public class Orderhistory extends Abstractcomponent {

	WebDriver driver;
	
	public Orderhistory(WebDriver driver) {
			super(driver);
			// TODO Auto-generated constructor stub
			this.driver = driver;
			PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy (css="tr td:nth-child(3)")
	List<WebElement> orderdetails;
		
		public Boolean orderdetails(String productname) {
	    	Boolean match = orderdetails.stream().anyMatch(cartitems->cartitems.getText().equalsIgnoreCase(productname));
	     return	match;
	    }
	}


