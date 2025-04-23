package Practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddProductToCartUsingDDT {

	public static void main(String[] args) throws IOException {
		//Read data from properties file
		FileInputStream fis =new FileInputStream(".\\src/test/resources/Commondata.properties");
		Properties prop= new Properties();
		prop.load(fis);
		String URL=prop.getProperty("url");
		String USERNAME=prop.getProperty("username");
		String PASSWORD=prop.getProperty("password");

		//Read data from Excel file
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh= wb.getSheet("Product");

		// Fetch data from row 1, column 2
		Row row = sh.getRow(1);
		Cell c1 = row.getCell(2);
		String PRODUCTNAME = c1.getStringCellValue();

		// Fetch data from row 2, column 3
		Row row1 = sh.getRow(2);
		Cell c2 = row1.getCell(3);
		String PRODUCTNAME1 = c2.getStringCellValue();

		System.out.println("Product Name 1: " + PRODUCTNAME);
		System.out.println("Product Name 2: " + PRODUCTNAME1);

		//Launch the browser
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		//Load the applicaton
		driver.get(URL);

		//Login to application
		driver.findElement(By.id("user-name")).sendKeys(USERNAME);
		driver.findElement(By.id("password")).sendKeys(PASSWORD);
		driver.findElement(By.id("login-button")).click();

		//Click a product
		WebElement productEle = driver.findElement(By.xpath("//div[.='"+PRODUCTNAME+"']"));
		String pAddedtoCart = productEle.getText();
		productEle.click();

		//Add a product to cart
		driver.findElement(By.id("add-to-cart")).click();

		//Navigate to cart
		driver.findElement(By.id("shopping_cart_container")).click();

		//Validate the product in cart
		String pinCart = driver.findElement(By.className("inventory_item_name")).getText();
		if(pinCart.equals(pAddedtoCart))
		{
			System.out.println("PASS");
			System.out.println(pinCart);
		}
		else {
			System.out.println("FAIL");
		}

		//Logout of application
		driver.findElement(By.id("react-burger-menu-btn")).click();
		driver.findElement(By.linkText("Logout")).click();
		driver.quit();
	}
	}

