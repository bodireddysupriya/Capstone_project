package pages;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;

import java.time.Duration;
import java.util.List;

import base.BaseClass;
import objects.SignInObjects;
import screenshot.Capture;

public class SignInPage extends BaseClass {

    static SignInObjects obj;

    // Enters an invalid email into email field
    public static void enterInvalidEmail(String email) throws Exception {
    	logger1.addScreenCaptureFromPath(Capture.screenShot("SignIn"));
    	obj = new SignInObjects();
        try {
        	
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(email);
            logger1.log(Status.PASS, "Invalid email is given");
        } catch (Exception e) {
            System.out.println("Exception in enterInvalidEmail method: " + e);
        }
    }

 
    //Enter an invalid password into password field
    public static void enterInvalidPassword(String password) {
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.clear();
            obj.passwordElement.sendKeys(password);
            logger1.log(Status.PASS, "Valid Credentials are given");
        } catch (Exception e) {
            System.out.println("Exception in enterInvalidPassword method: " + e);
        }
    }

 
    // enters valid credentials (email & pass) into fields
    public static void enterValidCredentials(String email, String password) {
    	obj = new SignInObjects();
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.emailElement));
            obj.emailElement.clear();
            obj.emailElement.sendKeys(email); // ✅ Email from Excel

            wait.until(ExpectedConditions.visibilityOf(obj.passwordElement));
            obj.passwordElement.clear();
            obj.passwordElement.sendKeys(password); // ✅ Password from Excel
            logger1.log(Status.PASS, "Valid Credentials are given");
        } catch (Exception e) {
            System.out.println("Exception in enterValidCredentials method: " + e);
        }
    }

 
    // Click on the SignIn button
    public static void clickSignIn() {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(obj.signInElement));
            obj.signInElement.click();
            logger1.log(Status.PASS, "Signin button is clicked");
        } catch (Exception e) {
            System.out.println("Exception in clickSignIn method: " + e);
            logger1.log(Status.FAIL, "Couldnot click signin button");
        }
    }

 
    // Displays error message when login fails
    public static String getErrorMessage() {
        String errorMessage = null;
        try {
            wait.until(ExpectedConditions.visibilityOf(obj.errorElement));
            errorMessage = obj.errorElement.getText();
            logger1.log(Status.PASS, "Error message is given");
        } catch (Exception e) {
            System.out.println("Exception in getErrorMessage method: " + e);
            logger1.log(Status.FAIL, "Couldnot see any error messege");
        }
        return errorMessage;
    }
}
