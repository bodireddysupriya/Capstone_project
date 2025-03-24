package pages;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;

import base.BaseClass;
import objects.AddToCartObjects;
import screenshot.Capture;
public class AddToCartPage extends BaseClass {

    static AddToCartObjects obj;

    public static void selectSize(String size) {
    	logger1.log(Status.INFO, "Selection of size");
        try {
            obj = new AddToCartObjects(); //Initialize object
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.sizeOptions));
            
            //Loop for Size options to find a match
            for (WebElement sizeOption : obj.sizeOptions) {
                if (sizeOption.getText().equalsIgnoreCase(size)) {
                    sizeOption.click();
                    System.out.println("Selected size: " + size);
                    logger1.log(Status.PASS, "Size is selected");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in selectSize: " + e);
            logger1.log(Status.FAIL, "Size is not selected");
        }
    }

    public static void selectColor(String color) {
    	logger1.log(Status.INFO, "Selection of color");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfAllElements(obj.colorOptions));
            
            //Loop for colour options to find a match
            for (WebElement colorOption : obj.colorOptions) {
                if (colorOption.getDomAttribute("option-label").equalsIgnoreCase(color)) {
                    colorOption.click();
                    System.out.println("Selected color: " + color);
                    logger1.log(Status.PASS, "Color is selected");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in selectColor: " + e);
            logger1.log(Status.FAIL, "Color");
        }
    }

    // ✅ Enter quantity
    public static void enterQuantity(String quantity) {
    	logger1.log(Status.INFO, "Selection of Quantity");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.quantityBox));
            
            // clear and enter the quantity
            obj.quantityBox.clear();
            obj.quantityBox.sendKeys(quantity);
            System.out.println("Entered quantity: " + quantity);
            logger1.log(Status.PASS, "Qantity is selected");
        } catch (Exception e) {
            System.out.println("Exception in enterQuantity: " + e);
            logger1.log(Status.FAIL, "Quantity is not selected");
        }
    }

    // clicks the Add to cart button
    public static void clickAddToCart() {
    	logger1.log(Status.INFO, "Items should be added to cart");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(obj.addToCartButton));
            obj.addToCartButton.click();
            System.out.println("Clicked on Add to Cart button");
            logger1.log(Status.PASS, "Cart icon is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickAddToCart: " + e);
            logger1.log(Status.FAIL, "Cart icon is not clicked");
        }
    }

    public static String getCartMessage() {
    	logger1.log(Status.INFO, "visited cart");
        try {
            obj = new AddToCartObjects();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.cartMessage));
            String message = obj.cartMessage.getText();
            logger1.addScreenCaptureFromPath(Capture.screenShot("Add to cart"));
            System.out.println("Cart message: " + message);
            logger1.log(Status.PASS, "Items added message");
            return message;
        } catch (Exception e) {
            System.out.println("Exception in getCartMessage: " + e);
            return null;
        }
    }
    public static String getCartAmount() {
    	//logger1 = extent.createTest("Cart Message after adding product");
		logger1.log(Status.INFO, "Cart Total amount");
        try {
            obj = new AddToCartObjects();
           // wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(obj.cartAmountElement));
            String message = obj.cartAmountElement.getText();
            logger1.addScreenCaptureFromPath(Capture.screenShot("Cart amount"));
            logger1.log(Status.PASS, "Amount is visible");
            
            System.out.println("Cart Amount: " + message);
            return message;
        } catch (Exception e) {	
            System.out.println("Exception in getCartAmount: " + e);
            logger1.log(Status.FAIL, "Amount is not visible");
            return null;
        }
        
    }
    /* 
	  * Method for clicking add to cart symbol
	 */ 
	  
    public static void clickCartSymbol() {
    //	logger1 = extent.createTest("Add to Cart Button Clicking");
		logger1.log(Status.INFO, "Cliking Add To Cart Symbol");
        try {
        	obj = new AddToCartObjects();
            wait.until(ExpectedConditions.elementToBeClickable(obj.cartSymbolElement));
            obj.cartSymbolElement.click();
            System.out.println("Clicked on Add to Cart Symbol");
            logger1.log(Status.PASS, "Cart Symbol clicked successfully");
        } catch (Exception e) {
        	logger1.log(Status.FAIL, "Clicking cart symbol failed");
            System.out.println("Exception in clickCartSymbol: " + e);
        }
      //  extent.flush();
    }
}