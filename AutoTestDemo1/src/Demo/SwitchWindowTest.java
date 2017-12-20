package Demo;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SwitchWindowTest {
	WebDriver driver;
	String baseUrl;
  @Test
  public void switchWindowTest() throws InterruptedException {
	  //��ȡ��ǰ����title
	  String currentHandle = driver.getWindowHandle();
	  String oldTitle = driver.getTitle();
	  System.out.println("��ת���µĴ��ڣ��´��ڵ�title��"+oldTitle);
	  //�ȴ�3s
	  Thread.sleep(4000);
	  //��λ���´��ڰ�ť
	 // WebElement openWindowButton = driver.findElement(By.xpath("//button[contains(text(),'���´���')]"));
	  //openWindowButton.click();
	  //---���µ�tab
	  WebElement openTabBtn = driver.findElement(By.id("opentab"));
	  openTabBtn.click();
	  Set<String> handles = driver.getWindowHandles();
	  //�õ��´��ھ��,��ת���´���
	  for(String newHandle:handles) {
		  if (newHandle!=currentHandle)
		  {
			  driver.switchTo().window(newHandle);
			  System.out.println("--------��λ���´���-------");
		  }
	  }
	  //�õ��´��ڵ�title
	  String newTitle = driver.getTitle();
	  System.out.println("��ת���µĴ��ڣ��´��ڵ�title��"+newTitle);
	  String actualTitle = "Selenium WebDriver�Զ�������Java�� +�������⣨���Ľ��⣩ | Udemy";
	  
	  if(newTitle.contains("�Զ�������Java�� +��������")) {
		  System.out.println("---��ϲ�㣬��ת����ȷ�Ľ���----");
	  }
		  
	  //}
	 
	  
	 
		 
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