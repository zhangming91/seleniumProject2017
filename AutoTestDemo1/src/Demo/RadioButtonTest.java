package Demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class RadioButtonTest {
	WebDriver driver;
	String baseUrl;
  @Test
  public void radioButtonTest() throws InterruptedException {
	  //ͨ��cssSelector��λԪ��
	  WebElement radioEle = driver.findElement(By.cssSelector("#appleradio"));
	  if(!radioEle.isSelected()) {
		  radioEle.click();
		  System.out.println("��һ��radio��ѡ��");
		  
	  }
	  //ͨ��xpath��λԪ��
	  Thread.sleep(3000);
	  WebElement radioEle1 = driver.findElement(By.xpath("//input[@id='orangeradio']"));
	 if(radioEle.isSelected()) {
		 radioEle1.click();
		 System.out.println("�ڶ���radio��ѡ��");
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
