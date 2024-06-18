package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.DashboardPage;
import com.orangehrmlive.demo.pages.HomePage;
import com.orangehrmlive.demo.pages.LoginPage;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class LoginTest extends BaseTest {
    LoginPage loginPage;
    HomePage homePage;
    DashboardPage dashboardPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        dashboardPage = new DashboardPage();

    }

    @Test(groups = {"sanity", "smoke", "regression"})
    public void verifyUserShouldLoginSuccessFully() {
        loginPage.loginToApp("Admin", "admin123");          //login
    }

    @Test(groups = {"smoke", "regression"})
    public void verifyThatTheLogoDisplayOnHomePage() {
        loginPage.loginToApp("Admin", "admin123");          //login
        Assert.assertEquals(homePage.isLogoDisplayed(), true);        //verify logo is displayed
    }

    @Test(groups = {"regression"})
    public void verifyUserShouldLogOutSuccessFully() {
        loginPage.loginToApp("Admin", "admin123");          //login
        dashboardPage.clickOnUserProfileLogo();
        dashboardPage.mouseHoverToLogOutLinkAndClick();
    }

    @Test(groups = {"regression"}, dataProvider = "loginData", dataProviderClass = TestData.class)
    public void verifyErrorMessageWithInvalidCredentials(String username, String pwd, String errorMsg) {
        loginPage.loginToApp(username,pwd);          //login
        Assert.assertEquals(loginPage.getLoginErrorMsg(), errorMsg);
    }
}
