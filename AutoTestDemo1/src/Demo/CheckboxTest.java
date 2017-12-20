package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class CheckboxTest {
	WebDriver driver;
	String baseUrl;
  @Test
  public void radioButtonTest() throws InterruptedException {
	  //Ñ¡ÔñÆ»¹û,éÙ×Ó
	  WebElement radioEle = driver.findElement(By.id("applecheck"));
	  WebElement radioEle1 = driver.findElement(By.id("orangecheck"));
	  if(!radioEle.isSelected()) {
		  radioEle.click();
	  }
	  if(!radioEle1.isSelected()) {
		  radioEle1.click();
	  }
	  
	 
		 
  }
  @BeforeClass
  public void beforeClass() {
	    baseUrl = "file:\\E:\\workspace\\AutoTestDemo1\\htmldoc\\PracticePage.html";
	    System.setProperty("webdriver.chrome.driver","E:\\workspace\\AutoTestDemo1\\tools\\chromedriver.exe");
	    driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
  }

  @AfterClass
  public void afterClass() {
  }

}