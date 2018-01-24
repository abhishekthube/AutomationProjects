package testcases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;

//import org.testng.Assert;
//
//import org.testng.annotations.BeforeTest;
//
//import org.testng.annotations.Test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import org.junit.Before;


import pageObjects.*;

public class TestCase {

    WebDriver driver;

    loginPage objLogin;
    flightFinderPage objFlightFinder;
    selectFlightPage objSelectFlight;
    bookFlightPage objBookFlight;
    flightConfirmationPage objFlightConfirmation;

    @Before
    public void setup(){
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://newtours.demoaut.com/mercurywelcome.php");
        driver.manage().window().maximize();
    }

    @After
    public void cleardown(){
        driver.close();
    }

    @Test
    public void book_ticket(){

    //Create page objects
    objLogin = new loginPage(driver);
    objFlightFinder = new flightFinderPage(driver);
    objSelectFlight = new selectFlightPage(driver);
    objBookFlight = new bookFlightPage(driver);
    objFlightConfirmation = new flightConfirmationPage(driver);
    
    //login to application
    objLogin.loginMercuryTours("mercury", "mercury");

    //check login status    
    Assert.assertTrue(objFlightFinder.checkLoginSuccess());

    //Select oneway
    objFlightFinder.selectOneWay();
    
    //select From Sydney
    objFlightFinder.selectDepartFrom("Sydney");
    
    //select to London
    objFlightFinder.selectDepartTo("London");
    
    //Select first class
    objFlightFinder.selectFirstClass();
    
    //click on continue
    objFlightFinder.clickContinue();
    
    //check flight finder action status
    Assert.assertTrue(objSelectFlight.checkFlightFinderSucccess());
    
    //click on continue
    objSelectFlight.clickContinue();
    
    //check select flight action status
    Assert.assertTrue(objBookFlight.checkSelectFlightSucccess());
    
	//Provide a First Name
	objBookFlight.setFirstName("Abhishek");
	
	//Provide a Last Name
	objBookFlight.setLastName("Thube");
	
	//Provide a Credit Card Number
	objBookFlight.setCreditNumber("1234567890");
	
	//Check the Ticketless Travel box.
	objBookFlight.setTicketless();
	
	//Click the Secure Purchase button.
	objBookFlight.clickSecurePurchase();    
    
    //check book flight action status i.e. launch of flight confirmation page
    Assert.assertTrue(objFlightConfirmation.checkBookFlightSucccess());
    
    }
    
}
   