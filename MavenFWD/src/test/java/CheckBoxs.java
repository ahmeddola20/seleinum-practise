import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.URL;
import java.time.Duration;

public class CheckBoxs {
    WebDriver driver = null ;

        public void openBrowser (){
            //System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\MavenFWD\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(); // Initialize the class-level driver

            driver.get("https://the-internet.herokuapp.com/checkboxes");
            driver.manage().window().maximize();
            //implest wait
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }

     /*   @Test
    public void Test_CheckBox (){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            // Find the checkbox
          //  WebElement checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));
            WebElement checkbox = driver.findElement(By.xpath("//body/div[2]/div[1]/div[1]/form[1]/input[1]"));

            // Check if the checkbox is selected
            if (!checkbox.isSelected()) {
                checkbox.click();
            }

            // Assert that the checkbox is now selected
            Assert.assertTrue(checkbox.isSelected(), "Checkbox is not selected");

        }*/

       // @AfterTest
   /* public void Quit (){
        driver.quit();
        }*/
}
