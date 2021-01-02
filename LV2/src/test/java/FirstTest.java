import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod ;
import org.testng.annotations.BeforeMethod ;
import org.testng.annotations.Test ;

public class FirstTest {

    public WebDriver driver ;

    public String testURL = "http://www.google.com";

    //----------------------Test Setup-----------------------------------
    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\Testiranje\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }
    @Test
    public void googleSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(3000);

        driver.switchTo().frame(0);
        WebElement cookies = driver.findElement(By.xpath("//*[@id=\"introAgreeButton\"]/span/span"));
        cookies.click();
        Thread.sleep(3000);

        WebElement searchTextBox = driver.findElement(By.name("q"));
        searchTextBox.sendKeys( "instagram");
        searchTextBox.submit();
        Thread.sleep(5000);


        WebElement testLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[1]/div/div/div/div[1]/a/h3/span"));
        Assert.assertEquals(testLink.getText(),"Instagram");
        System.out.print(testLink.getText());
    }
    //---------------Test TearDown-----------------------------------
    @AfterMethod
    public void teardownTest() {
        //Close browser and end the session
        driver.quit();
    }
}
