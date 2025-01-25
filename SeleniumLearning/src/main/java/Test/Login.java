package Test;
import  Page.*;
import com.google.common.annotations.VisibleForTesting;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login {

       //This is use for undertand new changes in selenoum basics

       WebDriver driver;
       SoftAssert sa;

       //1.create object from page class
       LoginPage objLogin;

       @BeforeTest
       public void setUp(){
              WebDriverManager.chromedriver().setup();
              sa=new SoftAssert();
              driver = new ChromeDriver();
       }

       @Test
       public void login(){
              objLogin=new LoginPage(driver);

              //call navigate method
              objLogin.Navigate();

              //verify that correctly navigated to url
              sa.assertTrue(objLogin.LoginPageValidate().toLowerCase().contains("guru99 bank"));

              //login
              objLogin.loginToGuru99("mngr608607","dutenym");

              //verify after login
              sa.assertTrue(objLogin.LoginValidate().toLowerCase().contains("manger id : mngr608607"));

       }

       @AfterTest
       public void tearDown(){
              driver.close();
              driver.quit();
              sa.assertAll();
       }


}
