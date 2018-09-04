package scripts;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericMethods.BusinessReusableMethods;
import genericMethods.Configuration;
import genericMethods.Data;
import genericMethods.Driver;
import genericMethods.EventMethods;
import genericMethods.UtilityMethods;

public class News extends Configuration {

	News(){
		EventMethods.set(new EventMethods());
		GetExcelObjectsIntoHashMap.set(new GetExcelObjectsIntoHashMap());
		BusinessReusableMethods.set(new BusinessReusableMethods());
	}
	
	@Parameters("browser")
	@Test
	public void News_Module_with_Valid_User(@Optional String browser) {
		
		EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
		 Driver.get().manage().window().maximize();
		 UtilityMethods.get().waitForPageLoad();
		Data.Common.repositoryFilePath = "Object Repositories\\HCPSPACE_Appication_Object-Repositories_1.xlsx";
		Data.Common.repositorySheetName = "Home Page";
		 try {
			 
			
			WebElement home = Driver.get().findElement(GetExcelObjectsIntoHashMap.get().getBy("headerHomeLink"));
			 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");
			 home.click();
			 
			 UtilityMethods.get().waitForPageLoad();
			
			 EventMethods.get().enterText(GetExcelObjectsIntoHashMap.get().getBy("emailEditbox"), "bisleri");
			 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
			 EventMethods.get().enterText(GetExcelObjectsIntoHashMap.get().getBy("passwordEditbox"), "bisleri");
			 EventMethods.get().clickButton(GetExcelObjectsIntoHashMap.get().getBy("signInButton"));
			 UtilityMethods.get().waitForPageLoad();
			 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
			 UtilityMethods.get().waitForPageLoad();
			 
	
			 
			WebElement news = Driver.get().findElement(GetExcelObjectsIntoHashMap.get().getBy("newsTab"));
			 news.click();
			
			 writeLog("pass", "Click on News tab", "Navigated to News Page", "Active News tab");

			EventMethods.get().clickLink(GetExcelObjectsIntoHashMap.get().getBy("perticularHeadLine"));
			UtilityMethods.get().waitForPageLoad();
			writeLog("pass", "Click on News tab", "Navigated to detalis of title", "user navigated to perticular title");
			BusinessReusableMethods.get().like();
			System.out.println("done");
			
			
			
			/*WebElement newsuserComments = Driver.get().findElement(GetExcelObjectsIntoHashMap.get().getBy("newsWriteaComment"));
			newsuserComments.sendKeys("Good Work, Thanks you.");
			EventMethods.get().waitConstantTime(5000);
			WebElement newscommentpostbutton = Driver.get().findElement(GetExcelObjectsIntoHashMap.get().getBy("newsPostButton"));
			newscommentpostbutton.click();
			*/
			
		/*	EventMethods.get().waitConstantTime(5000);
			WebElement newsAllcomments = Driver.get().findElement(GetExcelObjectsIntoHashMap.get().getBy("newsAllComents"));
			newsAllcomments.click();
			EventMethods.get().waitConstantTime(5000);*/
			
			
			
		 } catch (Exception e) {
			 new SkipException("Execution terminated as Application was not launched. ");
		 }
			

		 //writeLog("pass", "Click on Home button", "Application navigeted into login page", "Login page");
	}
}
