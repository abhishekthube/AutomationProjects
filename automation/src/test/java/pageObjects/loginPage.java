package pageObjects;


import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

public class loginPage {

    WebDriver driver;

    By userName = By.name("userName");
    By password = By.name("password");
    By login = By.name("login");

    public loginPage(WebDriver driver){
        this.driver = driver;
    }

//populate username
    public void setUserName(String strUserName){
        driver.findElement(userName).sendKeys(strUserName);
    }

  //populate password    
    public void setPassword(String strPassword){
         driver.findElement(password).sendKeys(strPassword);
    }

  //click on login button
    public void clickLogin(){
            driver.findElement(login).click();
    }

//login
    public void loginMercuryTours(String strUserName,String strPasword){

        this.setUserName(strUserName);
        this.setPassword(strPasword);
        this.clickLogin();
    }

}
