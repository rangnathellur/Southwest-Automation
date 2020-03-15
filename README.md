# Southwest-Automation
This automation framework is used to test southwest airline flight booking, It uses Page Object Model. In the main directory there is a base package which contains TestBase class for selenium webriver initialization and opening the SW homepage. And page package which contains SW HomePage, SW Resultspage, and TripandPriceDetailsPage. 
For the flight tests, there is a test package which contains all the classes related to flight reservation. All page classes extend the TestBase class.

Requirement to build and run the tests:
Install maven 3.11.0
Install Java 1.8
TestNG 6.8

Clone and Download the repository.
1.Do a maven clean install
2.On your Java IDE, run the tests using TestNG.

Test cases documentation: All tests are in the test package.
SouthWestTest.java: Below are the tests covered
1. Navigate the browser to www.southwest.com
2. Assert and verify that the browser is on the correct URL
3. On the HomePage, make sure the “Flights” tab is selected.
4. Enter any Departure and Arrival airports and dates. It would be better to select options from the
dropdown rather than sending them directly. Also, using Calendar functionality.
5. Once all the options are filled in, Search for results

SearchResultsTest.java: Below are the tests covered
6.On the SearchResultsPage, validate your inputs (Airports and Dates) to make sure the right search
has been made.
7. Filter by “Nonstop” and validate that only “Nonstop” flights are displayed.
8. Pick any of the flights available and Continue to “TripandPriceDetailsPage.”
9. Validate all the inputs on this page along with the price of the flight which was selected in the
previous page.

