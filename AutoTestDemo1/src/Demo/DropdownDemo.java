package Demo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/**
 * 
 * @author mingming
 * 
 *
 */

public class DropdownDemo {
	WebDriver driver;
	String baseUrl;

  @Test
  public void dropDownTest() throws InterruptedException {
	  //获取select下拉列表
	  WebElement selEle = driver.findElement(By.id("fruitselect"));	  
	  Select sel = new Select(selEle);
	  //通过selectByIndex赋值------index:2
	  sel.selectByIndex(2);
	  Thread.sleep(3000);
	  //通过selectByValue赋值 --- orange
	  sel.selectByValue("orange");
	  Thread.sleep(3000);
	  //通过selectByVisiableText赋值---apple
	  sel.selectByVisibleText("苹果");
	  Thread.sleep(3000);
	  //通过getOptions，得到下拉列表的值
	  List<WebElement> dropDownOptions = sel.getOptions();
	  int size = dropDownOptions.size();
	  //得到下拉列表的元素
	  for (int i=0;i<size;i++) {
		String optionText= dropDownOptions.get(i).getText();
		System.out.println("下拉列表元素："+ optionText);
		  
	  }
	  //高级for循环
	  for(WebElement e:dropDownOptions) {
		  System.out.println("For对应的元素显示："+e.getText());
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
