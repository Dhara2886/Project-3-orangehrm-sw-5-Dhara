package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;
import org.testng.annotations.Listeners;

@Listeners(CustomListeners.class)
public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//span[@class='oxd-userdropdown-tab']")
    WebElement userProfileLogo;

    @CacheLookup
    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement logoutButton;

    public boolean isLogoDisplayed() {
        Reporter.log("click on " + userProfileLogo);
        CustomListeners.test.log(Status.PASS, "click on " + userProfileLogo);
        return userProfileLogo.isDisplayed();
    }

    public void clickOnLogoutButton() {
        clickOnElement(logoutButton);
        Reporter.log("click on " + logoutButton);
        CustomListeners.test.log(Status.PASS, "click on " + logoutButton);
    }
}
