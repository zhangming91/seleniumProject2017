package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelectorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		String baseUrl = "file:\\E:\\workspace\\AutoTestDemo1\\htmldoc\\PracticePage.html";
		file:///E:/workspace/AutoTestDemo1/htmldoc/PracticePage.html
		System.setProperty("webdriver.gecko.driver", "E:\\workspace\\AutoTestDemo1\\tools\\geckodriver.exe");
		driver = new FirefoxDriver();
		
//		System.setProperty("webdriver.chrome.driver","E:\\workspace\\AutoTestDemo1\\tools\\chromedriver.exe");
//		driver = new ChromeDriver();
		driver.get(baseUrl);
		

	}

}
