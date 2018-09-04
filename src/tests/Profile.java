package scripts;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericMethods.CommonMethods;
import genericMethods.Configuration;
import genericMethods.Data;
import genericMethods.Driver;
import genericMethods.EventMethods;
import genericMethods.UtilityMethods;
import genericMethods.Validators;

public class Profile  extends Configuration{
	
	Profile(){
		EventMethods.set(new EventMethods());
		UtilityMethods.set(new UtilityMethods());
		CommonMethods.set(new CommonMethods());
		//UtilityMethods.get().loadRepository("Object Repositories\\repositories.xml");
	}
	//*****************************************************************************************************************************
	/**
	 * 
	 * @param browser
	 */
	@Parameters("browser")
	@Test
	public void profile_Verify_ImageUpload(@Optional String browser) {
		EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
		 Driver.get().manage().window().maximize();
		 UtilityMethods.get().waitForPageLoad();

		 try {
			 
			 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
			 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

			 UtilityMethods.get().waitForPageLoad();
			
			 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "akumar8");
			 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
			 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "password");
			 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
			 UtilityMethods.get().waitForPageLoad();
			 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
			 UtilityMethods.get().waitForPageLoad();
			 
			 
			 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("userAccount"), "Clicking on User Accounts");
				
				writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
			UtilityMethods.get().waitForPageLoad();
			
			EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("ProfileLink"), "Settings clicked");
		
			writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
			UtilityMethods.get().waitForPageLoad();		
			WebElement element=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("profileImage"));
			element.click();
			//EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("profileImage"), "Clicking on profile image");
			writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
			UtilityMethods.get().waitForPageLoad();
			//UtilityMethods.get().waitForElement(UtilityMethods.get().getBy_from_Repository("profileImage"), 20);
			EventMethods.get().uploadWindowsFileByUsingAutoIt("WindowsUploads\\download.png");
			writeLog("Pass", "Take screen shot for profilecoverage ", "Profile coverage  populated", "Profile coverage clicked");
		
			UtilityMethods.get().waitForPageLoad();
			
			//EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("profileCoverImage"), "clicking on cover page image");
			WebElement coelement=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("profileCoverImage"));
			coelement.click();
			UtilityMethods.get().waitForPageLoad();
			EventMethods.get().uploadWindowsFileByUsingAutoIt("WindowsUploads\\apple.png");
			writeLog("Pass", "Take screen shot for coverImage ", "Cover image populated", "Cover image clicked");
		
			UtilityMethods.get().waitForPageLoad();
		 }catch (Exception e) {
			 new SkipException("Execution terminated as Application was not launched. ");
		}
		 CommonMethods.get().Logout();
		writeLog("pass", "log out from the application", "user logged out from the application");
	}
	//***************************************************************************************************************************************
	/**
	 * 
	 * @param browser
	 */
		 @Parameters("browser")
			@Test
			public void profile_Verify_Experience(@Optional String browser) {
				EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
				 Driver.get().manage().window().maximize();
				 UtilityMethods.get().waitForPageLoad();

				 try {
					 
					 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
					 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

					 UtilityMethods.get().waitForPageLoad();
					
					 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "akumar8");
					 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
					 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "password");
					 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
					 UtilityMethods.get().waitForPageLoad();
					 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
					 UtilityMethods.get().waitForPageLoad();
					 
					 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("userAccount"), "Clicking on User Accounts");
						
						writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
						UtilityMethods.get().waitForPageLoad();
						/*WebElement userAccLink = Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("ProfileLink"));
						userAccLink.click();*/
						EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("ProfileLink"), "Settings clicked");
						writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
						UtilityMethods.get().waitForPageLoad();
						
					 
			WebElement expCheck=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("ExperienceCheck"));
			expCheck.click();
			writeLog("Pass", "Take screen shot for experience Check ", "Experience tab populated", "Experience tab clicked");
			
			EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Title"), "IqviaHcp");
			EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Company"), "IQVIA");
			EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("WorkPlace"), "Bangalore");
			EventMethods.get().setCheckBox(UtilityMethods.get().getBy_from_Repository("CurrentCompany"), "checked");
			EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Summary"), "asdlkjadkjajfaljfladkj");
			EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("ExStartDate"), "start date clicked");
			
			String startDate = "09/25/2018";
			EventMethods.get().selectDate(startDate);
			
			//String endDate =EventMethods.get(). getPastDate(startDate, "d", 2);
			
			EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("ExSave"));
			
		//EventMethods.get().selectDate(endDate);
			String expectedText="Your profile info has been updated";
			//Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), expectedText, "Verify the profile info");
			String assverifyText=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AssocVerifyText")).getText();
			
			if(assverifyText.contains(expectedText)) {
				writeLog("pass", "Your profile has been updated", "As Expected");
			}else {
				writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
				
			}
				 }catch (Exception e) {
					 new SkipException("Execution terminated as Application was not launched. ");
				}
				 CommonMethods.get().Logout();
				 writeLog("pass", "logout from the application", "user logged out from the application successfully");
		 }
		 
	//******************************************************************************************************************************	 
		 /**
		  * 
		  * @param browser
		  */
		 @Parameters("browser")
			@Test
			public void profile_Verify_Education(@Optional String browser) {
				EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
				 Driver.get().manage().window().maximize();
				 UtilityMethods.get().waitForPageLoad();

				 try {
					 
					 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
					 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

					 
					 UtilityMethods.get().waitForPageLoad();
					
					 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
					 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
					 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
					 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
					 UtilityMethods.get().waitForPageLoad();
					 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
					 UtilityMethods.get().waitForPageLoad();
					 
					 
					 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("userAccount"), "Clicking on User Accounts");
						
						writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
						UtilityMethods.get().waitForPageLoad();
						WebElement userAccLink = Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("ProfileLink"));
						userAccLink.click();
						writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
						UtilityMethods.get().waitForPageLoad();
						EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("EducationCheck"), "Clicking on Experience link on profile page");
						writeLog("Pass", "Take screen shot for Education Check ", "Education tab populated", "Education tab clicked");
						EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Education"), "BTech");
						EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("School"), "RVM High School");
						EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Degree"), "BSc");
						EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Activities"), "Physical");
						EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("EdStartDate"), "start Date");
						EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("EdSave"));
						String expectedText="Your profile info has been updated";
						//Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), expectedText, "Verify the profile info");
						String assverifyText=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AssocVerifyText")).getText();
						if(assverifyText.contains(expectedText)) {
							writeLog("pass", "Your profile has been updated", "As Expected");
						}else {
							writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
							
						}
				 }catch (Exception e) {
					 new SkipException("Execution terminated as Application was not launched. ");
				} UtilityMethods.get().waitForPageLoad();
					CommonMethods.get().Logout();
					 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
		 
		 
	// *******************************************************************************************************************************
		 
		 /**
		  * 
		  * @param browser
		  */
				 @Parameters("browser")
					@Test
					public void profile_Verify_Accomplishment(@Optional String browser) {
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("userAccount"), "Clicking on User Accounts");
								
								writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
								UtilityMethods.get().waitForPageLoad();
								WebElement userAccLink = Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("ProfileLink"));
								userAccLink.click();
								writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
								UtilityMethods.get().waitForPageLoad();
								
							EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("AccomplishmentsCheck"), "Clicking on Accomplishment link on profile page");
							writeLog("Pass", "Take screen shot for Accomplishment Check ", "Accomplishment tab populated", "");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Skills"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("CourseAndCertificate"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Publication"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("HonorsAndRewards"), " ");
							EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("ASave"));
							String expectedText="Your profile info has been updated";
							//Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), expectedText, "Verify the profile info");
							String assverifyText=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AssocVerifyText")).getText();
							
							if(assverifyText.contains(expectedText)) {
								writeLog("pass", "Your profile has been updated", "As Expected");
							}else {
								writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
								
							}
						 }catch (Exception e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
						UtilityMethods.get().waitForPageLoad();
						// CommonMethods.get().Logout();
						 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
		// ************************************************Associations*********************************************************************
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
					@Test
					public void profile_Verify_Associations(@Optional String browser) {
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 
							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("userAccount"), "Clicking on User Accounts");
								
							writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
							UtilityMethods.get().waitForPageLoad();
							WebElement userAccLink = Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("ProfileLink"));
							userAccLink.click();
							writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
							UtilityMethods.get().waitForPageLoad();
							EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("AssociationsCheck"), "Clicking on Associtation link on profile page");
							writeLog("Pass", "Take screen shot for Accomplishment Check ", "Accomplishment tab populated", "Accomplishment tab clicked");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("AdditionalOrganizations"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Affiliciations"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Membership"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("CMEsAttended"), " ");
							EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("AsSave"));
							String expectedText="Your profile info has been updated";
							//Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), expectedText, "Verify the profile info");
							String assverifyText=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AssocVerifyText")).getText();
							
							if(assverifyText.contains(expectedText)) {
								writeLog("pass", "Your profile has been updated", "As Expected");
							}else {
								writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
								
							}
						 }catch (Exception e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
						 CommonMethods.get().Logout();
						 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
		//***********************************************************************************************************************************		 
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
					@Test
					public void profile_Verify_AdditionalInfo(@Optional String browser) {
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 
			
							EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
							writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
							UtilityMethods.get().waitForPageLoad();
							EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("ProfileLink"));
							writeLog("Pass", "Take screen shot for profileclicking ", "Profile menu  populated", "Profile clicked");
							UtilityMethods.get().waitForPageLoad();
							EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("AdditionalInfoCheck"), "Clicking on Associtation link on profile page");
							writeLog("Pass", "Take screen shot for Accomplishment Check ", "Accomplishment tab populated", "Accomplishment tab clicked");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("VolunteerExp"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Interests"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Launguages"), " ");
							EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("SplOfInterest"), " ");
							EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("Sasave"));
							String assexpectedText="Your profile info has been updated";
							//boolean assverifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), assexpectedText, "Verify the profile info");
							String assverifyText=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AddVerifyText")).getText();
									
							if(assverifyText.contains(assexpectedText)) {
								writeLog("pass", "Your profile has been updated", "As Expected");
							}else {
								writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
								
							}
							
							EventMethods.get().highlightElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), "Your profile info has been updated", 10);
							writeLog("Pass", "", "");
			
						 }catch (NoSuchElementException e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
						 UtilityMethods.get().waitForPageLoad();
							CommonMethods.get().Logout();
							 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
			
		 
	 //********************************************************************************************************************
				 /**
				  * 
				  */
				 @Parameters("browser")
				 @Test
				 public void profile_Verify_AccountSetting(@Optional String browser) {
						UtilityMethods.get().waitForPageLoad();
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 
							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 
			
							EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
							writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
							UtilityMethods.get().waitForPageLoad();
							EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
							writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
							UtilityMethods.get().waitForPageLoad();
						
							EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("AccountSettings"), "Clicking on Associtation link on profile page");
							
							UtilityMethods.get().waitForPageLoad();
							
						 }catch (NoSuchElementException e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
						 CommonMethods.get().Logout();
						 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
	//********************************************************************************************************************
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
				 @Test
				 public void profile_Verify_EditProfile(@Optional String browser) {
					 
					 
					 UtilityMethods.get().waitForPageLoad();
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 
							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 
			
							 EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
								writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
								UtilityMethods.get().waitForPageLoad();
								EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
								writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
								UtilityMethods.get().waitForPageLoad();
								
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("EditProfile"), "Clicking on Edit profile link ");
								writeLog("Pass", "Take screen shot for edit profile  ", "Edit profile tab populated", "edit profile");
								
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("firstName"), "sreenu");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("lastName"), "new");
								String gender="Male";
								WebElement selectGender=Driver.get().findElement(By.xpath("//select[@name='gender']//option[text()='"+gender+"']"));
								selectGender.click();
								String speciality="Cardiology";
								WebElement selectSpeciality=Driver.get().findElement(By.xpath("//select[@name='speciality_id']//option[text()='"+speciality+"']"));
								selectSpeciality.click();
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("licenceId"), "something");
								/*UtilityMethods.get().waitForPageLoad();
								
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("licenceDoc"), "Choose file clickable");
								EventMethods.get().uploadWindowsFileByUsingAutoIt("WindowsUploads\\licenceID.txt");*/
								String aboutme=",mvncxzlovhsdlvfjsafjsaldkfsdlakfnlsadkjfojflsdkjf";
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("aboutMe"), aboutme);
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("website"), "www.test.com");
								EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("Bsave"));
								writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
								String basexpectedText="Your profile info has been updated";
								//boolean assverifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), assexpectedText, "Verify the profile info");
								String assverifyText=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText")).getText();
										
								if(assverifyText.contains(basexpectedText)) {
									writeLog("pass", "Your profile has been updated", "As Expected");
								}else {
									writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
									
								}
					
								
				// **********************************************Experience **********************************************************************
								
								UtilityMethods.get().waitForPageLoad();
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("EditProfile"), "Clicking on Associtation link on profile page");
								
								writeLog("Pass", "Take screen shot for experience Check ", "Experience tab populated", "Experience tab clicked");
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("work"), "Clicking on Work tab");
								
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Title"), "IqviaHcp");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Company"), "IQVIA");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("WorkPlace"), "Bangalore");
								EventMethods.get().setCheckBox(UtilityMethods.get().getBy_from_Repository("CurrentCompany"), "checked");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Summary"), "asdlkjadkjajfaljfladkj");
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("ExStartDate"), "start date clicked");
								
								String startDate = "09/25/2018";
								EventMethods.get().selectDate(startDate);
								
								String endDate =EventMethods.get(). getPastDate(startDate, "d", 2);
								
								EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("Save"));
								
								EventMethods.get().selectDate(endDate);
								
								String eduexpectedText="Your profile info has been updated";
								boolean eduverifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), eduexpectedText, "Verify the profile info");
								
								if(eduverifyText) {
									writeLog("pass", "Your profile has been updated", "As Expected");
								}else {
									writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
									
								}
			// *******************************************************Education ****************************************************************		
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("EducationCheck"), "Clicking on Experience link on profile page");
								writeLog("Pass", "Take screen shot for Education Check ", "Education tab populated", "Education tab clicked");
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("work"), "Clicking on work tab");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Education"), "BTech");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("School"), "RVM High School");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Degree"), "BSc");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Activities"), "Physical");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Activities"), "Physical");
								
								String edexpectedText="Your profile info has been updated";
								boolean edverifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), edexpectedText, "Verify the profile info");
								if(edverifyText) {
									writeLog("pass", "Your profile has been updated", "As Expected");
								}else {
									writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
									
								}
								
								
			// ******************************* Accomplishments***************************************************************************************************				
								
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("EditProfile"), "Clicking on Accomplishment link on profile page");
								writeLog("Pass", "Take screen shot for Accomplishment Check ", "Accomplishment tab populated", "");
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("work"), "Clicking on work tab");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Title"), " ");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("CourseAndCertificate"), " ");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Publication"), " ");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("HonorsAndRewards"), " ");
								
								EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("ASave"));
								
								String expectedText="Your profile info has been updated";
								boolean verifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), expectedText, "Verify the profile info");
								if(verifyText) {
									writeLog("pass", "Your profile has been updated", "As Expected");
								}else {
									writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
									
								}
			
				//******************************************** Associattions **********************************************				
								
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("AssociationsCheck"), "Clicking on Associtation link on profile page");
								writeLog("Pass", "Take screen shot for Accomplishment Check ", "Accomplishment tab populated", "Accomplishment tab clicked");
								EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("work"), "Clicking on work tab");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("AdditionalOrganizations"), " ");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Affiliciations"), " ");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("Membership"), " ");
								EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("CMEsAttended"), " ");
								EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("AsSave"));
								//String expectedText="Your profile info has been updated";
								//Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), expectedText, "Verify the profile info");
								String assexpectedText="Your profile info has been updated";
								//boolean assverifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), assexpectedText, "Verify the profile info");
								String assverifyText1=Driver.get().findElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText")).getText();
										
								if(assverifyText1.contains(assexpectedText)) {
									writeLog("pass", "Your profile has been updated", "As Expected");
								}else {
									writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
									
								}
								
								EventMethods.get().highlightElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), "Your profile info has been updated", 10);
				
							

				//*************************************** Additional Info *******************************************************************
													
													
													EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("AdditionalInfoCheck"), "Clicking on Associtation link on profile page");
													writeLog("Pass", "Take screen shot for Accomplishment Check ", "Accomplishment tab populated", "Accomplishment tab clicked");
													EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("additional"), "Clicking on additional Info tab");
													EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("addVolunteerExp"), " ");
													EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("addInterests"), " ");
													EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("addLaunguages"), " ");
													EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("addSplOfInterest"), " ");
													EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("addSasave"));
													String addexpectedText="Your profile info has been updated";
													boolean addverifyText=	Validators.get().verifyFullTextOfElement(UtilityMethods.get().getBy_from_Repository("AccocVerifyText"), addexpectedText, "Verify the profile info");
													if(addverifyText) {
														writeLog("pass", "Your profile has been updated", "As Expected");
													}else {
														writeLog("fail", "Your profile doesn't updated", "Your profile doesn't updated");
														
													}
													
					
						
				 }catch (NoSuchElementException e) {
					 new SkipException("Execution terminated as Application was not launched. ");
				}
						 UtilityMethods.get().waitForPageLoad();
							CommonMethods.get().Logout();
							 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
		// ******************************************************privacy settings***************************************************************
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
				 @Test
				 public void profile_Verify_PrivacySettings(@Optional String browser) {
					 	
					 UtilityMethods.get().waitForPageLoad();
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 
							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 
			

							 EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
								writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
								UtilityMethods.get().waitForPageLoad();
								EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
								writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
								UtilityMethods.get().waitForPageLoad();
			
						UtilityMethods.get().waitForPageLoad();
						EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("PrivacySettings"), "Clicking on Associtation link on profile page");
						String chatInfo="Offline";
						EventMethods.get().selectFromDropDownByVisibleText(UtilityMethods.get().getBy_from_Repository("chat"), chatInfo);
						String userInfo="Everyone";
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("basicInfo"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("workInfo"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("locationInfo"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("educationInfo"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("otherInfo"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("microPages"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("joinedGroups"), userInfo);
						EventMethods.get().selectFromDropDownByValue(UtilityMethods.get().getBy_from_Repository("joinedEvents"), userInfo);
						EventMethods.get().verifyElementExists(UtilityMethods.get().getBy_from_Repository("privacypolicy"));
						EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("saveButton"));
						
						EventMethods.get().verifyElementExists(UtilityMethods.get().getBy_from_Repository("privacypolicy"));
						
						
						 }catch (NoSuchElementException e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}		
						UtilityMethods.get().waitForPageLoad();
						CommonMethods.get().Logout();
						 writeLog("pass", "logout from the application", "user logged out from the application successfully");
					 
				 }
		// *********************************************Security Settings*********************************************************
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
				 @Test
				 public void profile_Verify_SecuritySettings(@Optional String browser) {

					 UtilityMethods.get().waitForPageLoad();
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 

							 EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
								writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
								UtilityMethods.get().waitForPageLoad();
								EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
								writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
								UtilityMethods.get().waitForPageLoad();
								UtilityMethods.get().waitForPageLoad();
						EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("SecuritySettings"), "Clicking on Associtation link on profile page");
						
						 }catch (NoSuchElementException e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
						UtilityMethods.get().waitForPageLoad();
						CommonMethods.get().Logout();
						 writeLog("pass", "logout from the application", "user logged out from the application successfully");
						
					 
				 }
		//**********************************************************Blocking *************************************************************************
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
				 @Test
				 public void profile_Verify_Blocking(@Optional String browser) {

					 UtilityMethods.get().waitForPageLoad();
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 

							 EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
								writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
								UtilityMethods.get().waitForPageLoad();
								EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
								writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
								UtilityMethods.get().waitForPageLoad();
						UtilityMethods.get().waitForPageLoad();
						EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("Blocking"), "Clicking on Associtation link on profile page");
						 }catch (NoSuchElementException e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
						UtilityMethods.get().waitForPageLoad();
						CommonMethods.get().Logout();
						 writeLog("pass", "logout from the application", "user logged out from the application successfully");
						
				 }
		 //*********************************************Verification *******************************************************************
				 
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
				 @Test
				 public void profile_Verify_Verification(@Optional String browser) {

					 UtilityMethods.get().waitForPageLoad();
						EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
						 Driver.get().manage().window().maximize();
						 UtilityMethods.get().waitForPageLoad();

						 try {
							 
							 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
							 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");

							 
							 UtilityMethods.get().waitForPageLoad();
							
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
							 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
							 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
							 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
							 UtilityMethods.get().waitForPageLoad();
							 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
							 UtilityMethods.get().waitForPageLoad();
							 

							 EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
								writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
								UtilityMethods.get().waitForPageLoad();
								EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
								writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
								UtilityMethods.get().waitForPageLoad();
					 UtilityMethods.get().waitForPageLoad();
				EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("Verification"), "Clicking on Associtation link on profile page");
						 }catch (NoSuchElementException e) {
							 new SkipException("Execution terminated as Application was not launched. ");
						}
				UtilityMethods.get().waitForPageLoad();
				CommonMethods.get().Logout();
				 writeLog("pass", "logout from the application", "user logged out from the application successfully");
				 }
				 
				 
		//++++++++++++++++++++++++++++++++++++++++++++++Delete Account+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
				 /**
				  * 
				  * @param browser
				  */
				 @Parameters("browser")
				 @Test
			public void profile_Verify_Delete_Account(@Optional String browser) {

				UtilityMethods.get().waitForPageLoad();
				EventMethods.get().launchApplication(browser,Data.Common.propertyFileData.get("URL"));
				 Driver.get().manage().window().maximize();
				 UtilityMethods.get().waitForPageLoad();

				 try {
					 
					 EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("headerHomeLink"), "Navigate to Application Page");
					 writeLog("pass", "Open the browser and Enter Url", "Navigated to Application","Application introduction Page");
					 UtilityMethods.get().waitForPageLoad();
					
					 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginUserName"), "sreenunew");
					 writeLog("pass", "Eneter UserName", "Enetered the UserName", "UserName");		
					 EventMethods.get().enterText(UtilityMethods.get().getBy_from_Repository("loginPassword"), "Sr1!Sr1!");
					 EventMethods.get().clickButton(UtilityMethods.get().getBy_from_Repository("loginButton"));
					 UtilityMethods.get().waitForPageLoad();
					 writeLog("Pass", "Click on Sign In Button", "User Can Click and navigated to User Home Page", "User Home page");
					 UtilityMethods.get().waitForPageLoad();
					 

					 EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("userAccount"));
						writeLog("Pass", "Click on User Name", "Clicked on User Name", "Dropdown under userName");
						UtilityMethods.get().waitForPageLoad();
						EventMethods.get().clickLink(UtilityMethods.get().getBy_from_Repository("uesrSettings"));
						writeLog("Pass", "Take screen shot for user settings ", "Settings menu  populated", "Settings clicked");
						UtilityMethods.get().waitForPageLoad();
				EventMethods.get().clickElement(UtilityMethods.get().getBy_from_Repository("DeleteAccount"), "Clicking on Associtation link on profile page");
				 }catch (NoSuchElementException e) {
					 new SkipException("Execution terminated as Application was not launched. ");
				}	
				UtilityMethods.get().waitForPageLoad();
				CommonMethods.get().Logout();
				 writeLog("pass", "logout from the application", "user logged out from the application successfully");
			
			}
			
} 
		 
	
	
					 
					 
			 
		
	
	
	


