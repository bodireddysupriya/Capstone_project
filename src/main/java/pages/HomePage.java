package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import base.BaseClass;
import objects.HomePageObjects;
import screenshot.Capture;

public class HomePage extends BaseClass {

	static HomePageObjects obj;

	public static void clickOnSignIn() throws Exception {
		logger1.addScreenCaptureFromPath(Capture.screenShot("Click on signin"));
		try {
			obj = new HomePageObjects();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(obj.signinLink));
			obj.signinLink.click();
			System.out.println("Clicked on Sign In link");
			logger1.log(Status.PASS, "Signin is clicked");
		} catch (Exception e) {
			System.out.println("Exception in clickOnSignIn method: " + e);
			logger1.log(Status.FAIL, "Signin is not clicked");
		}
	}

	public static void clickOnCreateNewAccount() {
		try {
			obj = new HomePageObjects();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(obj.createNewAccountLink));
			obj.createNewAccountLink.click();
			System.out.println("Clicked on Create New Account link");
			logger1.log(Status.PASS, "Create new account is clicked");
		} catch (Exception e) {
			System.out.println("Exception in clickOnCreateNewAccount method: " + e);
			logger1.log(Status.FAIL, "Didnot click create new account");
		}
	}

	public static String getHomePageText() {
		try {
			obj = new HomePageObjects();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(obj.homepageText));
			String text = obj.homepageText.getText();
			System.out.println("Homepage text: " + text);
			logger1.log(Status.PASS, "Homepage is seen");
			return text;
		} catch (Exception e) {
			System.out.println("Exception in getHomePageText method: " + e);
			logger1.log(Status.FAIL, "Homepage is not seen");
			return null;
		}
	}
	public static void clickCartIcon() {
		logger1.log(Status.INFO, "Clicking on carticon");
		try
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//header/div[2]/div[1]/a/span[2]/span[1]")));
			obj.cartIcon.click();
			logger1.log(Status.PASS, "Clickng on Carticon");
		}
		catch(Exception e)
		{
			System.out.println("HomePage - While clicking on cart icon");
			logger1.log(Status.FAIL, "Failed Clickng on Carticon");
		}
		extent.flush();
	}
	public static boolean totalprice() {
		logger1=extent.createTest("Verify total price displayed or not");
		logger1.log(Status.INFO, "Verify Total Price");
		try {
			wait.until(ExpectedConditions.visibilityOf(obj.totalPrice));
			logger1.log(Status.PASS, "Verified Total Price Displayed");
		}catch(Exception e) {
			System.out.println("HomePage - While Verifying totalprice");
			logger1.log(Status.FAIL, "Failed Verifying Total Price");
		}
		return obj.totalPrice.isDisplayed();
	}
	/*
	 * Method for dynamically deleting data from the cart
	 */
	public static void deleteingCartData() {
	    obj = new HomePageObjects();
	    if (js == null) {
	        js = (JavascriptExecutor) driver; // Ensure js is initialized
	    }

	    logger1.log(Status.INFO, "Dynamically deleting products from cart");
	    try {  
	        if (obj.counterElement.isEmpty()) {
	            return;
	        }

	        wait.until(ExpectedConditions.elementToBeClickable(obj.counterElement.get(0)));
	        obj.cartIcon.click();

	        while (true) {
	            List<WebElement> cartItems = obj.cartList;
	            if (cartItems.isEmpty()) {
	                break;
	            }

	            WebElement firstItem = cartItems.get(0);
	            wait.until(ExpectedConditions.visibilityOf(firstItem));
	            js.executeScript("arguments[0].click()", firstItem); // No more NullPointerException

	            wait.until(ExpectedConditions.elementToBeClickable(obj.popUpAcceptElement));
	            js.executeScript("arguments[0].click()", obj.popUpAcceptElement);

	            if (cartItems.size() == 1) {
	                wait.until(ExpectedConditions.elementToBeClickable(obj.closingButtonElement));
	                js.executeScript("arguments[0].click()", obj.closingButtonElement);
	                break;
	            }

	            wait.until(ExpectedConditions.stalenessOf(firstItem));
	        }
	        logger1.log(Status.PASS, "Successfully deleted the products from cart");

	    } catch (Exception e) {
	        logger1.log(Status.FAIL, "Error in deleting products from cart: " + e);
	        System.out.println("Exception in deleteingCartData method: " + e);
	    }
	}



}
