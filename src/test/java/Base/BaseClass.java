package Base;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseClass {
	public WebDriver driver;
	
	
	public WebDriver initializebrowser() throws Exception {
		Properties prop=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"//src//main//java//properties//GlobalData.properties");
		prop.load(fis);
		String browser = prop.getProperty("browser").toLowerCase(); 
		try {
            if (browser.equals("chrome")) {
                driver = new ChromeDriver();
            } else if (browser.equals("edge")) {
                driver = new EdgeDriver();
            } else {
                throw new Exception("Unsupported browser: " + browser + ". Please use 'chrome' or 'edge'.");
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw e; 
        }
         return driver;
	}
	
	@BeforeMethod()
	public void launchbrowser() throws Exception {
		WebDriver driver = initializebrowser();
		driver.get("https://www.fitpeo.com/");
	    
	}
	
	@AfterMethod()
	public void close_browser(){
		driver.close();
		
	}
	
	


}
