package utiles;

import org.openqa.selenium.WebDriver;

public class WindowManger {
    private WebDriver driver;
    public WindowManger(WebDriver driver){
        this.driver=driver;
    }

    public void switchToNewTab(){
        var window =driver.getWindowHandles();
        window.forEach(driver.switchTo()::window);
    }
}
