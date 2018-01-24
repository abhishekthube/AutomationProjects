package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class bookFlightPage {

	WebDriver driver;	
	
	
	By bookFlightImage = By.cssSelector("img[src='/images/masts/mast_book.gif']");
	
	By firstName = By.name("passFirst0");
	By lastName = By.name("passLast0");
	By creditNumber =  By.name("creditnumber");
	By ticketlessCheckbox = By.name("ticketLess");
	By buyFlightsButton = By.name("buyFlights");
	
	
	//check if previous action was successful
    public Boolean checkSelectFlightSucccess(){
    	return  driver.findElement(bookFlightImage).isDisplayed();
    }
	
	public bookFlightPage(WebDriver driver){
		this.driver=driver ;
	}
	
	public void setFirstName(String strFirstName){
		driver.findElement(firstName).sendKeys(strFirstName);
	}
	
	public void setLastName(String strLastName){
		driver.findElement(lastName).sendKeys(strLastName);
	}
	
	public void setCreditNumber(String strCreditNumber){
		driver.findElement(creditNumber).sendKeys(strCreditNumber);
	}
		
	public void setTicketless(){
		driver.findElement(ticketlessCheckbox).click();
	}
	
	public void clickSecurePurchase(){
		driver.findElement(buyFlightsButton).click();
	}
	
}
