package MJacademy.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MJacademy.abstractcomponent.Abstractcomponent;

public class confirmationpage extends Abstractcomponent {
	
	WebDriver driver;
	public confirmationpage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".hero-primary")
	WebElement thankyoumessage;
	
	public String getconfirmationmessage()
	{
		return 	thankyoumessage.getText();
	}

}
