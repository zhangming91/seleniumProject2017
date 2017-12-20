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
	  //��ȡselect�����б�
	  WebElement selEle = driver.findElement(By.id("fruitselect"));	  
	  Select sel = new Select(selEle);
	  //ͨ��selectByIndex��ֵ------index:2
	  sel.selectByIndex(2);
	  Thread.sleep(3000);
	  //ͨ��selectByValue��ֵ --- orange
	  sel.selectByValue("orange");
	  Thread.sleep(3000);
	  //ͨ��selectByVisiableText��ֵ---apple
	  sel.selectByVisibleText("ƻ��");
	  Thread.sleep(3000);
	  //ͨ��getOptions���õ������б��ֵ
	  List<WebElement> dropDownOptions = sel.getOptions();
	  int size = dropDownOptions.size();
	  //�õ������б��Ԫ��
	  for (int i=0;i<size;i++) {
		String optionText= dropDownOptions.get(i).getText();
		System.out.println("�����б�Ԫ�أ�"+ optionText);
		  
	  }
	  //�߼�forѭ��
	  for(WebElement e:dropDownOptions) {
		  System.out.println("For��Ӧ��Ԫ����ʾ��"+e.getText());
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
