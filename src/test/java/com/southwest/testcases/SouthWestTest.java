package com.southwest.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.southwest.base.TestBase;
import com.southwest.pages.SouthwestPage;

public class SouthWestTest extends TestBase {
	
	SouthwestPage southwestPage;
	   
	public SouthWestTest(){
			super();
	}
	
	@BeforeMethod
	public void setUp() throws Throwable {
		initialization();
		southwestPage = new SouthwestPage();
	}

	//Assert and verify that the browser is on the correct URL
	@Test
	public void verifyURL(){
		String URL = driver.getCurrentUrl();
		Assert.assertEquals(URL, "https://www.southwest.com");
	}
	
	//On the HomePage, make sure the “Flights” tab is selected.
	@Test
	public void verifyFlightsTabDefault(){
		Assert.assertEquals(southwestPage.isFlightDefault(), true);
	}
	
	
	//	Enter any Departure and Arrival airports and dates. It would be better to select options from the
	//	dropdown rather than sending them directly. Also, using Calendar functionality would be a plus.
	//  Once all the options are filled in, Search for results
	@Test
	public void searchFlight(){
		southwestPage.searchFlight("SFO","MDW");
	}
	
	@AfterMethod
	public void tearDown(){
		driver.close();
	}
	
}
