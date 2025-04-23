package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SortProduct {

	public static void main(String[] args) {
				//Launch the browser
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
				driver.get("https://www.saucedemo.com/");

				//Login to application
				driver.findElement(By.id("user-name")).sendKeys("standard_user");
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				driver.findElement(By.id("login-button")).click();

				//Sort the product from low prce to high price
				WebElement dd = driver.findElement(By.className("product_sort_container"));
				Select select=new Select(dd);
				select.selectByValue("lohi");

				//Click a product
				WebElement productEle = driver.findElement(By.xpath("//div[.='Sauce Labs Onesie']"));
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
					System.out.println("Pass");
					System.out.println(pinCart);
				}
				else {
					System.out.println("Fail");
				}

				//Checkout the product
				driver.findElement(By.id("checkout")).click();
				driver.findElement(By.id("first-name")).sendKeys("nivashini");
				driver.findElement(By.id("last-name")).sendKeys("R");
				driver.findElement(By.id("postal-code")).sendKeys("603210");
				driver.findElement(By.id("continue")).click();
				driver.findElement(By.id("finish")).click();

				//Logout of application
				driver.findElement(By.id("react-burger-menu-btn")).click();
				driver.findElement(By.linkText("Logout")).click();
				driver.quit();
			}

	}


