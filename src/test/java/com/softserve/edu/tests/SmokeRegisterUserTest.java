package com.softserve.edu.tests;

import com.softserve.edu.data.*;
import com.softserve.edu.rs.pages.*;
import com.softserve.edu.rs.pages.ATopPage.ChangeLanguageFields;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class SmokeRegisterUserTest {

	@DataProvider(parallel = true)
	public Object[][] getApplicationSources(ITestContext context) {
		return new Object[][] {
				{ ParameterUtils.get().updateApplicationSources(
						ApplicationSourcesRepository.getChromeHerokuApplication(), context),
						UserRepository.get().getAdmin() },
		};
	}

	@Test(dataProvider = "getApplicationSources")
	public void checkAdminLogin2(ApplicationSources applicationSources, IUser adminUser) throws Exception {
		// For parallel
		SoftAssert softAssert = new SoftAssert();
		// Precondition
		Application application = Application.get(applicationSources);
		//
		// Steps

		LoginPage loginPage = application.load();
		AdminHomePage adminHomePage = loginPage.successAdminLogin(adminUser);
		//
		// Check
		softAssert.assertEquals(adminHomePage.getLoginAccountText(), adminUser.getLogin());
		Thread.sleep(1000);
		//
		RegisteredUsersHomePage registeredUsersHomePage = adminHomePage.gotoRegisteredUsers();
		softAssert.assertEquals(registeredUsersHomePage.getSendButtonText(),RegisteredUsersHomePage.RegisteredUsersHomePageL10n.SEND_BUTTON.getLocalization(registeredUsersHomePage.getSelectedLanguage()));
		// Return to previous state
		//loginPage = adminHomePage.logout();
		/*softAssert.assertEquals(loginPage.getLoginLabelText(),
				LoginPage.LoginPageL10n.LOGIN_LABEL.getLocalization(loginPage.getSelectedLanguage()));
		//
		*/
		Thread.sleep(1000);

		application.quit();
		softAssert.assertAll();
	}
}
