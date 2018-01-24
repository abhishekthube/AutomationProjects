package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class selectFlightPage {

	WebDriver driver;

	By selectFlightImage = By.cssSelector("img[src='/images/masts/mast_selectflight.gif']");
	By continueButton = By.name("reserveFlights");
	
    public selectFlightPage(WebDriver driver){
        this.driver = driver;
    }

    //check if previous action was successful
    public Boolean checkFlightFinderSucccess(){
    	return  driver.findElement(selectFlightImage).isDisplayed();
    }

    public void clickContinue(){
    	driver.findElement(continueButton).click();
    }

}
