package a;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Task1 {
	public static void main(String args[]) throws InterruptedException {
		
		
		
//		1. Navigate to the FitPeo Homepage:
//			○ Open the web browser and navigate to FitPeo Homepage.
//			2. Navigate to the Revenue Calculator Page:
//			○ From the homepage, navigate to the Revenue Calculator Page.
//			3. Scroll Down to the Slider section:
//			○ Scroll down the page until the revenue calculator slider is
//			visible.
		
	 WebDriver driver=new ChromeDriver();
	 
	 
//		1. Navigate to the FitPeo Homepage:
//		○ Open the web browser and navigate to FitPeo Homepage.
	 driver.get("https://fitpeo.com/");
	 
	 
	 driver.manage().window().maximize();
	 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
	 
//		2. Navigate to the Revenue Calculator Page:
//		○ From the homepage, navigate to the Revenue Calculator Page.
	 driver.findElement(By.xpath("//div[text()=\"Revenue Calculator\"]")).click();
	 
	 //validation Whether the exact page is open or not
	 String rev=driver.findElement(By.xpath("//h5[text()=\"Total Gross Revenue Per Year\"]")).getText();
	 if (rev.equals("Total Gross Revenue Per Year")) {
		 System.out.println("you are in revenue calculator page :)");
	 }
	 
	 
//		3. Scroll Down to the Slider section:
//		○ Scroll down the page until the revenue calculator slider is
//		visible.
	 WebElement ele=driver.findElement(By.cssSelector("[class=\"MuiSlider-root MuiSlider-colorPrimary MuiSlider-sizeMedium css-16i48op\"]"));
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("arguments[0].scrollIntoView({block:'center'})" , ele);
	 


	 
	 
//	WebElement clear_200= driver.findElement(By.cssSelector("[id=\":r0:\"]"));
//	clear_200.click();
//	Thread.sleep(2000);
//	clear_200.clear();
//	Thread.sleep(2000);
//	clear_200.sendKeys("850");
	 

	//4. Adjust the Slider:
			WebDriverWait mywait=new WebDriverWait(driver, Duration.ofSeconds(25));
			mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='number' and @id=':r0:']")));
			driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).clear();
			driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).sendKeys("820");
			Thread.sleep(8000);
			//5 and 6 Update the Text Field:
			driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).clear();
			driver.findElement(By.xpath("//input[@type='number' and @id=':r0:']")).sendKeys("560");

	
	
//	7. Select CPT Codes:
//		Scroll down further and select the checkboxes for CPT-99091,
//		CPT-99453, CPT-99454, and CPT-99474.
	
	driver.findElement(By.xpath("//p[.=\"CPT-99091\"]/parent::div//input[@type=\"checkbox\"]")).click();
	driver.findElement(By.xpath("//p[.=\"CPT-99453\"]/parent::div//input[@type=\"checkbox\"]")).click();
	driver.findElement(By.xpath("//p[.=\"CPT-99454\"]/parent::div//input[@type=\"checkbox\"]")).click();
	
//	8. Validate Total Recurring Reimbursement:
	
	String rr= driver.findElement(By.xpath("//p[.=\"Total Recurring Reimbursement for all Patients Per Month\"]/following-sibling::p")).getText();
//	System.out.println(rr.getText());
	String trr_header=driver.findElement(By.xpath("//p[contains(text(),\"Recurring Reimbursement for all Patients Per Month:\")]/p")).getText();
//	System.out.println(trr_header.getText());
	assertEquals(rr, trr_header,"sucess");
	 
		System.out.println("pass");
	}
	

}
