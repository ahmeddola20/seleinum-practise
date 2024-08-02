import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class OpenBrowserSoftAssert {
    WebDriver driver = null;

    @BeforeTest
    public void OpenBrowser() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ahmed\\IdeaProjects\\MavenFWD\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver(); // Initialize the class-level driver
        driver.manage().window().maximize();
        Thread.sleep(3000);
    }

    @Test
    public void validData() throws InterruptedException {
        driver.navigate().to("https://the-internet.herokuapp.com/login"); // Add navigation to the URL
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER); // Act as we hit the submit button
        Thread.sleep(1000);

    // soft Assertion


        SoftAssert soft = new SoftAssert();

//        // first asserstion
//        System.out.println(" 1ST assertion ");
//        String expectedResult = "You logged into a secure area!";           // the string with no spaces to success
//        String actualResult = driver.findElement(By.id("flash")).getText().trim(); // using trim to avoid leading or trailing spaces or newlines
//        soft.assertEquals(actualResult.contains(expectedResult),"First Assertion Failed: Login success message not found ");
//        Thread.sleep(1000);
// SEcnd asserstion
        System.out.println(" 2nd assertion ");
       soft.assertTrue(driver.findElement(By.cssSelector("a[href=\"/logout\"]")).isDisplayed(), "Second Assertion Failed: Logout link not displayed");

// therd asserstion
        System.out.println(" 3rd assertion ");
        soft.assertEquals(driver.getCurrentUrl(),"https://the-internet.herokuapp.com/secure","Third Assertion Failed: URL mismatch after login"); // /secure
// assert all       to show us the failed assert
        soft.assertAll();
    }

    //@Test
    public void invalidData() {
        driver.navigate().to("https://the-internet.herokuapp.com/login"); // Add navigation to the URL
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecret");
        driver.findElement(By.id("password")).sendKeys(Keys.ENTER); // Act as we hit the submit button

       // String expectedResult = "You logged into a secure area! ";           // the string with no spaces to success
      //  String actualResult = driver.findElement(By.id("flash")).getText();
      //  Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @AfterTest
    public void CloseDriver() {
        driver.quit();
    }
}
