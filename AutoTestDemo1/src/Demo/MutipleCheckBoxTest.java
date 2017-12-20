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
	  //�õ������б��
	  WebElement selectList = driver.findElement(By.id("multiple-select-example"));
	  Select sel = new Select(selectList);
	  
	  //ѡ�������б���е�Ԫ�� selectByIndex
	  Thread.sleep(3000);
	  sel.selectByIndex(0);
	  System.out.println("-----ѡ�е�Ԫ��");
	  
	  //ȡ��ѡ�е�Ԫ��
	  Thread.sleep(3000);
	  sel.deselectByValue("apple");
	  System.out.println("-----ȡ��ѡ�е�Ԫ��");
	 
	  //ѡ�ж��Ԫ��
	  Thread.sleep(3000);
	  sel.selectByVisibleText("����");
	  Thread.sleep(3000);
	  sel.selectByVisibleText("����");
	  //ѭ���õ�ѡ�е�Ԫ��
	  List<WebElement> options = sel.getAllSelectedOptions();
	  for(WebElement option:options) {
		 System.out.println("ѡ�е�Ԫ�أ�"+option.getText()); 
	  }
		  
	  //ȡ������ѡ�е�Ԫ��
	  Thread.sleep(3000);
	  sel.deselectAll();
	  System.out.println("-----ȡ������ѡ�е�Ԫ��");
	  List<WebElement> options1 = sel.getOptions();
	  for(WebElement option:options1) {
		  if(option.isSelected()) {
			 System.out.println("----ȡ������ѡ��Ԫ�صĲ���ʧ��----"); 
		  }else {
			 System.out.println("----ȡ������ѡ��Ԫ�صĲ����ɹ�----");
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