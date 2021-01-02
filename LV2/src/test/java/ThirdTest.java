import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod ;
import org.testng.annotations.BeforeMethod ;
import org.testng.annotations.Test ;

public class ThirdTest {

    public WebDriver driver ;

    public String testURL = "http://www.ferit.hr";

    @BeforeMethod
    public void setupTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\Testiranje\\chromedriver_win32\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.navigate().to(testURL);
    }

    @Test
    public void FERITSearchTest() throws InterruptedException {
        driver.manage().window().maximize();
        Thread.sleep(4000);

        WebElement fakultet = driver.findElement(By.xpath("//*[@id=\"scrollmenu1\"]"));
        fakultet.click();
        Thread.sleep(4000);

        WebElement novosti = driver.findElement(By.xpath("//*[@id=\"div1\"]/ul[1]/li[1]/a"));
        novosti.click();
        Thread.sleep(4000);

        WebElement search = driver.findElement(By.xpath("//*[@id=\"searchString\"]"));
        search.sendKeys( "diplomski");
        Thread.sleep(4000);

        WebElement diplomski = driver.findElement(By.xpath("//*[@id=\"autoSuggestionsList\"]/a[4]"));
        diplomski.click();
        Thread.sleep(6000);

        WebElement title = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h2"));
        Assert.assertEquals(title.getText(),"Sveučilišni diplomski studij");
        System.out.print(title.getText());
    }

    @AfterMethod
    public void teardownTest() {

        driver.quit();
    }


}
