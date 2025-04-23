package Practice;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import genericUtilities.FileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.SeleniumUtility;
import objectRepository.InventoryItemPage;
import objectRepository.InventoryPage;
import objectRepository.LoginPage;

public class AddProductTocartUisngDDTandGU {

	public static void main(String[] args) throws IOException {

		//Create Object Of All Required Utility Classes
		FileUtility fUtil = new FileUtility();
		SeleniumUtility sUtil = new SeleniumUtility();
		JavaUtility jUtil = new JavaUtility();

		// Read Common Data from Property file
		String URL = fUtil.readDataFromPropertyFile("url");
		String USERNAME = fUtil.readDataFromPropertyFile("username");
		String PASSWORD = fUtil.readDataFromPropertyFile("password");

		// Read Test Data From Excel File
		String PRODUCTNAME = fUtil.readDataFromExcel("Product", 1, 2);

		// Step 1: Launch the browser
		WebDriver driver = new EdgeDriver();
		sUtil.maximizeWindow(driver);
		sUtil.addImplicitlywait(driver);

		// Step 2: Load the Application
		driver.get(URL);

		// Step 3: login To Application

		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME,PASSWORD);

		// Step 4: Click on a Product

		InventoryPage ip=new InventoryPage(driver);
		ip.clickOnAProduct(driver, PRODUCTNAME);

		// Step 5: Add the Product To Cart
		InventoryItemPage itempage=new InventoryItemPage(driver);
		itempage.getAddToCart(PRODUCTNAME);


		// Step 6: Navigate to Cart
		ip.clickOnCartContainer();

		//Capture Screenshots for reference
		String screenshotname = "Tc_001"+jUtil.getSystemDateInFormat();
		String path = sUtil.captureScreenShot(driver, screenshotname);
		System.out.println(path);

		// Step 7: Validate the product in Cart
		String pInCart = driver.findElement(By.className("inventory_item_name")).getText();
		if (pInCart.equals(PRODUCTNAME)) {
			System.out.println("Test Passed : product added to cart successfully");
			System.out.println(pInCart);
		} else {
			System.out.println("Test Failed: Product does not match");
		}

		// Step 8: Logout of App
		ip.logoutOfApp();
		driver.quit();
	}

}

