package com.orangehrmlive.demo.testsuite;

import com.orangehrmlive.demo.customlisteners.CustomListeners;
import com.orangehrmlive.demo.pages.*;
import com.orangehrmlive.demo.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import resources.testdata.TestData;

@Listeners(CustomListeners.class)
public class UsersTest extends BaseTest {
    HomePage homePage;
    LoginPage loginPage;
    SidePanelNavigationPage sidePanelNavigationPage;
    AdminPage adminPage;
    AddUserPage addUserPage;
    ViewSystemUserPage viewSystemUsersPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt() {
        homePage = new HomePage();
        loginPage = new LoginPage();
        sidePanelNavigationPage = new SidePanelNavigationPage();
        adminPage = new AdminPage();
        addUserPage = new AddUserPage();
        viewSystemUsersPage = new ViewSystemUserPage();
    }

    //1.adminShouldAddUserSuccessFully().
    @Test(groups = {"sanity", "smoke", "regression"})
    public void adminShouldAddUserSuccessFully() throws InterruptedException {
        //Login to Application
        loginPage.loginToApp("Admin", "admin123");
        //click On "Admin" Tab
        sidePanelNavigationPage.clickOnMenuItemLink("Admin");
        //Verify "System Users" Text
        Assert.assertEquals(adminPage.getSystemUserText(), "System Users");
        //click On "Add" button
        adminPage.clickOnAddButton();
        //Verify "Add User" Text
        Assert.assertEquals(addUserPage.getAddUserText(), "Add User");
        //Select User Role "Admin"
        addUserPage.setSelectUserRoleDropdown("Admin");
        //enter Employee Name "Joseph Evans"
        addUserPage.setEmployeeNameField("Joseph");
        // enter Username
        addUserPage.setUserNameField("joseph");
        // Select status "Disable"
        addUserPage.setSelectStatusDropdown("Disable");
        // enter psaaword
        addUserPage.setPasswordField("abcd1234567");
        // enter Confirm Password
        addUserPage.setConfirmPasswordField("abcd1234567");
        // click On "Save" Button
        addUserPage.clickOnSaveButton();
        // verify message "Successfully Saved"
        Assert.assertEquals(addUserPage.getSuccessToastMessage(), "Successfully Saved");
    }

    //2. searchTheUserCreatedAndVerifyIt().
    @Test(groups = {"smoke", "regression"})
    public void searchTheUserCreatedAndVerifyIt() {
        String expectedUsername = "joseph";
        // Login to Application
        loginPage.loginToApp("Admin", "admin123");
        // click On "Admin" Tab
        sidePanelNavigationPage.clickOnMenuItemLink("Admin");
        // Verify "System Users" Text
        Assert.assertEquals(adminPage.getSystemUserText(), "System Users");
        // Enter Username
        adminPage.setUserNameField(expectedUsername);
        // Select User Role
        adminPage.setSelectUserRoleDropdown("Admin");
        // Select Satatus
        adminPage.setSelectStatusDropdown("Disable");
        // Click on "Search" Button
        adminPage.clickOnSearchButton();
        // Verify the User should be in Result list.
        Assert.assertEquals(adminPage.getUsernameFromSearchResult(), expectedUsername);
    }

    //
    //3. verifyThatAdminShouldDeleteTheUserSuccessFully().
    @Test(groups = {"regression"})
    public void verifyThatAdminShouldDeleteTheUserSuccessFully() {
        String expectedUsername = "joseph";
        // Login to Application
        loginPage.loginToApp("Admin", "admin123");
        // click On "Admin" Tab
        sidePanelNavigationPage.clickOnMenuItemLink("Admin");
        // Verify "System Users" Text
        Assert.assertEquals(adminPage.getSystemUserText(), "System Users");
        // Enter Username
        adminPage.setUserNameField(expectedUsername);
        // Select User Role
        adminPage.setSelectUserRoleDropdown("Admin");
        // Select Status
        adminPage.setSelectStatusDropdown("Disable");
        // Click on "Search" Button
        adminPage.clickOnSearchButton();
        // Verify the User should be in Result list.
        Assert.assertEquals(adminPage.getUsernameFromSearchResult(), expectedUsername);
        // Click on Check box
        adminPage.selectTheCheckboxOfResultingUsername();
        // Click on Delete Button
        adminPage.clickOnDeleteSelectedButton();
        // Popup will display Click on Ok Button on Popup
        adminPage.clickOnYesDeleteButtonOnPopUp();
        // verify message "Successfully Deleted"
        Assert.assertEquals(viewSystemUsersPage.getSuccessDeleteToasterMsg(), "Successfully Deleted");
    }

    //
    //4. searchTheUserAndVerifyTheMessageRecordFound().
    @Test(groups = {"regression"}, dataProvider = "usertests", dataProviderClass = TestData.class)
    public void searchTheUserAndVerifyTheMessageRecordFound(String username, String userRole, String employeeName, String status) throws InterruptedException {
        // Login to Application
        loginPage.loginToApp("Admin", "admin123");
        // click On "Admin" Tab
        sidePanelNavigationPage.clickOnMenuItemLink("Admin");
        // Verify "System Users" Text
        Assert.assertEquals(adminPage.getSystemUserText(), "System Users");
        // Enter Username <username>
        adminPage.setUserNameField(username);
        // Select User Role <userRole>
        adminPage.setSelectUserRoleDropdown(userRole);
        // Enter EmployeeName <employeeName>
        adminPage.setEmployeeNameField(employeeName);
        // Select Satatus <status>
        adminPage.setSelectStatusDropdown(status);
        // Click on "Search" Button
        adminPage.clickOnSearchButton();
        // verify message "(1) Record Found"
        Assert.assertEquals(adminPage.getRecordsFound(),"(1) Record Found");
        // Verify username <username>
        Assert.assertEquals(adminPage.getUsernameFromSearchResult(),username);
        // Click on Reset Tab
        adminPage.clickOnResetButton();
    }
}
