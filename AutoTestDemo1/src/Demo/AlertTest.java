package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertTest {
	WebDriver driver;
	String baseUrl;
  @Test
  public void alertActionTest() throws InterruptedException {
	  	WebElement inputEle;
	  	//定位输入框，输入值
	  	inputEle = driver.findElement(By.cssSelector("input[class='inputs']"));
	  	inputEle.sendKeys("王帅广狗狗");
	  	Thread.sleep(3000);
	  	//定位Alterbutton,并点击
	  	WebElement alertEle = driver.findElement(By.id("alertbtn"));
	  	alertEle.click();
	  	Thread.sleep(3000);
	  	//跳转到alert dialog
	  	Alert alertWinodw = driver.switchTo().alert(); 	
	  	//得到alert框内的内容
	  	String alertText = alertWinodw.getText();
	  	String actualText = "share this practice page and share your knowledge";
	  	if(alertText.contains(actualText)) {
	  		System.out.println("正确的alert window 弹出");
	  	}
	  	//点击ok
	  	alertWinodw.accept();
	  	Thread.sleep(4000);
	  	//--------------------------------------------
	  	//再次定位文本输入框
		inputEle = driver.findElement(By.cssSelector("input[class='inputs']"));
	  	inputEle.sendKeys("狗狗");
	  	WebElement confirmEle = driver.findElement(By.id("confirmbtn"));
	  	confirmEle.click();
	  	Thread.sleep(4000);
	  	Alert confirmAlert = driver.switchTo().alert();
	  	String confirmText = confirmAlert.getText();
	  	String expectText = "Are you sure you want to confirm?";
	  	
	  	if(confirmText.contains(expectText)) {
	  		System.out.println("-----恭喜你，正确打开confirm alert");
	  	}
	  	
	  	Thread.sleep(4000);
	  	confirmAlert.dismiss();
	  	Thread.sleep(4000);
		 
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
	  driver.quit();
  }

}
