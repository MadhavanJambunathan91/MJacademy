package MJacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MJacademy.abstractcomponent.Abstractcomponent;

public class cartpage extends Abstractcomponent {
      WebDriver driver;
	public cartpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".cart h3")
	List<WebElement> cartpdts;
	
	@FindBy (css=".subtotal button")
	WebElement checkoutp;
	
	//Boolean match = cartpdts.stream().anyMatch(cartitems->cartitems.getText().equalsIgnoreCase(productname));
    public Boolean producttitles(String productname) {
    	Boolean match = cartpdts.stream().anyMatch(cartitems->cartitems.getText().equalsIgnoreCase(productname));
     return	match;
    }
    
    public Checkout gotocheckout()
    {
    	checkoutp.click();
    	return new Checkout(driver);
    }

}
