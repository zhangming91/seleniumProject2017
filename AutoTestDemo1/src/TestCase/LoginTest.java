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
	  //访问163邮箱地址
	baseurl = "http://smart.mail.163.com/?dv=smart";
	driver.get(baseurl);
}

  @Test(dataProvider="userDataProvider")
  public void loginTest(String username, String password) throws InterruptedException {
	  Thread.sleep(4000);  
	  //跳转页，定位，点击进入网页版邮箱按钮
	  WebElement webBtnEle = driver.findElement(By.id("pop_mailEntry"));
	  webBtnEle.click();
	  //判断跳转页面是否正确
	  String expectTitle = "网易邮箱登录";
	  String actualTitle = driver.getTitle();
	  System.out.println("是否正确跳转到登录界面："+ actualTitle.equals(expectTitle));	 
	  //定位用户名，密码
	  Thread.sleep(3000);
	  WebElement usernameEle = driver.findElement(By.cssSelector(".ipt_wrap.large>input[placeholder*='用户']"));
	  WebElement passwordEle = driver.findElement(By.cssSelector(".ipt_wrap.large>input[placeholder^='密码']"));
	  //清空用户名，密码
	  usernameEle.clear();
	  passwordEle.clear();
	  Thread.sleep(3000);
	  //填写用户名，密码
	  usernameEle.sendKeys(username);
	  passwordEle.sendKeys(password);
	  //点击免登陆（默认checked），改成未选中状态
	  WebElement rememberCheckBox = driver.findElement(By.cssSelector(".i-check.i-icon.i-icon-check"));
	  if (rememberCheckBox.isSelected()) {
		  rememberCheckBox.click();
	  }
	  //定位，点击登录按钮
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
