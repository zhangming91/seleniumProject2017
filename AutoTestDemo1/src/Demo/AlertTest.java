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
	  	//��λ���������ֵ
	  	inputEle = driver.findElement(By.cssSelector("input[class='inputs']"));
	  	inputEle.sendKeys("��˧�㹷��");
	  	Thread.sleep(3000);
	  	//��λAlterbutton,�����
	  	WebElement alertEle = driver.findElement(By.id("alertbtn"));
	  	alertEle.click();
	  	Thread.sleep(3000);
	  	//��ת��alert dialog
	  	Alert alertWinodw = driver.switchTo().alert(); 	
	  	//�õ�alert���ڵ�����
	  	String alertText = alertWinodw.getText();
	  	String actualText = "share this practice page and share your knowledge";
	  	if(alertText.contains(actualText)) {
	  		System.out.println("��ȷ��alert window ����");
	  	}
	  	//���ok
	  	alertWinodw.accept();
	  	Thread.sleep(4000);
	  	//--------------------------------------------
	  	//�ٴζ�λ�ı������
		inputEle = driver.findElement(By.cssSelector("input[class='inputs']"));
	  	inputEle.sendKeys("����");
	  	WebElement confirmEle = driver.findElement(By.id("confirmbtn"));
	  	confirmEle.click();
	  	Thread.sleep(4000);
	  	Alert confirmAlert = driver.switchTo().alert();
	  	String confirmText = confirmAlert.getText();
	  	String expectText = "Are you sure you want to confirm?";
	  	
	  	if(confirmText.contains(expectText)) {
	  		System.out.println("-----��ϲ�㣬��ȷ��confirm alert");
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
