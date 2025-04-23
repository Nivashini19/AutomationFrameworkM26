package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {
	WebDriver driver;
	//constructor
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//Locators
	@FindBy(id="user-name")
	WebElement usernameEdt;

	//Auto Healing process
	@FindAll({@FindBy(id="password"),@FindBy(name="password")})		//single web element wth multiple locators -OR Operator
	WebElement passwordEdt;

//	@FindBys({@FindBy(id="password"),@FindBy(name="password")})		//single web element wth multiple locators -AND Operator
//	WebElement passwordEdt;

	@FindBy(id="login-button")
	WebElement loginBtn;

	public WebElement getUser() {
		return usernameEdt;
	}
	public WebElement getPwd() {
		return passwordEdt;
	}
	public WebElement getLoginbtn() {
		return loginBtn;
	}

	public void loginToApp(String username, String password) {
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginBtn.click();
	}




}
