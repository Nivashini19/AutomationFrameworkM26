package objectRepository;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
		private WebDriver driver;

		@FindBy(className = "inventory_item_name")
		private WebElement itemInfo;

		@FindBy(xpath = "//button[.='Remove']")
		private WebElement removeBtn;

		public CartPage(WebDriver driver)
		{
			this.driver = driver;
			PageFactory.initElements(driver, this);
		}

		public WebElement getItemInfo() {
			return itemInfo;
		}

		public WebElement getRemoveBtn() {
			return removeBtn;
		}

		//Business library

		/**
		 * This method will capture the Product Name
		 * @return
		 */
		public String getProductName()
		{
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	        wait.until(ExpectedConditions.visibilityOf(itemInfo));
			return itemInfo.getText();
		}


}


