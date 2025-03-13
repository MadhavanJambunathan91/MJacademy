package MJacademy.abstractcomponent;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import MJacademy.pageobjects.Orderhistory;
import MJacademy.pageobjects.cartpage;

public class Abstractcomponent {
    
	WebDriver driver;
	public Abstractcomponent(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css="[routerlink*=cart]")
	WebElement cartlink;
	
	@FindBy (css="[routerlink*=myorders]")
	WebElement myorders;
	
	
	public void waitforelement(By findby)
	{
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public cartpage gotocart() 
	{
		cartlink.click();
		cartpage cartitemcount = new cartpage(driver);
    	return cartitemcount;
	}
	
	public Orderhistory gotomyorders() 
	{
		myorders.click();
		Orderhistory orderedpdt = new Orderhistory(driver);
    	return orderedpdt;
	}
	
	public void visibilityofWebelement(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findby));
	}
	
	public void waitforinvisibilityofele(WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(ele));
	}
}
