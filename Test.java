package automationTest;





import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		//
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", "F:\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver =new ChromeDriver(options);
		Random r = new Random();
		driver.get("https://www.jotform.com/");
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		//Thread.sleep(5000);
		System.out.println("before");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='google btn-google']")).click();
		System.out.println("after");
		//input[@id="identifierId"]
		Thread.sleep(3000);
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Set<String> handle= driver.getWindowHandles();
		String parentwindow=driver.getWindowHandle();
		int j=0;
		String re = null;
		for(String i:handle)
		{
			j++;
			if(j==2)
			{
				re=i;
			}
		}
		driver.switchTo().window(re);
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("sarathkumarchitti@gmail.com");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		 
		driver.findElement(By.xpath("//div[@role=\"button\"]")).click();//div[@role="button"]
		//driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("");
		
		driver.findElement(By.xpath("(//*[contains(text(),'Next')])[2]")).click();
		j=0;
		for(String i:handle)
		{
			j++;
			if(j==1)
			{
				re=i;
				break;
			}
		}
		driver.switchTo().window(parentwindow);
		driver.manage().window().maximize();
		Thread.sleep(8000);
		driver.findElement(By.xpath("(//*[@class='sprite-icon sprite-new'])")).click();
		driver.findElement(By.xpath("(//*[@class='form-type-selection-container'])")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//*[@id='standard-templates'])")).click();
		Thread.sleep(8000);

		/*WebElement element = driver.findElement(By.xpath());
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).build().perform();
 
        driver.findElement(By.linkText("iPads")).click();*/
		driver.switchTo().frame(driver.findElement(By.id("form-picker")));
		System.out.println("yes");
		Thread.sleep(2000);
		WebElement element = driver.findElement(By.xpath("//*[@id='product-order-form-3']"));
		 
        Actions action = new Actions(driver);
 
        action.moveToElement(element).click().build().perform();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("(//button[contains(text(),'Use Template')])[1]")).click();
		/*driver.switchTo().frame(driver.findElement(By.id("ssIFrame_google")));
		System.out.println("yes");
		Thread.sleep(5000);
		WebElement element1 = driver.findElement(By.xpath("//button[@id='templateSelect']"));
		 
        Actions action1 = new Actions(driver);
 
        action1.moveToElement(element1).click().build().perform();*/
		// you again Switch to DefaultContent/Frame then you have to find continue button
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[contains(text(),'Continue')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='togglePreview-label']")).click();
		Thread.sleep(5000);

		//driver.findElement(By.xpath("//button[@id='fillFormBttn']")).click();
		
		
		driver.switchTo().frame(driver.findElement(By.id("JF-PreviewFrame")));
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id='first_2']")).sendKeys(Util.randomString(7));
		driver.findElement(By.xpath("//*[@id='middle_2']")).sendKeys(Util.randomString(7));
		driver.findElement(By.xpath("//*[@id='last_2']")).sendKeys(Util.randomString(7));
		//id="last_2"id="input_3"
		driver.findElement(By.xpath("//*[@id='input_3']")).sendKeys(Util.randomString(7)+"@gmail.com");
		driver.findElement(By.xpath("//*[@id='input_5_area']")).sendKeys(Integer.toString(r.nextInt(4)));
		driver.findElement(By.xpath("//*[@id='input_5_phone']")).sendKeys(Integer.toString(r.nextInt(10)));
		driver.findElement(By.xpath("//*[@id='input_4_addr_line1']")).sendKeys(Util.randomString(15));
	    JavascriptExecutor js = (JavascriptExecutor) driver;  
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		Thread.sleep(6000);
		driver.findElement(By.xpath("//*[@id='input_4_addr_line2']")).sendKeys(Util.randomString(15));
		driver.findElement(By.xpath("//*[@id='input_4_city']")).sendKeys(Util.randomString(9));
		driver.findElement(By.xpath("//*[@id='input_4_state']")).sendKeys(Util.randomString(9));
		driver.findElement(By.xpath("//*[@id='input_4_postal']")).sendKeys(Integer.toString(r.nextInt(10)));
		Select dropdown = new Select(driver.findElement(By.id("input_4_country")));
		dropdown.selectByIndex(r.nextInt(30));
		
		
		//*[@class="form-all"]/ul[2]/li/div/div/div/span/div/input
		driver.findElement(By.xpath("//*[@class=\"form-section page-section\"]/li[6]/div/div[2]/button")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@class='form-all']/ul[2]/li/div/div/div/span/div/input")).click();
		
		//"JF-PreviewFrame"
		Select dropdown1 = new Select(driver.findElement(By.id("input_7_quantity_1001_0")));
		dropdown1.selectByIndex(r.nextInt(7));
		List<WebElement> options1 = driver.findElements(By.id("input_7_custom_1001_1"));

		for (WebElement option : options1) {
		    if (option.getText().contains("lu")) {
		        option.click();
		        break;
		    }
		}
		
		//driver.findElement(By.id("input_7_custom_1001_1"))
		Select dropdown3 = new Select(driver.findElement(By.id("input_7_custom_1001_2")));
		dropdown3.selectByIndex(r.nextInt(7));
		driver.findElement(By.xpath("(//*[@class='form-all']/ul[2]/li/div/div/div/span/div/input)[2]")).click();
		
		Select dropdown4 = new Select(driver.findElement(By.id("input_7_quantity_1002_0")));
		dropdown4.selectByIndex(r.nextInt(7));
		
		Select dropdown5 = new Select(driver.findElement(By.id("input_7_custom_1002_1")));
		dropdown5.selectByIndex(r.nextInt(7));
		
		Select dropdown6 = new Select(driver.findElement(By.id("input_7_custom_1002_2")));
		dropdown6.selectByIndex(r.nextInt(7));
		
		driver.findElement(By.xpath("(//*[@class='form-all']/ul[2]/li/div/div/div/span/div/input)[3]")).click();
		Select dropdown7 = new Select(driver.findElement(By.id("input_7_quantity_1003_0")));
		dropdown7.selectByIndex(r.nextInt(7));
		
		Select dropdown8 = new Select(driver.findElement(By.id("input_7_custom_1003_1")));
		dropdown8.selectByIndex(r.nextInt(7));
		driver.findElement(By.xpath("//*[@id='input_15_1']")).click();
		JavascriptExecutor js1 = (JavascriptExecutor) driver;  
		js1.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		
		driver.findElement(By.xpath("//textarea[@class='form-textarea']")).sendKeys(Util.randomString(9));
		//textarea[@class="form-textarea"]
		driver.findElement(By.xpath("//button[@id='input_13']")).click();
		//button[@id="input_13"]
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		
		
		
		
		
		
		
	}

}
