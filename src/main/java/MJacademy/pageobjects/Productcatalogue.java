package MJacademy.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import MJacademy.abstractcomponent.Abstractcomponent;

public class Productcatalogue extends Abstractcomponent {

	WebDriver driver;

	// Creating constructor for initialization
	public Productcatalogue(WebDriver driver) {
		
		super (driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this );

	}
	
	@FindBy(xpath="//div[contains(@class,'mb-3')]")
	List<WebElement> products;
	
	@FindBy(css=".ng-animating")
	WebElement Animation;
	
	 By products1 =  By.xpath("//div[contains(@class,'mb-3')]");
	 By addtocart = By.xpath(".//div[@class='card-body']/button[2]");
	 By toastmessage = By.cssSelector("#toast-container");
	
	public List<WebElement> getproductslist()
	{
		waitforelement(products1);
		return products;
	}
	
	public WebElement Getproductbyname(String productname)
	
	{
		WebElement prod = getproductslist().stream().filter(Product->
		Product.findElement(By.xpath(".//div[@class='card-body']//b")).getText().equals(productname)).findFirst().orElse(null);        
		return prod;
	}
	
              public void addtocart(String productname)
              {
            	WebElement prod =  Getproductbyname(productname);
            	prod.findElement(addtocart).click();
            	waitforelement(toastmessage);
            	waitforinvisibilityofele(Animation);
              }
}
