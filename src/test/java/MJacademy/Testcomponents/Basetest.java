package MJacademy.Testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import MJacademy.pageobjects.Landing_page;

public class Basetest {
	
	/*
	    1. This basetest will always have information that is required for any test on project.Eg : initialize driver
	    2. So in order to driver to initialize and which browser you want to execute that needs to be come from "Global properties"
	    3. In java we have properties class that is used to get global properties.
	    4. Global data file should be created with .file extention.
	 */
	
	public  WebDriver driver;
	
	public Landing_page firstpage;
	
	public WebDriver Driverinitialize() throws IOException 
	{
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") +"\\src\\main\\java\\MJacademy\\resources\\Globaldata.properties");
		prop.load(fis);
		
		//Below browser setup done via java ternary opearator
		
		String browsername =   System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		
		 // prop.getProperty("browser");
		if (browsername.contains("chrome"))
		{
			// In order to run code in Headless mode we need to use Chromeoptions
			ChromeOptions options = new ChromeOptions();
			if (browsername.contains("headless")) {
				options.addArguments("--headless");
				driver = new ChromeDriver(options);  
			}
			//driver.manage().window().setSize(new Dimension (1440, 900)); // To run in full screen for headless
		 driver = new ChromeDriver(options);   
		}
		
		else if (browsername.equalsIgnoreCase("Firefox"))
		{
			 driver = new FirefoxDriver();   
		}
		else if (browsername.equalsIgnoreCase("Edge"))
		{
			 driver = new EdgeDriver();   
		}
		
		driver.manage().window().maximize();
	      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	      return driver;
	}
	
	//Below method created to call data sets from json file
public List<HashMap<String, String>> getjsondatatomap(String filepath) throws IOException {
		
		//Reading data from json as String
	
		String json =	FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8 );
		
		//Convert the sting to hash by using external dependency called "Jackson-databind'
		
		ObjectMapper mapper = new ObjectMapper();
		
		List<HashMap<String,String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>(){}); 
		return data; 
	}

//Taking screenshots

public String getscreenshot(String testcasename, WebDriver driver) throws IOException {
	
	TakesScreenshot ts =	(TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	    File file = new File(System.getProperty("user.dir") + "//reports" + testcasename + ".png");
	FileUtils.copyFile(source, file);
	 return System.getProperty("user.dir") + "//reports" + testcasename + ".png";
		
	}

	@BeforeMethod (alwaysRun=true)
	public Landing_page launchapplication() throws IOException
	{
		 //driver = Driverinitialize();
		  //firstpage = new Landing_page(driver);
		 //firstpage.goTo();
	     //return firstpage;
		
		
		   driver = Driverinitialize();
		    if (driver != null) {
		    	firstpage = new Landing_page(driver);
		    	firstpage.goTo();
		    	return firstpage;
		    }
		    // Handle the case when driver initialization fails
		    return null;
		
	}
	
	@AfterMethod (alwaysRun=true)
	public void closebrowser()
	
	{
		driver.quit();;
	}

}
