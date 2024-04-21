package Pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;

import com.aventstack.extentreports.Status;

import Base.Base;

public class CarInsurance extends Base{
	
	By car=By.xpath("/html/body/main/div[2]/section/div[4]/a/div[1]/p");
	By proceed=By.xpath("//a[@class=\"btn-proceed\"]");
	By no=By.xpath("//*[@id=\"searchInput\"]/div/input");
	By select=By.id("react-autowhatever-1");
	By comp=By.xpath("//input[@placeholder='Search car brand']");
	By fuel=By.id("Diesel");
	By variant=By.xpath("//*[text()='CRDI (1493 cc)']");
	By year=By.xpath("//*[text()='2018']");
	By name=By.id("name");
	By email=By.id("email");
	By mobileNo=By.id("mobileNo");
	By ViewPrices=By.xpath("//*[@id=\"btnLeadDetails\"]/span");
	By error1=By.xpath("//div[@class='msg-error show']");
	By error2=By.xpath("//*[@id=\"dvVariant\"]/div[2]/div[1]/div[3]/div[2]");
	
	public void car() throws InterruptedException, IOException {
		
		exttest = report.createTest("To Display Error Messages in Car Insurance");
	
		driver.findElement(car).click();
		driver.findElement(proceed).click();
		driver.findElement(no).sendKeys("MH24");
		wait(20, select);
		driver.findElement(select).click();
		driver.findElement(comp).sendKeys("accent");
		wait(20, select);
		driver.findElement(select).click();
		Thread.sleep(2000);
		driver.findElement(fuel).click();
		driver.findElement(variant).click();
		driver.findElement(year).click();
		exttest.log(Status.PASS, "Items are being Selected");
		driver.findElement(name).sendKeys("Komal");
		driver.findElement(email).sendKeys("Komal@gmail");
		driver.findElement(mobileNo).sendKeys("1234567890");
		driver.findElement(ViewPrices).click();
		Thread.sleep(2000);
		System.out.println("--------------------------------------------");
		System.out.println("         The Error Message is: ");
		System.out.println("--------------------------------------------");
		System.out.println(driver.findElement(error1).getText());
		System.out.println(driver.findElement(error2).getText());
		
		TakesScreenshot src = (TakesScreenshot)driver;
		File ss = src.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\lenovo\\Downloads\\FindTravelInsurancePlan\\FindTravelInsurance\\Screenshot\\screenshot.png");
		FileHandler.copy(ss,dest);
		
		exttest.log(Status.PASS, "Errors are obtained");
		
		Thread.sleep(2000);
	}
}
