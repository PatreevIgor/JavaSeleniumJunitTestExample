import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyTest {
    @Test
    public void testMyExampleTest() throws Exception {
        /*
        String property = System.setProperty("webdriver.gecko.driver",
                "C:\\geckodriver-v0.22.0-win64\\geckodriver.exe");
        FirefoxDriver driver=new FirefoxDriver();
        */

        String property = System.setProperty("webdriver.chrome.driver", "C:\\chromedriver_win32\\chromedriver.exe");
        ChromeDriver driver=new ChromeDriver();

        driver.get("http://demo.guru99.com/");
        WebElement element=driver.findElement(By.xpath("//input[@name='emailid']"));
        element.sendKeys("abc@gmail.com");

        WebElement button=driver.findElement(By.xpath("//input[@name='btnLogin']"));
        button.click();

        int sms_code = 0;

        try {
            //step1 load the driver class
            Class.forName("oracle.jdbc.driver.OracleDriver");

            //step2 create  the connection object
            Connection con=DriverManager.getConnection(
                    "jdbc:oracle:thin:@192.168.12.62:1521:oapits01","mtbapi","mtbapi_1");

            //step3 create the statement object
            Statement stmt=con.createStatement();

            //step4 execute query
            ResultSet rs=stmt.executeQuery("select code from CONFIRMATION_CODE where ID=(select MAX(id) from CONFIRMATION_CODE where phone = '375297379222')");

            while(rs.next())
                //System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));

            sms_code = rs.getInt(1);
            //step5 close the connection object

            con.close();
        }
        catch(Exception e){ System.out.println(e);}


        Assert.assertEquals(7950,sms_code );
    }
}
