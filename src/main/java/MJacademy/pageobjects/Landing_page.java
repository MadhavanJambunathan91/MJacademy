package MJacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MJacademy.abstractcomponent.Abstractcomponent;

//Constructer:

/*
 1. Constructer gives connection for Webdriver
 2. Constructer will always have same as class name where it created
 */

public class Landing_page extends Abstractcomponent {

	WebDriver driver;

	// Creating constructor for initialization
	public Landing_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this );

	}

	//WebElement Usermail = driver.findElement(By.id("userEmail"));
	
	// We can define webelements using pagefactory method
	
	@FindBy(id="userEmail")
	WebElement Usermail;
	
	@FindBy(id="userPassword")
	WebElement Userpassword;
	
	@FindBy(css="input[type ='submit']")
	WebElement Submit;
	
	//.ng-tns-c4-8.ng-star-inserted.ng-trigger.ng-trigger-flyInOut.ngx-toastr.toast-error
	
	@FindBy(xpath = "//div[@aria-label='Incorrect email or password.']")
	WebElement Loginerrormessage;
	
	
	public Productcatalogue loginaction(String email, String password)
	
	{
		Usermail.sendKeys(email);
		Userpassword.sendKeys(password);
		Submit.click();
		Productcatalogue productcatalogue = new Productcatalogue(driver);
		return productcatalogue;
	}
	
	public String loginerrormessagevalidation()
	{
		visibilityofWebelement(Loginerrormessage);
		return Loginerrormessage.getText();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	

}
