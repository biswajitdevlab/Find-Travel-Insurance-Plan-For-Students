package TestSuite;

import java.io.IOException;

import org.testng.annotations.Test;

import Pages.CarInsurance;
import Pages.HealthInsurances;
import Pages.TravelInsurance;


public class Travel {
	
	@Test
	public void testing() throws InterruptedException, IOException {
		TravelInsurance ti= new TravelInsurance();
		CarInsurance ci= new CarInsurance();
		HealthInsurances hi= new HealthInsurances();
		ti.driverSetup();
		ti.openUrl();//use either of the methods by commenting others
		ti.travel();
		//ci.openUrl();
		//ci.car();
		//hi.openUrl();
		//hi.list();
		hi.closeBrowser();
	}

}
