package testng;

import org.testng.annotations.Test;

import methods.Methods;

public class Tests extends Methods {

//	Methods methods = new Methods();

	@Test
	void testing() {
		System.out.println("Testing started >> ");
		navigateToURL("https://datacom.com/nz/en/contact-us");
		clickCookieButtons("Accept all");
		
		validatePageName("Our locations");

		clickCountry("Australia");
		clickCountry("Asia");
		clickCountry("New Zealand");

		clickCity("Dunedin");

		clickCountry("Asia");
		clickCity("Philippines");

		clickCountry("Australia");
		clickCity("Brisbane");
		verifyAddress("Brisbane", "address", "501 Ann Street, Fortitude Valley, Brisbane, Queensland 4006");

		
		//Negative tests
		clickCountry("Asia");
		verifyAddress("Philippines", "address", "Makati");
		
		closeBrowser();
		
		

	}

//	@Test
//	void negativeTest() {
//		System.out.println("Testing started >> ");
//		navigateToURL("https://datacom.com/nz/en/contact-us");
//		clickCookieButtons("Accept all");
//
//		clickCountry("Asia");
////		clickCity("Philippines");
//		verifyAddress("Philippines", "address", "Makati");
//
//		closeBrowser();
//
//	}

}
