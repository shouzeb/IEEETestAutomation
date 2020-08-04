import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PintersetTestAutomation {
    public static WebDriver driver;
    @BeforeClass
    public static void StartingDriver(){
        System.setProperty("webdriver.gecko.driver","D:\\java\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.get("https://www.ieee.org/");
        driver.manage().window().maximize();

    }
@AfterClass
    public static void QuitDriver(){
        driver.quit();
    }
    //Entering invalid email
    @Test
    public void signUp_1() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"page-header\"]/div[2]/div[1]/div/div/div[2]/div[1]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"mn-calink-link\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys("abcd");
        driver.findElement(By.xpath("//*[@id=\"ca-bottom\"]/div/div/div[2]/div[2]/div[1]/div/label")).click();
        String actual=driver.findElement(By.cssSelector("#createCustEmailId > div:nth-child(1) > div:nth-child(3)")).getText();
        String expected="Please enter a valid email address";
        //System.out.println(actual);
        Assert.assertEquals(actual,expected);
    }
    //Entering confirm password which don't match to password
    @Test
    public void signUp_2() throws InterruptedException {
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys("shouzeb@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"accountRegPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("abcd@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"ca-bottom\"]/div/div/div[2]/div[2]/div[1]/div/label")).click();
        String actual=driver.findElement(By.cssSelector("div.col-xs-12:nth-child(4) > div:nth-child(1) > div:nth-child(3)")).getText();
        String expected="Passwords do not match";
        //System.out.println(actual);
        Assert.assertEquals(actual,expected);

    }

    @Test
    //Entering no last name
    public void signUp_3() throws InterruptedException {
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("FirstName");

        driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys("shouzebhasan@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"accountRegPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"ca-bottom\"]/div/div/div[2]/div[2]/div[1]/div/label")).click();
        String actual=driver.findElement(By.cssSelector("div.col-sm-4:nth-child(3) > div:nth-child(1) > div:nth-child(3)")).getText();
        String expected="Please enter a last / surname";
        System.out.println(actual);
        Assert.assertEquals(actual,expected);

    }
    @Test
    //Entering everything perfectly but signup fails
    public void signUp_4() throws InterruptedException {
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys("shouzebhasan9@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"accountRegPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"ca-bottom\"]/div/div/div[2]/div[2]/div[1]/div/label")).click();
        String actual=driver.findElement(By.cssSelector("#validationErrors > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();

        //String expected="sign in to your existing IEEE account";
        //System.out.println(actual);
        //Assert.assertEquals(actual,expected);

    }
    @Test
    //Entering same password in both password fields but signup fails
    public void signUp_5() throws InterruptedException {
        driver.navigate().refresh();

        driver.findElement(By.xpath("//*[@id=\"firstName\"]")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id=\"lastName\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"emailId\"]")).sendKeys("shouzebhasan9@gmail.com");
        driver.findElement(By.xpath("//*[@id=\"accountRegPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"confirmPassword\"]")).sendKeys("Check123");
        driver.findElement(By.xpath("//*[@id=\"ca-bottom\"]/div/div/div[2]/div[2]/div[1]/div/label")).click();
        String actual=driver.findElement(By.cssSelector("#validationErrors > ul:nth-child(1) > li:nth-child(1) > a:nth-child(1)")).getText();
        //String expected="sign in to your existing IEEE account";
        //System.out.println(actual);
        //Assert.assertEquals(actual,expected);

    }



}
