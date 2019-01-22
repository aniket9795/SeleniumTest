import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class testData {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		
		dataDriven d=new dataDriven();
		ArrayList<String> data=d.getData("Purchase");
		System.out.println(data.get(0));    //To print the value on console
		System.out.println(data.get(1));
		System.out.println(data.get(2));
//		
	/*	 System.setProperty("webdriver.chrome.driver","E:\\My_data\\selenium_setup\\chromedriver_win32\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		   driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		   
		   driver.get("http://www.blazedemo.com/login");
		   
		   driver.findElement(By.xpath("//input[@id='email']")).sendKeys(data.get(1));
			  driver.findElement(By.xpath("//input[@id='password']")).sendKeys(data.get(2));
			  
			  driver.findElement(By.xpath("//input[@name='remember']")).click();
			  driver.findElement(By.xpath("//button[contains(@type,'submit')]")).click();
			  
			 driver.quit();  */
		   
		   
		  
	}

}
