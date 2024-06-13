package com.appium.training.demo;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Demo1 {
  @Test
  public void f() throws MalformedURLException {
	  /*
	   * {
  "platformName": "Android",
  "appium:platformVersion": "14",
  "appium:deviceName": "Galaxy M14 5G",
  "appium:appPackage": "com.sec.android.app.popupcalculator",
  "appium:appActivity": "com.sec.android.app.popupcalculator.Calculator",
  "appium:UDID": "RZCW326336J",
  "appium:noReset": true,
  "appium:autoGrantPermissions": true,
  "automationName": "UIAutomator2"
}
	   */
	  
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M14 5G");
	  caps.setCapability(MobileCapabilityType.UDID, "RZCW326336J");
	  caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
	  caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	  caps.setCapability("appPackage","com.sec.android.app.popupcalculator");
	  caps.setCapability("appActivity","com.sec.android.app.popupcalculator.Calculator");
	  caps.setCapability("noReset",true);
	  caps.setCapability("autoGrantPermissions",true);
	  
	  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	  
	  AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(url,caps);
	  
	 WebElement no5 =  driver.findElementById("com.sec.android.app.popupcalculator:id/calc_keypad_btn_05");
	 
	 no5.click();
	 
	 WebElement plus = driver.findElementByAccessibilityId("Plus");
	 
	 plus.click();
	 
	 WebElement no3 =  driver.findElementByXPath("//android.widget.Button[@content-desc='3']");
	 no3.click();
	 
	 driver.findElementByAccessibilityId("Calculation").click();
	 
	 String result = driver.findElementById("com.sec.android.app.popupcalculator:id/calc_edt_formula").getText();
	 
	 System.out.println(result);
	 Assert.assertTrue(result.contains("8"));
	  
  }
}
