package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TransactionListPage {
    private WebDriver driver;
    private By amount = By.xpath("//*[@id='anchor0']/td[2]");
    private By transactionType = By.xpath("//*[@id='anchor0']/td[3]");


    public TransactionListPage(WebDriver driver){
        this.driver=driver;
    }
    public String getAmount(){
        return driver.findElement(amount).getText();
    }
    public String getTransactionType(){
        return driver.findElement(transactionType).getText();
    }

}
