package com.orangehrmlive.demo.pages;

import com.aventstack.extentreports.Status;
import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class AdminPage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-filter-header-title']//h5")
    WebElement systemUserText;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Add']")
    WebElement addButton;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Username']/parent::div/following-sibling::div//input")
    WebElement userNameField;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='User Role']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectUserRoleDropdown;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Status']/parent::div/following-sibling::div//div[@class='oxd-select-wrapper']")
    WebElement selectStatusDropdown;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Search']")
    WebElement searchButton;

    @CacheLookup
    @FindBy(xpath = "//div[@role='columnheader'or normalize-space()='Username'][2]/ancestor::div[@role='rowgroup']/following-sibling::div[@class='oxd-table-body']//div[@class='oxd-table-cell oxd-padding-cell'][2]")
    WebElement searchedUsernameInResult;

    @CacheLookup
    @FindBy(xpath = "//div[@class='oxd-table-card-cell-checkbox']//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']")
    WebElement checkboxOfSearchResultItem;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Delete Selected']")
    WebElement deleteSelectedButton;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Yes, Delete']")
    WebElement yesDeleteButtonOnPopUp;

    @CacheLookup
    @FindBy(xpath = "//label[normalize-space()='Employee Name']/parent::div/following-sibling::div//input")
    WebElement employeeNameField;

    @CacheLookup
    @FindBy(xpath = "//span[normalize-space()='(1) Record Found']")
    WebElement recordsFound;

    @CacheLookup
    @FindBy(xpath = "//button[normalize-space()='Reset']")
    WebElement resetButton;

    public String getSystemUserText(){
        Reporter.log("Getting system users text displayed "+systemUserText.toString());
        CustomListeners.test.log(Status.PASS,"Getting system user text displayed");
        return getTextFromElement(systemUserText);
    }

    public void clickOnAddButton(){
        clickOnElement(addButton);
        Reporter.log("Clicking on Add button "+addButton.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on Add button "+addButton.toString());
    }

    public void setSelectUserRoleDropdown(String role){
        mouseHoverToElementAndClick(selectUserRoleDropdown);
        typeKeysAndEnter(role.split("")[0]);
        Reporter.log("Selecting User roles "+selectUserRoleDropdown.toString()+" as "+role);
        CustomListeners.test.log(Status.PASS,"Selecting the user role "+selectUserRoleDropdown.toString()+" as "+role);
    }

    public void setUserNameField(String uName){
        sendTextToElement(userNameField, uName);
        Reporter.log("Entering the Username "+userNameField.toString()+" as "+uName);
        CustomListeners.test.log(Status.PASS,"Entering the Username"+userNameField.toString()+" as "+uName);
    }

    public void setSelectStatusDropdown(String status){
        mouseHoverToElementAndClick(selectStatusDropdown);
        typeKeysAndEnter(status.split("")[0]);
        Reporter.log("Selecting Status "+selectStatusDropdown.toString()+" as "+status);
        CustomListeners.test.log(Status.PASS,"Selecting the status"+selectStatusDropdown.toString()+" as "+status);
    }

    public void clickOnSearchButton(){
        clickOnElement(searchButton);
        Reporter.log("Clicking on Search button "+searchButton.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on Search button "+searchButton.toString());
    }
    public String getUsernameFromSearchResult(){
        Reporter.log("Getting username from result list."+searchedUsernameInResult.toString());
        CustomListeners.test.log(Status.PASS,"Getting username from result list "+searchedUsernameInResult.toString());
        return getTextFromElement(searchedUsernameInResult);
    }

    public void selectTheCheckboxOfResultingUsername(){
        Reporter.log("Selecting in the checkbox of resulting uername "+checkboxOfSearchResultItem.toString());
        CustomListeners.test.log(Status.PASS,"Selecting in the checkbox of resulting username "+checkboxOfSearchResultItem.toString());
        clickOnElement(checkboxOfSearchResultItem);
    }

    public void clickOnDeleteSelectedButton(){
        Reporter.log("Click on Delete Selected button "+deleteSelectedButton.toString());
        CustomListeners.test.log(Status.PASS,"Click on Delete Selected button "+deleteSelectedButton.toString());
        clickOnElement(deleteSelectedButton);
    }

    public void clickOnYesDeleteButtonOnPopUp(){
        Reporter.log("Click on Yes Delete button on the pop up "+yesDeleteButtonOnPopUp.toString());
        CustomListeners.test.log(Status.PASS,"Click on Yes Delete button on the pop up "+yesDeleteButtonOnPopUp.toString());
        clickOnElement(yesDeleteButtonOnPopUp);
    }

    public void setEmployeeNameField(String empName) throws InterruptedException {
        sendTextToElement(employeeNameField, empName);
        Thread.sleep(5000);
        selectAutoPopulateFirstEntryByArrowKeysAndEnter(employeeNameField);
        Reporter.log("Entering the Employee Name "+employeeNameField.toString()+" as "+empName);
        CustomListeners.test.log(Status.PASS,"Entering the employee Name as "+empName);
    }

    public String getRecordsFound(){
        Reporter.log("Getting the records found. "+recordsFound.toString());
        CustomListeners.test.log(Status.PASS,"Getting the records found. "+recordsFound.toString());
        return getTextFromElement(recordsFound);
    }

    public void clickOnResetButton(){
        clickOnElement(resetButton);
        Reporter.log("Clicking on Reset button "+resetButton.toString());
        CustomListeners.test.log(Status.PASS,"Clicking on Reset button "+resetButton.toString());
    }
}
