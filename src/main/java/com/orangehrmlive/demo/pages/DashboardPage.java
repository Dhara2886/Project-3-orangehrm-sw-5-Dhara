package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;


public class DashboardPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-topbar-header-title']//h6")
    WebElement dashboardHeading;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-brand-banner']//img")
    WebElement logoElement;

    @CacheLookup
    @FindBy(xpath = "//img[@class='oxd-userdropdown-img']")
    WebElement userProfileImage;

    @CacheLookup
    @FindBy(linkText = "Logout")
    WebElement logOutLink;

    public String getDashboardHeading(){
        Reporter.log("Getting the Dashboard page heading "+ dashboardHeading.toString());
        CustomListeners.test.log(Status.PASS,"Getting dashboard page heading. ");
        return getTextFromElement(dashboardHeading);
    }

    public boolean isLogoDisplayed(){
        Reporter.log("Checking the logo is displayed "+ logoElement.toString());
        CustomListeners.test.log(Status.PASS,"Logo is displayed on home page.");
        return logoElement.isDisplayed();
    }

    public void clickOnUserProfileLogo(){
        clickOnElement(userProfileImage);
        Reporter.log("Clicking on user profile image "+userProfileImage.toString());
        CustomListeners.test.log(Status.PASS,"User clicked on user profile image");
    }

    public void mouseHoverToLogOutLinkAndClick(){
        mouseHoverToElementAndClick(logOutLink);
        Reporter.log("Clicking on logout link "+logOutLink.toString());
        CustomListeners.test.log(Status.PASS,"Click on log out link");
    }

}
