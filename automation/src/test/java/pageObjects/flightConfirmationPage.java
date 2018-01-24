package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class flightConfirmationPage {

	WebDriver driver;
	
	By flightConfirmationImage = By.cssSelector("img[src='/images/masts/mast_confirmation.gif']");
	
	public flightConfirmationPage(WebDriver driver){
		this.driver = driver;
	}

	//check if previous action was successful
    public Boolean checkBookFlightSucccess(){
    	return  driver.findElement(flightConfirmationImage).isDisplayed();
    }
}
