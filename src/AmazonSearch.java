import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class AmazonSearch {

	public static void main (String[] args)
	{
		System.setProperty("webdriver.chrome.driver", "/home/amruta/Desktop/automation_simplie_learn/chromedriver_linux64_new/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in/");
		WebElement search = driver.findElement(By.id("twotabsearchtextbox"));
		search.sendKeys("iphone 12");
		WebElement enterSearch = driver.findElement(By.id("nav-search-submit-button"));
		enterSearch.click();
	    List <WebElement> phnName = new ArrayList();
	    phnName=driver.findElements(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']//span"));
		List <WebElement> price = new ArrayList();
		price=driver.findElements(By.xpath("//span[@class='a-price-whole']"));
		
		HashMap<String,String> map= new HashMap<String,String>();
		for(int i=0;i<phnName.size();i++)
		{
			map.put(phnName.get(i).getText(),price.get(i).getText());
		}
		
		for (Map.Entry<String, String> e : map.entrySet())
		{
			System.out.println(""+e.getKey()+"  "+e.getValue());
		}
		driver.close();
	}
}

