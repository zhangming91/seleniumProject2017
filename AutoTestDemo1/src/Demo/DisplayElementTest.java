package Demo;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class DisplayElementTest {
	WebDriver driver;
	String baseUrl;
  @Test
  public void radioButtonTest() throws InterruptedException {
	  //定位输入框
	  WebElement textBox = driver.findElement(By.cssSelector(".inputs.displayed-class"));
	  //查看输入框是否显示，显示正确
	  if(textBox.isDisplayed()) {
		  System.out.println("--------输入框默认显示了！");
	  }
	  //判断默认文本显示是否正确
	  String actualPlaceHolderText = textBox.getAttribute("placeholder");
	  String expectPlaceHolderText ="隐藏/显示 示例";
	  Assert.assertEquals(actualPlaceHolderText, expectPlaceHolderText);
	  System.out.println("-----输入框的PlaceHolderText的值显示正确！");
	  Thread.sleep(3000);
	  //如果输入框显示，点击隐藏按钮
	  WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
	  hideBtn.click();
	  //判断输入框是否隐藏
	  if (!textBox.isDisplayed()) {
		  System.out.println("------输入框隐藏了");
	  }
	  Thread.sleep(4000);
	  //点击显示按钮，判断输入框是否显示
	  WebElement showBtn = driver.findElement(By.id("show-textbox"));
	  showBtn.click();
	  if (textBox.isDisplayed()) {
		  System.out.println("--------输入框显示了");
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