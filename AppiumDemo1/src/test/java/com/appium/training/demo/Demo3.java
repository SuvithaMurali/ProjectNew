package com.appium.training.demo;

import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Demo3 {
	AndroidDriver<WebElement> driver;
  @Test
  public void f() throws InterruptedException {
	  driver.get("https://demowebshop.tricentis.com/");
	  String titPage = driver.getTitle();
	  
	  WebElement  loginlink = driver.findElementByLinkText("Log in");
		loginlink.click();
		
		Thread.sleep(500);
		WebElement usrname = driver.findElementById("Email");
		//Type on the WebElement
		
		usrname.sendKeys("suvitha.gct@gmail.com");
		
		WebElement pass =driver.findElementByName("Password");
		pass.clear();
		pass.sendKeys("123456");
		
		driver.findElementByXPath("//input[@id='RememberMe']").click();
		
		driver.findElementByXPath("//input[@value='Log in']").click();

		/*WebElement submitBTN = driver.findElement(By.xpath("//input[@value='Log in']"));
		submitBTN.click();
		*/
		
		String result = driver.findElementByPartialLinkText("Log").getText();
		
		System.out.println(result);
		
		Assert.assertTrue(result.contains("Log out"));
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException, InterruptedException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M14 5G");
	  caps.setCapability(MobileCapabilityType.UDID, "RZCW326336J");
	  caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
	  //caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	  //caps.setCapability("appPackage","com.android.settings");
	  //caps.setCapability("appActivity","com.android.settings.Settings");
	  //caps.setCapability("noReset",true);
	  //caps.setCapability("autoGrantPermissions",true);
	  //caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
	  caps.setCapability("chromedriverExecutable","C:\\Users\\ASUS\\NewWorkspace\\AppiumDemo1\\driver\\chromedriver.exe");
	  caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
	  ChromeOptions options = new ChromeOptions();
	  options.addArguments("--user-agent=Chrome/74.0.3729.185");
	  caps.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
	  //caps.setCapability("chromeOptions", ImmutableMap.of("w3c", false));
	  //desiredCapabilities.setCapability("chromedriverExecutable","D:\\Automation_Project\\MobileAutomationBestPractices\\drivers\\chromedriver.exe");
	  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	  
	  driver = new AndroidDriver<WebElement>(url,caps);
	  Thread.sleep(500);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
