package MJacademy.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import MJacademy.abstractcomponent.Abstractcomponent;

public class Checkout extends Abstractcomponent {
	
	WebDriver driver;

	public Checkout(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
		
		@FindBy(css="input[placeholder='Select Country']")
		WebElement country;
		
		@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
		WebElement selectcountry;
		
		@FindBy(css=".action__submit")
		WebElement submit;
		
		By results = By.cssSelector(".ta-results");
		
	
		public void checkoutaction(String Countryname)
		{
			 Actions a = new Actions(driver);
			 a.sendKeys(country, Countryname).build().perform();
			 waitforelement(results);
			 //wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
			 selectcountry.click();
		}
	
             public confirmationpage submitorder()
             {
            	 submit.click();
            	return new confirmationpage(driver);
             }
}
