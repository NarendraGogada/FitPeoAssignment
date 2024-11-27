package PageObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import ReusableMethods.commonMethods;

public class RevenueCalculatorPage extends commonMethods {
	public WebDriver driver;
    
	public RevenueCalculatorPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(css="div[class*=\"MuiGrid-root\"] span[class*=\"MuiSlider-thumb\"]")
	WebElement slider;
	@FindBy(css="div[class*=\"MuiGrid-grid-md-6\"]")
	WebElement view;
	@FindBy(css="div[class*='MuiInputBase-root'] input[type='number']")
	public WebElement box;
	@FindBy(xpath="//input[@type='range']")
	public WebElement sliderValueElement;
	@FindBy(css="div[class=\"MuiBox-root css-1eynrej\"]")
	List <WebElement> cpt;
	@FindBy(xpath="(//p[contains(@class,\"MuiTypography-body2\")]//p[contains(@class,\"MuiTypography-body1\")])[4]")
	public WebElement headerValue;
	
	By code=By.tagName("p");
	By checkBox=By.cssSelector("input[type=\"checkbox\"]");
	
	public void scrollDownToSliderSection() {
		visibility(slider);
		javaScriptExecutor(view);
	}
	
	public void adjustSlider() {
        Actions action =new Actions(driver);
		action.dragAndDropBy(slider,94, 0).build().perform();	
	}
	
	public void updateTextField(String value) {
		box.click();
		box.sendKeys(Keys.CONTROL + "a");
		box.sendKeys(Keys.DELETE);
        box.sendKeys(value);
	}
	
	public void selectCptCode(String []arr) {
        List <WebElement>requiredCpt=cpt.stream().filter(ele->ele.findElement(code).getText().equalsIgnoreCase("CPT-99091")).collect(Collectors.toList());		
        javaScriptExecutor(requiredCpt.get(0));
		for(int i=0;i<cpt.size();i++) {
			if(Arrays.asList(arr).contains(cpt.get(i).findElement(By.tagName("p")).getText())) {
				cpt.get(i).findElement(checkBox).click();
			}
		}
	}
	
	
	
	
	
	

}
