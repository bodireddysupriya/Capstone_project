package base;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	 public static WebDriver driver;
	    public static WebElement element;
	    public static WebDriverWait wait;
	    public static Actions act;
	    public static Select select;
	    public static JavascriptExecutor js;
	    public static ExtentReports extent;
		public static ExtentSparkReporter reporter;
		public static ExtentTest logger1;

	    //Method to initialize and lanch the broswer
	    public static void openBrowser() {
	    	logger1.log(Status.INFO, "opening the browser");
	        try {
	            String choice = Utility.properties("browser"); 
	            if (choice.equalsIgnoreCase("Chrome")) {
	                driver = new ChromeDriver();
	            } else if (choice.equalsIgnoreCase("Edge")) {
	                driver = new EdgeDriver();
	            } else {
	               // throw new IllegalArgumentException("Invalid browser type in properties file");
	                logger1.log(Status.PASS,"The browser has been opened successfully");

	            }
	            
	           //Explicit timeout of 20 seconds
	            wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	            // Implicit wait of 10 secs for locating elements
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	            driver.manage().window().maximize();

	           
	            act = new Actions(driver);

	            System.out.println(choice + " Browser launched successfully");
	            
	        } catch (Exception e) {
	        	logger1.log(Status.FAIL,"The browser has not been opened :"+e);
	            System.out.println("Browser - openBrowser: " + e.getMessage());
	        }
	    }
	    
	    //Method to navigate to the URL
	    public static void navigateToUrl(String string) {
	    	logger1.log(Status.INFO, "Navigating the url");
	        try {
	            String url = Utility.properties("url"); 
	            driver.get(url);
	            System.out.println("Navigated to: " + url);
	        } catch (Exception e) {
	            System.out.println("Browser - navigateToUrl: " + e.getMessage());
	        }
	    }
	    // Method to close browser
	    public static void closeBrowser() {
	    	logger1.log(Status.INFO, "Closing the browser");
	        try {
	            if (driver != null) {
	                driver.quit();
	                driver = null; 
	                System.out.println("Browser closed successfully");
	            }
	        } catch (Exception e) {
	            System.out.println("Browser - closeBrowser: " + e.getMessage());
	        }
	    }
	    public static void init (String reportName) {
			extent = new ExtentReports();
			reporter = new ExtentSparkReporter(System. getProperty("user.dir")+"//target//ExtentReports//"+reportName+".html");
			extent.attachReporter(reporter);
			}

}
