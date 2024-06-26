package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.Status;

import Base.Base;

public class TravelInsurance extends Base{
	
	By travel=By.xpath("//p[text()='Travel']");
	By search=By.id("country");
	By germany=By.xpath("//p[text()='Germany']");
	By nxt=By.xpath("//button[text()='Next']");
	By no=By.xpath("//label[text()='2']");
	By traveller0=By.xpath("(//*[@id='feet'])[1]");
	By traveller1=By.xpath("(//*[@id='feet'])[2]");
	By clik=By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[1]/div/div[1]/div/div/input");
	By start=By.xpath("//button[@aria-label='Dec 21, 2022']");
	By end=By.xpath("//button[@aria-label='Dec 26, 2022']");
	By med=By.id("ped_no");
	By proceed=By.xpath("//*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button");
	By mobile=By.id("mobileNumber");
	By proceed2=By.xpath("//button[contains(text(),'View plans')]");////*[@id=\"prequote-wrapper\"]/div[2]/div/div[2]/button
	By student=By.id("student-trip-desktop");
	By stud_visa1=By.xpath("//label[text()='Traveller 1 (22 yrs)']");
	By stud_visa2=By.xpath("//label[text()='Traveller 2 (21 yrs)']");
	By days=By.id("feet");
	By apply=By.xpath("//button[text()='Apply']");
	By sortby=By.xpath("//*[@id=\"root\"]/div/div[2]/ul/li[2]/a");
	By low=By.id("low");
	By comp=By.xpath("//*[@id=\"root\"]/div/div[3]/section/article/div/div/div/div[2]/p[1]");
	By pack=By.xpath("//*[@id=\"root\"]/div/div[3]/section/article/div/div/div/div[2]/p[2]");
	By price=By.xpath("//*[@id=\"root\"]/div/div[3]/section/article/div/div/div/div[4]/p/span");
	
	public void travel() throws InterruptedException {
		
		exttest = report.createTest("To Show Student Travel Insurance Plan ");
		
		driver.findElement(travel).click();
		driver.findElement(search).sendKeys("Germany");
		wait(20, germany);
		driver.findElement(germany).click();
		driver.findElement(nxt).click();
		driver.findElement(clik).click();
		wait(20, start);
		driver.findElement(start).click();
		Thread.sleep(2000);
		driver.findElement(end).click();
		driver.findElement(nxt).click();
		driver.findElement(no).click();
		Select age = new Select(driver.findElement(traveller0));
		age.selectByVisibleText("22 years");
		Select age1 = new Select(driver.findElement(traveller1));
		age1.selectByVisibleText("21 years");
		Thread.sleep(2000);
		driver.findElement(nxt).click();
		driver.findElement(med).click();
		driver.findElement(proceed).click();
		wait(20, mobile);
		driver.findElement(mobile).sendKeys("8600495369");
		wait(20, proceed2);
		Thread.sleep(3000);
		driver.findElement(proceed2).click();
		Thread.sleep(5000);
		exttest.log(Status.PASS, "Details are provided Successfully");
		wait(20, student);
		driver.findElement(student).click();
		Thread.sleep(5000);
		driver.findElement(stud_visa1).click();
		driver.findElement(stud_visa2).click();
		Select visadays = new Select(driver.findElement(days));
		visadays.selectByVisibleText("30 Days");
		driver.findElement(apply).click();
		driver.findElement(sortby).click();
		driver.findElement(low).click();
		driver.findElement(apply).click();
		System.out.println("-----------------------------------------------------");
		System.out.println("      The Student Travel Insurance Plans are: ");
		System.out.println("-----------------------------------------------------");
		List<WebElement> companies=driver.findElements(comp);
		List<WebElement> packs=driver.findElements(pack);
		List<WebElement> prices=driver.findElements(price);
		Thread.sleep(3000);
		for(int j=0;j<3;++j){
			System.out.println(companies.get(j).getText()+" - "+packs.get(j).getText()+" - "+prices.get(j).getText());
		}
		exttest.log(Status.PASS, "The Insurance Plans are obtained");
		Thread.sleep(1000);
	}
}