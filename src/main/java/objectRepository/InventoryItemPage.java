package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InventoryItemPage {
	 WebDriver driver;

	//Constructor
	public InventoryItemPage(WebDriver driver)
	{
		this.driver = driver;
        PageFactory.initElements(driver, this);
	}
	//Locators or initialization

	@FindBy(id = "add-to-cart")
	private WebElement addTocartBtn;


	// Method to add a product to the cart dynamically
    public WebElement getAddToCart(String productName)
    {
    	return addTocartBtn;
    }
    /**
	 * This method will click on add to cart button
	 */
	public void clickOnAddToCartBtn()
	{
		addTocartBtn.click();
	}







}



