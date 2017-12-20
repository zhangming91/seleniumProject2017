package TestCase;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Comm.ReadUserExcel;
import Comm.Constant;

public class LoginTest {
	WebDriver driver;
	String baseurl;
	
@BeforeTest
public void beforeTest() {
  	System.setProperty("webdriver.gecko.driver", "E:\\workspace\\AutoTestDemo1\\tools\\geckodriver.exe");
	driver = new FirefoxDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  //����163�����ַ
	baseurl = "http://smart.mail.163.com/?dv=smart";
	driver.get(baseurl);
}

  @Test(dataProvider="userDataProvider")
  public void loginTest(String username, String password) throws InterruptedException {
	  Thread.sleep(4000);  
	  //��תҳ����λ�����������ҳ�����䰴ť
	  WebElement webBtnEle = driver.findElement(By.id("pop_mailEntry"));
	  webBtnEle.click();
	  //�ж���תҳ���Ƿ���ȷ
	  String expectTitle = "���������¼";
	  String actualTitle = driver.getTitle();
	  System.out.println("�Ƿ���ȷ��ת����¼���棺"+ actualTitle.equals(expectTitle));	 
	  //��λ�û���������
	  Thread.sleep(3000);
	  WebElement usernameEle = driver.findElement(By.cssSelector(".ipt_wrap.large>input[placeholder*='�û�']"));
	  WebElement passwordEle = driver.findElement(By.cssSelector(".ipt_wrap.large>input[placeholder^='����']"));
	  //����û���������
	  usernameEle.clear();
	  passwordEle.clear();
	  Thread.sleep(3000);
	  //��д�û���������
	  usernameEle.sendKeys(username);
	  passwordEle.sendKeys(password);
	  //������½��Ĭ��checked�����ĳ�δѡ��״̬
	  WebElement rememberCheckBox = driver.findElement(By.cssSelector(".i-check.i-icon.i-icon-check"));
	  if (rememberCheckBox.isSelected()) {
		  rememberCheckBox.click();
	  }
	  //��λ�������¼��ť
	  Thread.sleep(3000);
	  WebElement loginEle = driver.findElement(By.cssSelector(".u-btn.c-main"));
	  loginEle.click();
	  Thread.sleep(3000);
	  
  }
  
  @DataProvider
  public Object[][] userDataProvider(){
	  Object[][] testUserArray = ReadUserExcel.getDataToArray(Constant.Path_TestData+Constant.File_TestData,"Sheet1");
	  return testUserArray;
  }
  
  @AfterTest
  public void afterTest() {
	  driver.close();
  }
  @BeforeClass
  public void beforeClass() {
	   // System.setProperty("webdriver.chrome.driver","E:\\workspace\\AutoTestDemo1\\tools\\chromedriver.exe");
	    //driver = new ChromeDriver();
	  /*
	  	System.setProperty("webdriver.gecko.driver", "E:\\workspace\\AutoTestDemo1\\tools\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		*/
}
  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }


}
