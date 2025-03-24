package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import base.BaseClass;
import objects.MyAccountObject;
import screenshot.Capture;
public class MyAccount extends BaseClass {

    static MyAccountObject obj;

    // ✅ Get Registration Confirmation Text
    public static String getRegistrationText() throws Exception {
        String text = null;
        try {
            obj = new MyAccountObject();
            wait.until(ExpectedConditions.visibilityOf(obj.RegistrationTextElement));
            logger1.addScreenCaptureFromPath(Capture.screenShot("RegistrationText"));
            text = obj.RegistrationTextElement.getText();
        } catch (Exception e) {
            System.out.println("Exception in getRegistrationText: " + e.getMessage());
        }
        return text;
    }

    // ✅ Get My Account Page Text
    public static String getMyAccountText() {
        String text = null;
        try {
            obj = new MyAccountObject();
            wait.until(ExpectedConditions.visibilityOf(obj.myAccountTextElement));
            text = obj.myAccountTextElement.getText();
        } catch (Exception e) {
            System.out.println("Exception in getMyAccountText: " + e.getMessage());
        }
        return text;
    }

    // ✅ Enter Search Query in the Search Box
    public static void enterSearchQuery(String searchQuery) {
        try {
            obj = new MyAccountObject();
//            Thread.sleep(4000);
            wait.until(ExpectedConditions.visibilityOf(obj.searchBoxElement));
            obj.searchBoxElement.clear();
            obj.searchBoxElement.sendKeys(searchQuery);
            System.out.println("Entered search query: " + searchQuery);
        } catch (Exception e) {
            System.out.println("Exception in enterSearchQuery: " + e.getMessage());
        }
    }
    public static void selectSuggestion(String suggestion) {
        try {
//        	Thread.sleep(4000);
			wait.until(ExpectedConditions.visibilityOfAllElements(obj.searchList));
			for(WebElement e : obj.searchList) {
				System.out.println(e.getText());
				if(e.getText().contains(suggestion))
				{
					logger1.addScreenCaptureFromPath(Capture.screenShot("suggestion"));
					e.click();
					break;
					
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}