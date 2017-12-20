package RFProjectAuto;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ApplyFunding {
	WebDriver driver;
	String clubUrl = "http://test.idrottonline.se/Bjorkenas-PukaviksIF-Fotboll/";

	@Test
	  public void applyFunding() throws InterruptedException {
		driver.get(clubUrl);
		//driver.manage().window().maximize();
		WebElement loginEle = driver.findElement(By.id("IdrottOnline-LoginBoxTarget"));
		loginEle.click();
		//等待用户名输入框出现
		WebDriverWait wait = new WebDriverWait(driver,200);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("userName")));
		//输入用户名，密码
		WebElement userBox = driver.findElement(By.name("userName"));
		userBox.clear();
		userBox.sendKeys("IID01419592");
		WebElement passwordBox = driver.findElement(By.name("password"));
		passwordBox.clear();
		passwordBox.sendKeys("36BQsH");
		//查找登录按钮
		WebElement loginbtn = driver.findElement(By.cssSelector(".btn.btn-primary.span12.btn-large"));
		loginbtn.click();
		//等待funding按钮出现 .btn>a[title='.btn>a[title='Idrottsmedel']']
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".btn>a[title='Idrottsmedel']")));
		WebElement idrottsmedelEle = driver.findElement(By.cssSelector(".btn>a[title='Idrottsmedel']"));
		//d点击funding btton
		idrottsmedelEle.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='ioui-sidebar']//a[@title='Idrottsmedel']")));
		WebElement leftMenuFund = driver.findElement(By.xpath("//div[@class='ioui-sidebar']//a[@title='Idrottsmedel']"));
		leftMenuFund.click();
		Thread.sleep(10000);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.cssSelector("#iFrameSizer0.content-frame.ioui-responsive-iframe")));
		WebDriverWait wait2 = new WebDriverWait(driver,200);
		wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[class='input-block-level'][data-component='fundingName']")));
		System.out.println("-------Sök idrottsmedel-------");
		//找到funding name 输入框
		WebElement fundNameEle = driver.findElement(By.cssSelector("input[class='input-block-level'][data-component='fundingName']"));
		//输入funding的name
		fundNameEle.sendKeys("mm");
		System.out.println("fundingStartTime");
		//找到funding start time box
		WebElement fundStartTime = driver.findElement(By.id("fundingStartTime"));
		fundStartTime.click();	
		By calendarBox = By.cssSelector(".datepicker.datepicker-dropdown.dropdown-menu.datepicker-orient-left.datepicker-orient-top");
		WebDriverWait wait1 = new WebDriverWait(driver,10);
		wait1.until(ExpectedConditions.presenceOfElementLocated(calendarBox));
		WebElement currentMonth = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='datepicker-switch']"));
		System.out.println("------当前月份是-----："+currentMonth.getText());
		WebElement prevBtn = driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='prev']"));
		prevBtn.click();
		Thread.sleep(3000);
		List<WebElement> days = driver.findElements(By.xpath("//div[@class='datepicker-days']//td[@class='day']"));
		int numberOfDays = days.size();
		System.out.println("-----选择的日期-----："+numberOfDays);
		WebElement specifDay = days.get(20);
		//鼠标移到指定日期，并点击
		Actions builder = new Actions(driver);
		System.out.println("-----选择的日期-----："+specifDay.getText());
		Action moveToEle = builder.moveToElement(specifDay).build();
		moveToEle.perform();
		Thread.sleep(3000);
		specifDay.click();
		Thread.sleep(3000);
		//点击搜索按钮
		WebElement searchBtn = driver.findElement(By.cssSelector(".btn.btn-primary.ladda-button"));		
		//创建一个javascript 执行实例
		JavascriptExecutor js = (JavascriptExecutor)driver;
		//执行js语句，拖拽浏览器滚动条，直到该元素的底部
		js.executeScript("arguments[0].scrollIntoView(true);", fundStartTime);
		Thread.sleep(7000);
		searchBtn.click();
		Thread.sleep(7000);
		//定位搜索结果Grid的底部元素 poster per sida 
		//WebElement gridBottom = driver.findElement(By.cssSelector(".k-pager-sizes.k-label"));
		List<WebElement> fundList = driver.findElements(By.xpath("//tbody[@role='rowgroup']/tr"));
		int numberOfFunds= fundList.size();
		WebElement fundRow = fundList.get(2);
		WebElement fundName = fundRow.findElement(By.xpath("//td[@data-title='Idrottsmedel']/a"));
		fundName.click();
		Thread.sleep(10000);
  }

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "E:\\workspace\\AutoTestDemo1\\tools\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}
