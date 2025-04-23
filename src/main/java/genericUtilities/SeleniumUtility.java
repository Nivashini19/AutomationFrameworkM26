package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumUtility {
	/**
	 * This class consists of generic methods related to file operations
  	 *	@author Nivashini R
	 */

	public void maximizeWindow(WebDriver driver)
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	{
		driver.manage().window().maximize();
	}
	public void minimizeWindow(WebDriver driver)
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	{
		driver.manage().window().minimize();
	}
	public void addImplicitlywait(WebDriver driver)
	/**
	 * This method will wait for particular element
	 * @param driver
	 * @param element
	 */
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public void addExplicitWait(WebDriver driver,WebElement element)
	/**
	 * This method will wait for particular element
	 * @param driver
	 * @param element
	 */
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	/**
	 * This method will wait for particular element to be clickable
	 * @param driver
	 * @param element
	 */
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public void handleDropDown(WebElement element,int index)
	/**
	 * This method will select all the dropdowns
	 */
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void handleDropDown(String value,WebElement element)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void handleDropDown(WebElement element,String visibleText)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibleText);
	}

	public void clickActions(WebDriver driver,WebElement element)
	/**
	 * This method will perform click actions
	 * @param driver
	 * @param element
	 */
	{
		Actions action=new Actions(driver);
		action.click(element).perform();
	}
	public void moveToElementActions(WebDriver driver,WebElement element)
	/**
	 * This method will perform click actions
	 * @param driver
	 * @param element
	 */
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).click().perform();
	}
	public void contextClickActions(WebDriver driver,WebElement element)
	/**
	 * This method will perform contextClick actions
	 * @param driver
	 * @param element
	 */
	{
		Actions action=new Actions(driver);
		action.contextClick(element).perform();
	}
	public void doubleClickActions(WebDriver driver,WebElement element)
	/**
	 * This method will perform doubleClick actions
	 * @param driver
	 * @param element
	 */
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).perform();
	}
	public void dragAndDropActions(WebDriver driver,WebElement element)
	/**
	 * This method will perform dragAndDrop actions
	 * @param driver
	 * @param element
	 */
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(element, element).perform();
	}
	public void scrollactions(WebDriver driver,WebElement element)
	/**
	 * This method will perform dragAndDrop actions
	 * @param driver
	 * @param element
	 */
	{
		Actions action=new Actions(driver);
		action.scrollToElement(element).perform();
	}
	public void handleFrame(WebDriver driver,int index)
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param index
	 */
	{
		driver.switchTo().frame(index);
	}
	public void handleFrame(WebDriver driver,String IdOrName)
	/**
	 * This method will handle frame by index
	 * @param driver
	 * @param IdOrName
	 */
	{
		driver.switchTo().frame(IdOrName);
	}
	public void handleFrame(WebDriver driver, WebElement frameelement)
	/**
	 * This method will switch the control back to main page ignoring all parent frames
	 * @param driver
	 * @param frameelement
	 */
	{
		driver.switchTo().parentFrame();
	}
	public void handleFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public void switchToWindow(WebDriver driver,String windowHandle)
	{
		driver.switchTo().window(windowHandle);
	}

	public void alertAccept(WebDriver driver)
	/**
	 * This method wll accept the popup
	 * @param driver
	 */
	{
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	public void alertDismiss(WebDriver driver)
	/**
	 * This method wll cancel the popup
	 * @param driver
	 */
	{
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	public void alertSendkeys(WebDriver driver)
	/**
	 * This method wll enter data into alert popup
	 * @param driver
	 */
	{
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("element");
	}
	public void alertGetText(WebDriver driver)
	/**
	 * This method wll capture the alert text and return to caller
	 * @param driver
	 */
	{
		Alert alert = driver.switchTo().alert();
		alert.getText();
	}

	public void jsScrollBy(WebDriver driver,int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(x,y)");
	}
	public void jsScrollTo(WebDriver driver,int x, int y)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo(x,y)");
	}
	public void jsScrollIntoView(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)", element);
	}
	public void jsScrollup(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-500);","");
	}
	public void jsScrollDown(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500);","");
	}
	public void jsScrollRight(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrollBy(500,0);","");
	}
	public void jsScrollLeft(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeAsyncScript("window.scrollBy(-500,0);","");
	}

	public String captureScreenShot(WebDriver driver,String screenShotName) throws IOException
	/**
	 * This method will capture the screen shot and return the path to Caller
	 * @param driver
	 * @param screenShotName
	 * @return
	 * @throws IOException
	 */
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dst = new File(".\\screenShots\\"+screenShotName+".png"); //tsname_date_Time
		FileHandler.copy(src, dst);
		return dst.getAbsolutePath(); //For Extent reports
	}

}

