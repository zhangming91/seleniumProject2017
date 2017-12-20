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
	  //获取当前窗口title
	  String currentHandle = driver.getWindowHandle();
	  String oldTitle = driver.getTitle();
	  System.out.println("跳转到新的窗口，新窗口的title："+oldTitle);
	  //等待3s
	  Thread.sleep(4000);
	  //定位打开新窗口按钮
	 // WebElement openWindowButton = driver.findElement(By.xpath("//button[contains(text(),'打开新窗口')]"));
	  //openWindowButton.click();
	  //---打开新的tab
	  WebElement openTabBtn = driver.findElement(By.id("opentab"));
	  openTabBtn.click();
	  Set<String> handles = driver.getWindowHandles();
	  //得到新窗口句柄,跳转到新窗口
	  for(String newHandle:handles) {
		  if (newHandle!=currentHandle)
		  {
			  driver.switchTo().window(newHandle);
			  System.out.println("--------定位到新窗口-------");
		  }
	  }
	  //得到新窗口的title
	  String newTitle = driver.getTitle();
	  System.out.println("跳转到新的窗口，新窗口的title："+newTitle);
	  String actualTitle = "Selenium WebDriver自动化测试Java版 +面试问题（中文讲解） | Udemy";
	  
	  if(newTitle.contains("自动化测试Java版 +面试问题")) {
		  System.out.println("---恭喜你，跳转到正确的界面----");
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