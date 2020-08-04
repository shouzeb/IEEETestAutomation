import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class IEEETestAutomationLogin  {
    public static WebDriver driver;
    @BeforeClass
    public static void StartingDriver(){
        System.setProperty("webdriver.gecko.driver","D:\\java\\geckodriver.exe");
        driver= new FirefoxDriver();
        driver.get("https://www.ieee.org/");
        driver.manage().window().maximize();

    }

    public static void QuitDriver(){
        driver.quit();
    }
    //Entering invalid email
    @Test
    public void logIn_1() throws InterruptedException {

        driver.findElement(By.xpath("//*[@id=\"mn-signin-link\"]")).click();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"modalWindowRegisterSignInBtn\"]")).click();
        String actual=driver.findElement(By.cssSelector(".alert > b:nth-child(1)")).getText();

        String expected="Sign in unsuccessful";
        //System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    //Entering invalid password
    @Test
    public void logIn_2() throws InterruptedException {

        driver.navigate().refresh();
        driver.switchTo().alert().accept();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shouzebhasan99@gamil.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"modalWindowRegisterSignInBtn\"]")).click();
        String actual=driver.findElement(By.cssSelector(".alert > b:nth-child(1)")).getText();

        String expected="Sign in unsuccessful";
        //System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    //No password Entered
    @Test
    public void logIn_3() throws InterruptedException {

        driver.navigate().refresh();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shouzebhasan99@gamil.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"modalWindowRegisterSignInBtn\"]")).click();
        String actual=driver.findElement(By.cssSelector("div.hidden-xs:nth-child(1) > div:nth-child(1)")).getText();

        String expected="IEEE - Sign in to access the secure content";
        //System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }


    //Entering invalid email still home page displayed
    @Test
    public void logIn_4() throws InterruptedException {
//assume test case failed
        driver.navigate().refresh();
        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("FirstName");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"modalWindowRegisterSignInBtn\"]")).click();
        String actual=driver.findElement(By.cssSelector(".alert > b:nth-child(1)")).getText();

        String expected="Sign in unsuccessful";
        //System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }
    //Entering invalid password but still home page displayed
    @Test
    public void logIn_5() throws InterruptedException {
//assume test case failed
        driver.navigate().refresh();

        Thread.sleep(20000);
        driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("shouzebhasan99@gamil.com");
        driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("lastName");
        driver.findElement(By.xpath("//*[@id=\"modalWindowRegisterSignInBtn\"]")).click();
        String actual=driver.findElement(By.cssSelector(".alert > b:nth-child(1)")).getText();

        String expected="Sign in unsuccessful";
        //System.out.println(actual);
        Assert.assertEquals(expected,actual);
    }


}



