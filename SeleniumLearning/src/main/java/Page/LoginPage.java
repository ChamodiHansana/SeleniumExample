package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;




    //1.Define elements
    By LoginPageValidateText = By.className("barone");
    By UserName = By.name("uid");
    By Password = By.name("password");
    By LoginButton = By.name("btnLogin");
    By FinalValidateText = By.xpath("//*[text()='Manger Id : mngr608607']");


    //2.overload class constructor
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }




    //3. methods


    // method ----- element access methods
    public  void setUserName(String setUser){
        driver.findElement(UserName).sendKeys(setUser);
    }
    public  void setPassword(String setPass){
        driver.findElement(Password).sendKeys(setPass);
    }





    //method ----- validations
    public  String LoginPageValidate(){
        return driver.findElement(LoginPageValidateText).getText();
    }

    public  String LoginValidate(){
        return driver.findElement(FinalValidateText).getText();
    }




    //method ----- button click
    public void LoginButtonClick(){
        driver.findElement(LoginButton).click();
    }


    //method ------ navigate
    public void Navigate(){
        driver.get("https://demo.guru99.com/V4/index.php");
    }



    //4. main login method
    public  void loginToGuru99(String strUserName, String strPass){
        this.setUserName(strUserName);
        this.setPassword(strPass);
        this.LoginButtonClick();

    }


}
