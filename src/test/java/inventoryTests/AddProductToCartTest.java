package inventoryTests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.CartPage;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

@Listeners(genericUtilities.ListenerImplementation.class)
public class AddProductToCartTest extends BaseClass {
	@Test(groups = "SmokeSuite")
	public void tc_001_AddProductToCartTest() throws IOException {
		// Create Object Of All Required Utility Classes
		FileUtility futil = new FileUtility();
		SeleniumUtility sutil = new SeleniumUtility();
		JavaUtility jutil = new JavaUtility();

		// Read Common Data from Property file
		String URL = futil.readDataFromPropertyFile("url");
		String USERNAME = futil.readDataFromPropertyFile("username");
		String PASSWORD = futil.readDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String PRODUCTNAME = futil.readDataFromExcel("Product", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new ChromeDriver();
		sutil.maximizeWindow(driver);
		sutil.addImplicitlywait(driver);

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: login To Application
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);

		// Step 4: Click on a Product
		InventoryPage ip = new InventoryPage(driver);
		String pAddedToCart = ip.clickOnAProduct(driver, PRODUCTNAME);

		// Step 5: Add the Product To Cart
		InventoryItemPage iip = new InventoryItemPage(driver);
		iip.clickOnAddToCartBtn();

		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();
		// Assert.fail();

		// Step 7: Validate the product in Cart
		CartPage cp = new CartPage(driver);
		String pInCart = cp.getProductName();

		Assert.assertEquals(pInCart, pAddedToCart);

		Assert.assertTrue(pInCart.equals(pAddedToCart));
		System.out.println(pInCart);

		// Step 8: Logout of App
		ip.logoutOfApp();
		driver.quit();

	}

}