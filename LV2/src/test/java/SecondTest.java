import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod ;
import org.testng.annotations.BeforeMethod ;
import org.testng.annotations.Test ;

public class SecondTest {

    public WebDriver driver ;

    public String testURL = "http://www.nba.com";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\Testiranje\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }

    @Test
    public void NBASearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(3000);

        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"onetrust-accept-btn-handler\"]"));
        cookies.click();
        Thread.sleep(3000);

        WebElement games = driver.findElement(By.xpath("//*[@id=\"nav-ul\"]/li[1]/a"));
        games.click();
        Thread.sleep(5000);

        WebElement popup = driver.findElement(By.xpath("/html/body/div[4]/div[2]/button"));
        popup.click();
        Thread.sleep(3000);

        WebElement testLink = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[2]/div[3]/div/div[2]/aside/section/div/div/h2"));
        Assert.assertEquals(testLink.getText(),"Headlines");
        System.out.print(testLink.getText());
    }

    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }

}
