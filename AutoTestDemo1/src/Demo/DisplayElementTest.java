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
	  //��λ�����
	  WebElement textBox = driver.findElement(By.cssSelector(".inputs.displayed-class"));
	  //�鿴������Ƿ���ʾ����ʾ��ȷ
	  if(textBox.isDisplayed()) {
		  System.out.println("--------�����Ĭ����ʾ�ˣ�");
	  }
	  //�ж�Ĭ���ı���ʾ�Ƿ���ȷ
	  String actualPlaceHolderText = textBox.getAttribute("placeholder");
	  String expectPlaceHolderText ="����/��ʾ ʾ��";
	  Assert.assertEquals(actualPlaceHolderText, expectPlaceHolderText);
	  System.out.println("-----������PlaceHolderText��ֵ��ʾ��ȷ��");
	  Thread.sleep(3000);
	  //����������ʾ��������ذ�ť
	  WebElement hideBtn = driver.findElement(By.id("hide-textbox"));
	  hideBtn.click();
	  //�ж�������Ƿ�����
	  if (!textBox.isDisplayed()) {
		  System.out.println("------�����������");
	  }
	  Thread.sleep(4000);
	  //�����ʾ��ť���ж�������Ƿ���ʾ
	  WebElement showBtn = driver.findElement(By.id("show-textbox"));
	  showBtn.click();
	  if (textBox.isDisplayed()) {
		  System.out.println("--------�������ʾ��");
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