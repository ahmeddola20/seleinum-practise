package pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage {
    public WebDriver driver;
    private By customerLogin = By.xpath(".//div/button[@ng-click='customer()']");
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }

    public CustomerPage clickCustomerLogin(){
        WebDriverWait wait =new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(customerLogin));
        driver.findElement(customerLogin).click();
        return new CustomerPage(driver);
    }

}
