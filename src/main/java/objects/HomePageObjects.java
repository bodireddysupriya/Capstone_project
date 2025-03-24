package objects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.BaseClass;

public class HomePageObjects extends BaseClass {

	// constructor
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}

//	public By signIn = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
//	public By createNewAccount = By.xpath("//div[@class='panel header']//a[normalize-space()='Create an Account']");
//	public By homepage = By.xpath("//span[@class='base']");
	

	@FindBy(xpath = "//div[@class='panel header']//a[contains(text(),'Sign In')]")
	public WebElement signinLink;
	@FindBy(xpath = "/html/body/div[2]/header/div[1]/div/ul/li[3]/a")
	public WebElement createNewAccountLink;
	@FindBy(xpath = "//span[@class='base']")
	public WebElement homepageText;
	
	@FindBy(xpath="//a[@class='action showcart']")
	public WebElement cartIcon;
	
	@FindBy(xpath="//div[2]/div[2]/div/span/span")
	public WebElement totalPrice;


	@FindBy(xpath = "//a[@title='Remove item'] ")
	public List<WebElement> cartList;
	
	 
	@FindBy(xpath = "//button[@class='action-primary action-accept'] ")
	public WebElement popUpAcceptElement;
	
	@FindBy(xpath="//span[@class='counter qty'] /span[@class='counter-number']  ")
	public List<WebElement> counterElement;
	
	@FindBy(xpath="//button[@id='top-cart-btn-checkout'] ")
	public WebElement proceedToCartElement;
	
	  
	
	@FindBy(xpath="//button[@data-action='close'] ")
	public WebElement closingButtonElement;
}