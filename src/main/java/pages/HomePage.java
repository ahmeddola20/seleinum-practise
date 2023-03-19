package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class HomePage {
    private WebDriver driver;
    private By banking = By.xpath(".//div/ul/li/a[@href='https://www.way2automation.com/angularjs-protractor/banking']");

    public HomePage(WebDriver driver) { //Contractor take driver as parameter 
        this.driver = driver;
    }

    public LoginPage clickBanking() {
        driver.findElement(banking).click();
        return new LoginPage(driver);
    }

}
