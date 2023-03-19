package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AccountPage {
    private WebDriver driver;
    private By accountNumberSelect = By.id("accountSelect");
    private By deposit = By.xpath(".//div/div/button[@ng-click='deposit()']");
    private By amountToDeposited = By.xpath("//div/input[@type='number']");
    private By submitDepositButton = By.xpath("//form/button[@type='submit']");
    private By balance = By.xpath("//div/strong[@class='ng-binding'][2]");
    private By transactionTab = By.xpath("//div/button[@ng-click='transactions()']");
    private By message = By.xpath(".//div/span[@class='error ng-binding']");
    public AccountPage(WebDriver driver){
        this.driver=driver;
    }
    private Select findAccountFromDropDownElement(){
        WebDriverWait wait =new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(accountNumberSelect));
        return new Select(driver.findElement(accountNumberSelect));
    }

    public void selectAccountFromDropDown(String name){

        findAccountFromDropDownElement().selectByVisibleText(name);
    }
    public void clickDeposit(){
        driver.findElement(deposit).click();
    }
    public void setAmountToBeDeposited(String number){
        WebDriverWait wait =new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(amountToDeposited));
        driver.findElement(amountToDeposited).sendKeys(number);
    }
    public void submitDeposit(){
        driver.findElement(submitDepositButton).click();
    }
    public String getBalance(){
        return driver.findElement(balance).getText();
    }

    public TransactionListPage clickTransactionTab(){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        driver.findElement(transactionTab).click();
        return new TransactionListPage(driver);
    }

}
