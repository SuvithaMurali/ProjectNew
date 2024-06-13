package com.appium.training.demo;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;

public class Demo2 {
	AndroidDriver<WebElement> driver;
  @Test
  public void f() throws InterruptedException {
	  @SuppressWarnings("rawtypes")	  
	  TouchAction drag=new TouchAction(driver);

	  Thread.sleep(500);;
      drag.press(PointOption.point(540,1330)).moveTo(PointOption.point(540,200)).release().perform();
      
     // drag.press(PointOption.point(540,330)).moveTo(PointOption.point(540,1330)).release().perform();
      //To Press the home button
	 driver.pressKey(new KeyEvent(AndroidKey.HOME));
	 //To Press the Volume Control Button
	 driver.pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
	  
  }
  @BeforeMethod
  public void beforeMethod() throws MalformedURLException {
	  DesiredCapabilities caps = new DesiredCapabilities();
	  caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
	  caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14");
	  caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy M14 5G");
	  caps.setCapability(MobileCapabilityType.UDID, "RZCW326336J");
	  caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UIAutomator2");
	  caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
	  caps.setCapability("appPackage","com.android.settings");
	  caps.setCapability("appActivity","com.android.settings.Settings");
	  caps.setCapability("noReset",true);
	  caps.setCapability("autoGrantPermissions",true);
	  
	  URL url = new URL("http://127.0.0.1:4723/wd/hub");
	  
	  driver = new AndroidDriver<WebElement>(url,caps);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
