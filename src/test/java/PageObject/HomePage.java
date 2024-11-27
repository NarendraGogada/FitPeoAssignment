package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.commonMethods;

public class HomePage extends commonMethods{
	public WebDriver driver;
	public HomePage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css="div[class*=\"satoshi\"]")
	List<WebElement> headerElements;
	
	public void clickOnRevenueCalculater(String requiredHeader) {
		headerElements.stream().filter(ele->ele.getText().equalsIgnoreCase(requiredHeader)).forEach(s->s.click());
	}
    
	
}
