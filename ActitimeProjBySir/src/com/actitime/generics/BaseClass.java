package com.actitime.generics;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.actitime.repository.HomePage;
import com.actitime.repository.LoginPage;

public class BaseClass {
	static {
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	}
	public WebDriver driver;
	public FileLib f=new FileLib();
	@BeforeClass
	public void openBrowser() {
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void loginApp() throws IOException {
		String url = f.getPropertyValue("url");
		String un = f.getPropertyValue("username");
		String pw = f.getPropertyValue("password");
		driver.get(url);
		LoginPage l=new LoginPage(driver);
		l.setLogin(un, pw);
	}

	@AfterMethod
	public void logoutApp() throws InterruptedException {
		HomePage h=new HomePage(driver);
		Thread.sleep(3000);
		h.getLOGOUTLINK().click();

	}
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}
}
 
