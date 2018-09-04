package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericMethods.CommonMethods;
import genericMethods.Configuration;
import genericMethods.Data;
import genericMethods.Driver;
import genericMethods.EventMethods;
import genericMethods.UtilityMethods;

public class Groups extends Configuration {

			Groups(){
				CommonMethods.set(new CommonMethods());
				EventMethods.set(new EventMethods());
				UtilityMethods.set(new UtilityMethods());
				UtilityMethods.get().loadRepository("Object Repositories\\repositories.xml");
			}
	
	@Parameters("browser")
	@Test
	public void groups_Verify_PostMessage(@Optional String browser) {
		EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
		 Driver.get().manage().window().maximize();
		 UtilityMethods.get().waitForPageLoad();

		 try {
			 
			WebElement home = Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"));
			 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");
			 home.click();
			 
			 UtilityMethods.get().waitForPageLoad();
			
			 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "hcpauto");
			 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
			 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
			 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
			 UtilityMethods.get().waitForPageLoad();
			 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
			 UtilityMethods.get().waitForPageLoad();
			 
			 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("GroupMenuLink"), "Clicking on groups menu Link");
			 writeLog("Pass", "Clicking on groups menu link", "Groups link clicked");
			 
			WebElement postMessage=Driver.get().findElement(By.xpath("//div[@class='post panel groups-post-panel']/descendant::textarea"));
			String message=postMessage.getText();
			// EventMethods.get().highlightElement(UtilityMethods.get().getBy_from_Repository("PostMessage"), "", 10);
			// EventMethods.get().verifyElementExists(By.xpath("//div[@class='post panel groups-post-panel']/descendant::textarea"));
			
			
			// Validators.get().verifyFullTextOfElement(UtilityMethods.getBy_from_Repository("PostMessage"), expectedText," Verify the text in the post group");
			
			String expectedText="You can't post anything,till your medical licence has been verified.";
			if(message.equalsIgnoreCase(expectedText)) {
			 writeLog("PASS", "Verify the text in the post group", "Message has been displayed in the textarea");
			 EventMethods.get().verifyElementExists(UtilityMethods.get().getBy_from_Repository("message"));
			 EventMethods.get().highlightElement(UtilityMethods.get().getBy_from_Repository("message"), "", 10);
			}else {
				writeLog("FAIL", "Verify the text in the post group", "Message does not displayed in the textarea");
			}
}catch (Exception e) {
	// TODO: handle exception
		}
		 CommonMethods.get().Logout();
	}
}