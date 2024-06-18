package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AddUserPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='orangehrm-card-container']/h6")
    WebElement addUserText;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectUserRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-autocomplete-text-input--after']")
    WebElement employeeNameAutoComplete;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectStatusDropdown;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement passwordField;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")
    WebElement confirmPasswordField;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Save']")
    WebElement saveButton;

    @CacheLookup
    @FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
    WebElement successToastMessage;

    public String getAddUserText(){
        Reporter.log("Getting Add User text "+addUserText.toString());
        CustomListeners.test.log(Status.PASS,"Getting Add User text");
        return getTextFromElement(addUserText);
    }

    public void setSelectUserRoleDropdown(String role){
        mouseHoverToElementAndClick(selectUserRoleDropdown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("Selecting User roles "+selectUserRoleDropdown.toString()+" as "+role);
        CustomListeners.test.log(Status.PASS,"Selecting the user role as "+role);
    }
    public void setEmployeeNameField(String empName) throws InterruptedException {
        sendTextToElement(employeeNameField, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(employeeNameField);
        Reporter.log("Entering the Employee Name "+employeeNameField.toString()+" as "+empName);
        CustomListeners.test.log(Status.PASS,"Entering the employee Name as "+empName);
    }

    public void setUserNameField(String uName){
        sendTextToElement(userNameField, uName);
        Reporter.log("Entering the Username "+userNameField.toString()+" as "+uName);
        CustomListeners.test.log(Status.PASS,"Entering the Username as "+uName);
    }

    public void setSelectStatusDropdown(String status){
        mouseHoverToElementAndClick(selectStatusDropdown);
        typeKeysAndEnter(status.split("")[0]);
        Reporter.log("Selecting Status "+selectStatusDropdown.toString()+" as "+status);
        CustomListeners.test.log(Status.PASS,"Selecting the status as "+status);
    }

    public void setPasswordField(String pwd){
        sendTextToElement(passwordField,pwd);
        Reporter.log("Entering password "+passwordField.toString());
        CustomListeners.test.log(Status.PASS,"Entering password ");
    }

    public void setConfirmPasswordField(String cpwd){
        sendTextToElement(confirmPasswordField,cpwd);
        Reporter.log("Entering password confirmation "+confirmPasswordField.toString());
        CustomListeners.test.log(Status.PASS,"Entering password confirmation ");
    }
    public void clickOnSaveButton(){
        clickOnElement(saveButton);
        Reporter.log("Clicking on Save button"+saveButton.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on Save button");
    }

    public String getSuccessToastMessage(){
        Reporter.log("Getting success message "+successToastMessage.toString());
        CustomListeners.test.log(Status.PASS,"Getting success message");
        return getTextFromElement(waitForElementWithFluentWait(successToastMessage,10,2));
    }
}
