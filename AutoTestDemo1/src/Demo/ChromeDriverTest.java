package Demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ChromeDriverTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//download driver address
		//http://chromedriver.storage.googleapis.com/index.html?path=2.9/
		String url = "http://www.baidu.com";
		WebDriver driver;
		//System.setProperty("webdriver.chrome.driver","E:\\workspace\\AutoTestDemo1\\tools\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		//https://github.com/mozilla/geckodriver/releases
		//System.setProperty("webdriver.gecko.driver", "E:\\workspace\\AutoTestDemo1\\tools\\geckodriver.exe");
		//driver = new FirefoxDriver();
		System.setProperty("webdriver.ie.driver", "E:\\workspace\\AutoTestDemo1\\tools\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();
		driver.get(url);
		int [] a = new int[10];
		a[1]=0;
		a[2]=1;
		int arrayLen = a.length;
		
		String b ="13ofmamfdf";
		int stringLen = b.length();
		
		
		//如果不设置系统属性，去设置环境变量，高级系统设置-》系统变量-》 path  E:\workspace\AutoTestDemo1\tools

	}

}
