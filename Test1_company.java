package signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Test1_company {
	
WebDriver driver;
	

    @BeforeClass
	@Parameters("browser")

    public void browsers(String browserName){
		if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.firefox.driver", "/Users/sirajmohammed/eclipse-workspace/FE/geckodriver");
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
		}
		
		else if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/Users/sirajmohammed/eclipse-workspace/FE/chromedriver");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			
		}
		/*else if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver","/Users/sirajmohammed/eclipse-workspace/FE Automation");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
		}*/
    }
    
   @Test (priority = 1)
   public void titleText() {
	   
	   driver.get("https://festanging.wpengine.com/business-signup/");
	
	/*Title: Business Sign Up*/   
	WebElement Ele_1 = driver.findElement(By.xpath("//div[@class='page-signup__content-wrap__title']/h1"));
	Assert.assertEquals(true,Ele_1.isDisplayed());
	Assert.assertEquals("Business Sign Up",Ele_1.getText());
	
	/*Title: SignUp Link Status*/
	WebElement Ele_2 = driver.findElement(By.xpath("//div[@class='page-signup__content-wrap__title']/a"));
	Assert.assertEquals(true,Ele_2.isDisplayed());
	Assert.assertEquals("Are you a Freelance Engineer?",Ele_2.getText());
	System.out.println("Result for Engineer's Signup link.....");
	boolean linkStatus = Ele_2.isDisplayed();
	System.out.println("Is \"SIGN UP\" link button displayed: " + linkStatus);
	
	/*linkStatus = Ele_2.isSelected();
	System.out.println("Is SIGN UP link button selected: " + linkStatus);*/
	
	linkStatus = Ele_2.isEnabled();
	System.out.println("Is \"SIGN UP\" link button enabled: " + linkStatus);
	
   }
	
	@Test (priority = 2)
	public void info() throws Exception{
		driver.findElement(By.xpath("//input[@name='f_name'][@id='f-name']")).sendKeys("Siraj");
		driver.findElement(By.xpath("//input[@name='l_name'][@id='l-name']")).sendKeys("Mohammed");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='email'][@id='email']")).sendKeys("siraj211@gmail.com");
		driver.findElement(By.xpath("//input[@name='b_phone'][@id='b-phone']")).sendKeys("77364546354");
		driver.findElement(By.xpath("//input[@name='b_name'][@id='b-name']")).sendKeys("Externetworks.Inc");
		driver.findElement(By.xpath("//input[@name='pass'][@id='password']")).sendKeys("Flower123");
		driver.findElement(By.xpath("//input[@name='pass'][@id='r-password']")).sendKeys("Flower123");
		
	}
	
	@Test (priority = 3)
	public void showPassEle() {
		WebElement Ele_3 = driver.findElement(By.xpath("//i[@class='fas fa-eye-slash pass-ico']"));
		System.out.println("Result for show password button.....");
		boolean Status = Ele_3.isDisplayed();
		System.out.println("Is \"Show Password\" button Displayed: " + Status);
		Status = Ele_3.isEnabled();
		System.out.println("Is \"Show Password\" button Enabled: " + Status);
		/*Status = Ele_3.isSelected();
		System.out.println("Is Show Password element Selected: " + Status);*/
		
		WebElement Ele_4 = driver.findElement(By.xpath("//i[@class='fas fa-eye-slash retype']"));
		System.out.println("Result for Re-type show password button.....");
		boolean Status_2 = Ele_4.isDisplayed();
		System.out.println("Is Re-type \"Show Password\" button Displayed: " + Status_2);
		Status_2 = Ele_4.isEnabled();
		System.out.println("Is Re-type \"Show Password\" button Enabled: " + Status_2);
		/*Status = Ele_4.isSelected();
		System.out.println("Is Show Password element Selected: " + Status_2);*/
		
	}
	
	@Test (priority = 3)
	public void hyperLinks() {
		driver.findElement(By.xpath("//div[@class='agree-text form-control-wrap']"));
		Assert.assertEquals("By clicking \"Sign Up\", you agree to Field Engineer's\n" + 
				"Terms and Conditions  and  Privacy Policy",driver.findElement(By.xpath("//div[@class='agree-text form-control-wrap']")).getText());
		Assert.assertEquals(true,driver.findElement(By.xpath("//div[@class='agree-text form-control-wrap']")).isDisplayed());
		
		WebElement Ele_5 = driver.findElement(By.xpath("//div[@class='agree-text form-control-wrap']/child::a[contains(text(),'Terms and Conditions')]"));
		System.out.println("Result for Terms and Conditions Link.....");
		boolean Status_3 = Ele_5.isDisplayed();
		System.out.println("Is \"Terms and Conditions Link\" Displayed: " + Status_3);
		Status_3 = Ele_5.isEnabled();
		System.out.println("Is \"Terms and Conditions Link\" Enabled: " + Status_3);
		
		WebElement Ele_6 = driver.findElement(By.xpath("//div[@class='agree-text form-control-wrap']/child::a[contains(text(),'Privacy Policy')]"));
		System.out.println("Result for Privacy Policy Link.....");
		boolean Status_4 = Ele_6.isDisplayed();
		System.out.println("Is \"Privacy Policy Link\" Displayed: " + Status_4);
		Status_3 = Ele_6.isEnabled();
		System.out.println("Is \"Privacy Policy Link\" Enabled: " + Status_4);
	
	}
	
		
	@Test (priority = 4)
	public void signUpbutton() {
		WebElement Ele_7 = driver.findElement(By.xpath("//input[@id='signup-button'][@class='form-control']"));
		System.out.println("Result for Sign Up button.....");
		boolean Status_5 = Ele_7.isDisplayed();
		System.out.println("Is \"SignUp button\" Displayed: " + Status_5);
		Status_5 = Ele_7.isEnabled();
		System.out.println("Is \"SignUp button\" Enabled: " + Status_5);
		/*Status_5 = Ele_5.isSelected();
		System.out.println("Is SignUp button Selected: " + Status_5);*/
		Ele_7.click();
		
	}
		
		
	@AfterClass
	public void close() {
	driver.quit();
	}
	
}
	
	This I Edited   
	
   
