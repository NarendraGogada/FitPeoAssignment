package FitPeo;



import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.BaseClass;
import PageObject.HomePage;
import PageObject.RevenueCalculatorPage;

public class StandAloneTest extends BaseClass{
     
	@Test
	public void FitPeoTest() {
		// TODO Auto-generated method stub
		String requiredHeader="Revenue Calculator";
		String []arr= {"CPT-99091","CPT-99453","CPT-99454","CPT-99474"};
		
		//Navigate to the Revenue Calculator Page:
		HomePage homePage=new HomePage(driver);
		homePage.clickOnRevenueCalculater(requiredHeader);
		
		//Scroll Down to the Slider section:
		RevenueCalculatorPage RCP=new RevenueCalculatorPage(driver);
		RCP.scrollDownToSliderSection();
		
		//Adjust the Slider:
		RCP.adjustSlider();	
		
		//verify the slider box
		String sliderValue=RCP.sliderValueElement.getAttribute("value");
		String boxValue=RCP.box.getAttribute("value");
		SoftAssert sa= new SoftAssert();
		sa.assertEquals(sliderValue, boxValue);
		
		//Update the Text Field:
		RCP.updateTextField("560");
		
        //Validate Slider Value:
        String updatedSliderValue= RCP.sliderValueElement.getAttribute("value");
        String updatedBoxValue=RCP.box.getAttribute("value");
        sa.assertEquals(updatedSliderValue, updatedBoxValue);
        
        //Select CPT Codes:
        RCP.updateTextField("820");
        RCP.selectCptCode(arr);
		
		//Verify that the header displaying Total Recurring Reimbursement for all Patients Per Month
		String totalRecurringReimbursement="$110700";
		String headerValue=RCP.headerValue.getText();
        Assert.assertEquals(totalRecurringReimbursement, headerValue);
		sa.assertAll();	
		
		

	}

}
