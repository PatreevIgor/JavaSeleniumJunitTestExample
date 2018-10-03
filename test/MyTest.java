import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MyTest {
    @Test
    public void testMyExampleTest() throws Exception {
        String property = System.setProperty("webdriver.gecko.driver",
                "C:\\geckodriver-v0.22.0-win64\\geckodriver.exe");
        FirefoxDriver driver=new FirefoxDriver();

        driver.get("http://demo.guru99.com/");
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");

        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();

        Assert.assertTrue(true);
    }
}
