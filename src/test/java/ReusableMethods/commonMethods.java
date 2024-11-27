package ReusableMethods;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class commonMethods {
	public WebDriver driver;
	public WebDriverWait wait;
	public JavascriptExecutor jse;
	
	public commonMethods(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		PageFactory.initElements(driver, this);
		jse=(JavascriptExecutor) driver;
	}
	
	public void visibility(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void javaScriptExecutor( WebElement element) {
		jse.executeScript("arguments[0].scrollIntoView({ block: 'center' });",element);
		
	}

}
