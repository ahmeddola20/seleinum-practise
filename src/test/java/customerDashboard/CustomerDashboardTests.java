package customerDashboard;

import base.BaseTests;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.AccountPage;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;


public class CustomerDashboardTests extends BaseTests {
    public WebDriver driver;
    @Test
    public void testDashboard(){
        var homepage =homePage.clickBanking();

        getWindowManger().switchToNewTab();


        var customerLogin = loginPage.clickCustomerLogin();
        customerLogin.selectUserFromDropDown("Ron Weasly");

        var accountPage = customerPage.clickLoginButton();
        accountPage.selectAccountFromDropDown("1008");
        accountPage.clickDeposit();
        accountPage.setAmountToBeDeposited("200");
        accountPage.submitDeposit();
        assertEquals(accountPage.getBalance(),"200","Amount is incorrect");


        var transactionListPage =accountPage.clickTransactionTab();

        assertEquals(transactionListPage.getAmount(),"200","Amount added is not correct");
        assertEquals(transactionListPage.getTransactionType(),"Credit","Transaction Type is not correct");
    }

}