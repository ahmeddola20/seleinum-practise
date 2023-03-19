package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.*;
import utiles.WindowManger;
public class BaseTests {
    private WebDriver driver;

    protected HomePage homePage;
    protected LoginPage loginPage;
    protected CustomerPage customerPage;
    protected AccountPage accountPage;
    protected TransactionListPage transactionListPage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","resources/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("https://www.way2automation.com/protractor-angularjs-practice-website.html");
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        loginPage =new LoginPage(driver);
        customerPage =new CustomerPage(driver);
        accountPage = new AccountPage(driver);
        transactionListPage=new TransactionListPage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    public WindowManger getWindowManger(){
        return new WindowManger(driver);
    }

}
