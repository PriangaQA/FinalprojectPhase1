import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class AmazonTest {

	private static Object File;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		WebElement search=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
		search.sendKeys("samsung mobile");
		WebElement clicksearch=driver.findElement(By.xpath("//input[@id='nav-search-submit-button']"));
		clicksearch.click();
		List <WebElement> name=driver.findElements(By.xpath("//div[@class='a-section']//h2//span"));
        List<WebElement> product_price = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-whole']"));
		
		List<WebElement> symbol = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']//div[contains(@class,'price')]//span[@class='a-price-symbol']"));
		for(int i=0;i<name.size();i++)
		{
				System.out.println("Product : " + name.get(i).getText());
				System.out.println("Price : "+symbol.get(i).getText() + " " +product_price.get(i).getText());
		}
		
		TakesScreenshot tobj = (TakesScreenshot) driver;
		File fileobj =tobj.getScreenshotAs(OutputType.FILE);
	
		File screenshot = new File ("myss.PNG");
		FileUtils.copyFile(fileobj,screenshot);
		driver.close();
			
	}

}
