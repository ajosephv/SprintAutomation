package testcase;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.excelutils;
import utilities.excelutils1;

public class login {

	WebDriver driver;
	
	
	@Test
	public void log() throws IOException
	{
		excelutils1 ex=new excelutils1();
		ArrayList data=ex.getData("xxxxxx");
		

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://edge.globalenglish.com/");
		driver.manage().window().maximize();
		driver.findElement(By.id("accept_cookie")).click();
		driver.findElement(By.xpath("//*[@id='enLang']/span")).click();
		driver.findElement(By.id("username")).sendKeys("5jjan2021");
		driver.findElement(By.id("password")).sendKeys("Welcome1");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		try {
			System.out.println(driver.getTitle());
			driver.findElement(By.linkText("I Agree")).click();
		}
		catch (Exception e)
		{
			e.getMessage();
			System.out.println("agreement already submitted");
		}
		
		try {
			
			driver.findElement(By.xpath("//div[@id='renewal']/div/button")).click();
			System.out.println(driver.getTitle()+" newsfeed is handled");
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			e.getMessage();
			System.out.println(driver.getTitle()+ " newsfeed is already handled");
		}
		
		try {
			
			driver.get("https://home.globalenglish.com/");
			driver.findElement(By.xpath("//a[@title='Sprint']")).click();
			System.out.println(driver.getTitle()+" incomplete profile handled");
			Thread.sleep(5000);
		}
		catch (Exception e)
		{
			e.getMessage();
			System.out.println(driver.getTitle()+ " incompleted profile is already skipped");
		}
		
		
		
		try {
			driver.findElement(By.id("submit")).click();
			System.out.println(driver.getTitle()+" first card is handled");
			
		}
		catch (Exception e)
		{
			e.getMessage();
			System.out.println(driver.getTitle()+ " card 1 already selected ");
		}
		
		WebElement a=driver.findElement(By.id("country"));
		Select country=new Select(a);
		//country.selectByVisibleText("India");
		country.selectByVisibleText((String) data.get(2));
		
		WebElement b=driver.findElement(By.id("state"));
		Select state=new Select(b);
		//state.selectByVisibleText("Tamil Nadu");
		state.selectByVisibleText((String) data.get(3));
		
		WebElement c=driver.findElement(By.id("city"));
		Select city=new Select(c);
		city.selectByVisibleText("Chennai");
		
		WebElement d=driver.findElement(By.id("prefContact"));
		Select prefContact=new Select(d);
		prefContact.selectByVisibleText("Mobile");
		
		driver.findElement(By.id("pref_skype_id")).sendKeys("aarun@aa.com");
		System.out.println(driver.findElement(By.id("submit1")).isEnabled());
		driver.findElement(By.name("Mobile")).sendKeys("7709899099");
		System.out.println(driver.findElement(By.id("submit1")).isEnabled());
		driver.findElement(By.name("Landline")).sendKeys("9900990099");
		
		
		
		
	}
	
	
	
	
	
}
