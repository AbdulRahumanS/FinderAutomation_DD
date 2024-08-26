package Testcase;

import org.testng.annotations.Test;

import Keywords.ApplicationKeywords;

public class Finder_Enroll extends ApplicationKeywords {

	@Test
	public void Finder_Signup(){
		
		
		/*1. Open google chrome
		  2. Open URL
		  3. Click on Services Dropdown
		  4. Select CSA from Services Dropdown
		  5. Fill 1st page and Click on next
		  6. Fill 2nd page and Click on Next
		  7. Fill 3rd page and Click on Next
		  8. Fill 4th page and Click on Next
		  9. Check csa right & responsibilities and Click on submit*/
	
	
	
	
	ApplicationKeywords app = new ApplicationKeywords();
	
	
	
		app.OpenBrowser("browser_name");
		app.OpenURL("URL");
		app.ClickServiceDropDown("Service_Dropdown_xpath");
		app.ClickCSA("ClickCSA_xpath");
		app.validateTitle("DTA HIP - Healthy Incentives Program (HIP)");
		app.ClickEnroll("EnrollCSAButton_id");
		app.ClickFarmdropdown("FarmDropdown_css");
		app.ChooseFarm("ChoosevaluefromFarmDropdown_xpath");
		app.ClickNextButton1("ClickNextButton1_xpath");
		app.typevalues("FirsName_name", "john");
		app.typevalues("LastName_name", "wick");
		app.typevalues("ChosenName_name", "ABDUL");
		app.typevalues("Day_name", "19");
		app.typevalues("Month_name", "January");
		app.typevalues("Year_name", "1990");
//		app.clickradiobutton("Ebt_id");
		app.clickradiobutton("DTAAgency_id");
		app.typevalues("Radio_name", "6455326");
		app.typevalues("Email_name", "abdul@gmail.com");
		app.typevalues("Phone_name", "9999999999");
		app.ClickNextButton2("ClickNextButton2_xpath");
		app.ClickcheckBox("Checkbox_xpath");
		app.ClickNextButton3("ClickNextButton3_xpath");
		app.clickradiobutton2("RadioButton_name");
		app.ChooseLocation("ChooseLocation_xpath");
		app.clickradiobutton3("RadioButton_id");
		app.ClickNextButton4("ClickNextButton2_xpath");
		app.ClickTermsCheckbox("TermsCheckbox_name");
		app.typevalues("sign_name", "sign");
		app.ClickSubmitButton("ClickSubmitButton_xpath");
//		app.quitDriver();
		

		
	}
}	
