package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Comm.LaunchBrowser;

public class GetElementObjectClass {
	public WebDriver driver;
  @Test
  public void f() {
	  ElementObect eleObj = new ElementObect(driver);
	  WebElement inputbox = eleObj.getElement("name", "id");
	  inputbox.sendKeys("mingming test");
  }
  @BeforeClass
  public void beforeClass() {
	  String url = "file:\\E:\\workspace\\AutoTestDemo1\\htmldoc\\PracticePage.html";
	  driver = LaunchBrowser.browserConfigure("Chrome");
	  LaunchBrowser.openBrowser(url, driver);
	  LaunchBrowser.maxizeBrowser(driver);
	  
  }

  @AfterClass
  public void afterClass() throws InterruptedException {
	  Thread.sleep(3000);
	  driver.quit();
  }

}
