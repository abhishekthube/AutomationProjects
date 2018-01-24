package pageObjects;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class flightFinderPage {

    WebDriver driver;

    By tripType = By.name("tripType");
    By oneWayRadio = By.cssSelector("input[value='oneway']");
    By fromDropDown = By.name("fromPort");
    By toDropDown = By.name("toPort");
    By firstClassRadio = By.cssSelector("input[value='First']");
    By continueButton = By.name("findFlights");
    
    
    public flightFinderPage(WebDriver driver){
        this.driver = driver;
    }

   //check if previous action was successful
    public Boolean checkLoginSuccess(){
    	return  driver.findElement(tripType).isDisplayed();
    }

    public void selectOneWay(){
    	driver.findElement(oneWayRadio).click();
    }
    
    public void selectDepartFrom(String strFrom){
    	Select objSelect = new Select (driver.findElement(fromDropDown));
    	objSelect.selectByValue(strFrom);
    }
    
    public void selectDepartTo(String strTo){
    	Select objSelect = new Select (driver.findElement(toDropDown));
    	objSelect.selectByValue(strTo);
    }
    
    public void selectFirstClass(){
    	driver.findElement(firstClassRadio).click();
    }

    public void clickContinue(){
    	driver.findElement(continueButton).click();
    }

}