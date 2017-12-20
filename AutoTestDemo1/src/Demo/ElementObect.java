package Demo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ElementObect {
	WebDriver driver;
	public ElementObect(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getElement(String locator, String type) {
		String findType = type.toLowerCase();
		if (findType.equals("id")) {
			return driver.findElement(By.id(locator));
		}else if (findType.equals("xpath")) {
			return driver.findElement(By.xpath(locator));
		}else if (findType.equals("cssSelector")) {
			return driver.findElement(By.cssSelector(locator));
		}else if (findType.equals("name")) {
			return driver.findElement(By.name(locator));
		}else if (findType.equals("linkText")) {
			return driver.findElement(By.linkText(locator));	
		}else if (findType.equals("className")) {
			return driver.findElement(By.className(locator));
		}else if (findType.equals("partialLinkText")) {
			return driver.findElement(By.partialLinkText(locator));
		}else if (findType.equals("tagName")) {
			return driver.findElement(By.tagName(locator));
		}else {
			System.out.println("不存在该查找方式！");
			return null;
		}
		
	}
	
	public List<WebElement> getElements(String locator, String type){
		String findType = type.toLowerCase();
		if (findType.equals("id")) {
			return driver.findElements(By.id(locator));
		}else if (findType.equals("xpath")) {
			return driver.findElements(By.xpath(locator));
		}else if (findType.equals("cssSelector")) {
			return driver.findElements(By.cssSelector(locator));
		}else if (findType.equals("name")) {
			return driver.findElements(By.name(locator));
		}else if (findType.equals("linkText")) {
			return driver.findElements(By.linkText(locator));	
		}else if (findType.equals("className")) {
			return driver.findElements(By.className(locator));
		}else if (findType.equals("partialLinkText")) {
			return driver.findElements(By.partialLinkText(locator));
		}else if (findType.equals("tagName")) {
			return driver.findElements(By.tagName(locator));
		}else {
			System.out.println("不存在该查找方式！");
			return null;
		}
	}
	//判断元素是否存在
	public boolean isElementPresent(String locator, String type) {
		List<WebElement> elements = getElements(locator,type);
		int size = elements.size();
		if (size>0) {
			return true;
		}else {
			return false;
		}
		
	}
	
	

}
