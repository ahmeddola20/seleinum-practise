package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomerPage {
    private WebDriver driver;
    private By userSelect = By.xpath(".//div/select");
    private By loginButton = By.xpath(".//div/form/button");
    public CustomerPage(WebDriver driver){
        this.driver=driver;
    }
    private Select findUserFromDropDownElement(){
        WebDriverWait wait =new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(userSelect));
        return new Select(driver.findElement(userSelect));
    }
    public void selectUserFromDropDown (String name){
        findUserFromDropDownElement().selectByVisibleText(name);
    }
    public AccountPage clickLoginButton(){
        driver.findElement(loginButton).click();
        return new AccountPage(driver);
    }

}