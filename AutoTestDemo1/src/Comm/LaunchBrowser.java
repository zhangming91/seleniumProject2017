package Comm;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LaunchBrowser {

	public static WebDriver browserConfigure(String browser) {
		String browserType = browser.toLowerCase();
		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","E:\\workspace\\AutoTestDemo1\\tools\\chromedriver.exe");
			return new ChromeDriver();
		}else if(browserType.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "E:\\workspace\\AutoTestDemo1\\tools\\geckodriver.exe");
			return new FirefoxDriver();
		}else if(browserType.equals("internetexplorer")) {
			System.setProperty("webdriver.ie.driver", "E:\\workspace\\AutoTestDemo1\\tools\\IEDriverServer.exe");
			return new InternetExplorerDriver();
		}else {
			System.out.println("没有该浏览器的配置！");
			return null;
		}
	}
	
	//打开浏览器
	public static void openBrowser(String url, WebDriver driver) {
		driver.get(url);
	}
	//浏览器最大化
	public static void maxizeBrowser(WebDriver driver) {
		driver.manage().window().maximize();
	}

}
