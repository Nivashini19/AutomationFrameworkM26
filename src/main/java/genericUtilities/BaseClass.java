package genericUtilities;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import objectRepository.InventoryPage;
import objectRepository.LoginPage;

/**
 * This class consists of Basic configuration annotations of TestNG
 * @author Nivashini R
 *
 */
public class BaseClass {

	public FileUtility futil = new FileUtility();
	public JavaUtility jutil = new JavaUtility();
	public SeleniumUtility sutil = new SeleniumUtility();

	public WebDriver driver;
	//For Listeners
	public static WebDriver sdriver;

	@BeforeSuite(alwaysRun=true)
	public void bsConfig()
	{
		System.out.println("----- Database Connection successfull -----");
	}
	//@Parameters("Browser")
	//@BeforeTest
	@BeforeClass(alwaysRun=true)
	public void bcConfig() throws IOException
	{
		String URL = futil.readDataFromPropertyFile("url");

		driver = new ChromeDriver();
		/*if(pValue.equals("edge"))
		{
			driver=new EdgeDriver();
		}
		else if(pValue.equals("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else
		{
			driver=new EdgeDriver();
		}*/

		sutil.maximizeWindow(driver);
		sutil.addImplicitlywait(driver);

		driver.get(URL);

		System.out.println("----- Browser Launch successfull -----");
		//For Listeners
		sdriver=driver;
	}

	@BeforeMethod(alwaysRun=true)
	public void bmConfig() throws IOException
	{
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");

		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		System.out.println("----- Login to App successfull -----");
	}


	@AfterMethod(alwaysRun=true)
	public void amConfig()
	{
		InventoryPage ip = new InventoryPage(driver);
		ip.logoutOfApp();

		System.out.println("----- Logout of App successfull -----");
	}
	//@AfterTest
	@AfterClass(alwaysRun=true)
	public void acConfig()
	{
		driver.quit();

		System.out.println("----- Browser closure successfull -----");
	}


	@AfterSuite(alwaysRun=true)
	public void asConfig()
	{
		System.out.println("----- Database Closure successfull -----");
	}
}