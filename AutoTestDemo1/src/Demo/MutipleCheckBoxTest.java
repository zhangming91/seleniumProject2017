package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class MutipleCheckBoxTest {
	WebDriver driver;
	String baseUrl;
  @Test
  public void mutipleCheckTest() throws InterruptedException {
	  //得到下拉列表框
	  WebElement selectList = driver.findElement(By.id("multiple-select-example"));
	  Select sel = new Select(selectList);
	  
	  //选中下拉列表框中的元素 selectByIndex
	  Thread.sleep(3000);
	  sel.selectByIndex(0);
	  System.out.println("-----选中的元素");
	  
	  //取消选中的元素
	  Thread.sleep(3000);
	  sel.deselectByValue("apple");
	  System.out.println("-----取消选中的元素");
	 
	  //选中多个元素
	  Thread.sleep(3000);
	  sel.selectByVisibleText("桔子");
	  Thread.sleep(3000);
	  sel.selectByVisibleText("桃子");
	  //循环得到选中的元素
	  List<WebElement> options = sel.getAllSelectedOptions();
	  for(WebElement option:options) {
		 System.out.println("选中的元素："+option.getText()); 
	  }
		  
	  //取消所有选中的元素
	  Thread.sleep(3000);
	  sel.deselectAll();
	  System.out.println("-----取消所有选中的元素");
	  List<WebElement> options1 = sel.getOptions();
	  for(WebElement option:options1) {
		  if(option.isSelected()) {
			 System.out.println("----取消所有选中元素的操作失败----"); 
		  }else {
			 System.out.println("----取消所有选中元素的操作成功----");
		  }
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
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}