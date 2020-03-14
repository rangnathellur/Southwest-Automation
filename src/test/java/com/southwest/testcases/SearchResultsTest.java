package com.southwest.testcases;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.southwest.base.TestBase;
import com.southwest.pages.SouthwestPage;
import com.southwest.pages.SouthwestSearchResultsPage;
import com.southwest.pages.TripandPriceDetailsPage;

public class SearchResultsTest extends TestBase {
	
	SouthwestSearchResultsPage southwestSearchResultsPage;
	SouthwestPage southwestPage;
	TripandPriceDetailsPage tripandPriceDetailsPage;
	
	public SearchResultsTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Throwable {
		initialization();
		southwestSearchResultsPage = new SouthwestSearchResultsPage();
		southwestPage = new SouthwestPage();
		tripandPriceDetailsPage = new TripandPriceDetailsPage();
		southwestPage.searchFlight("SFO","MDW");
	}
	
	//On the SearchResultsPage, validate your inputs (Airports and Dates) to make sure the right search
	//has been made.
	@Test
	public void verifySearchResultsPage(){
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		calendar.set(Calendar.DAY_OF_MONTH, 30);
		int newdate = calendar.get(Calendar.DAY_OF_MONTH);
		Assert.assertEquals(southwestSearchResultsPage.verifyDepartCity(), "SFO");
		Assert.assertEquals(southwestSearchResultsPage.verifyArrivalCity(), "MDW");
		Assert.assertEquals(southwestSearchResultsPage.verifyDepartDate(), southwestPage.getCurrentDay());
		Assert.assertEquals(southwestSearchResultsPage.verifyArrivalDate(), newdate);
	}
	
	//Filter by “Nonstop” and validate that only “Nonstop” flights are displayed.
	@Test
	public void verifyNonStopFlights(){
		waitForElementTodisplay(southwestSearchResultsPage.getNonstopbtn());
		southwestSearchResultsPage.clickNonStop();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertTrue(southwestSearchResultsPage.validateNonstop());
	}
	
	//Pick any of the flights available and Continue to “TripandPriceDetailsPage.”
	//Validate all the inputs on this page along with the price of the flight which was selected in the
	//previous page.
	public void pickFlightContinue(){
		waitForElementTodisplay(southwestSearchResultsPage.getNonstopbtn());
		southwestSearchResultsPage.clickNonStop();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		southwestSearchResultsPage.clickSelectPrice();
		southwestSearchResultsPage.clickContinue();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		Assert.assertEquals(tripandPriceDetailsPage.verifyDepartCity(), "SFO");
		Assert.assertEquals(tripandPriceDetailsPage.verifyArrivalCity(),"MDW");
		Assert.assertEquals(tripandPriceDetailsPage.verifyDepartDate(),southwestPage.getCurrentDay());
		Assert.assertEquals(tripandPriceDetailsPage.getFlightPrice(), 206.96);
		
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
}
