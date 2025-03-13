package MJacademy.test;

import static org.testng.Assert.assertTrue;

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

import MJacademy.pageobjects.Landing_page;

public class Standalone_actualtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String productname = "ZARA COAT 3";
		WebDriver driver = new ChromeDriver();
		      driver.get("https://rahulshettyacademy.com/client");
		      driver.manage().window().maximize();
		      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		      Landing_page firstpage = new Landing_page(driver);
		      driver.findElement(By.id("userEmail")).sendKeys("madhavan915@gmail.com");
		      driver.findElement(By.id("userPassword")).sendKeys("Test@54321");
		      driver.findElement(By.cssSelector("input[type ='submit']")).click();
		      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		      wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	                          List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));   
WebElement prod = products.stream().filter(Product->Product.findElement(By.cssSelector("b")).getText().equals(productname)).findFirst().orElse(null);        
prod.findElement(By.cssSelector("div.card-body button:last-of-type")).click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
            wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
            driver.findElement(By.cssSelector("[routerlink*=cart]")).click();
            
               List<WebElement> cartpdts = driver.findElements(By.cssSelector(".cart h3"));
              Boolean match = cartpdts.stream().anyMatch(cartitems->cartitems.getText().equalsIgnoreCase(productname));
              Assert.assertTrue(match);
              driver.findElement(By.cssSelector(".subtotal button")).click();
              
              Actions a = new Actions(driver);
              	a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
                driver.findElement(By.xpath("(//button[contains(@class,'ta-item')])[2]")).click();
                driver.findElement(By.cssSelector(".action__submit")).click();
                
           String  Conmessage =    driver.findElement(By.cssSelector(".hero-primary")).getText();
            Assert.assertTrue(Conmessage.equalsIgnoreCase("Thankyou for the order."));
            driver.close();
              
	}

}
