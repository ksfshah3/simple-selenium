package com.qa.base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

import com.qa.pages.SamplePage;
import com.qa.util.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass extends Utility {

    public SamplePage sample;

    public BaseClass() {
        propertyInit();
    }

    public static void intialization() {
    	setWebDriverExe();
        String browserName = prop.getProperty("Browser");
        if (browserName.equals("chrome")) {           
            driver = new ChromeDriver();
        } else if (browserName.equals("firefox")) {
            driver = new FirefoxDriver();
        } else {
        	
            //WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            options.addArguments("addArguments");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--headless");
            //options.addArguments("start-maximized");
            options.addArguments("disable-infobars");
            //options.addArguments("--disable-extensions");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-browser-side-navigation");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-gpu");
            driver = new ChromeDriver(options);
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(prop.getProperty("url"));
    }

    @AfterTest
    public void tearDown() {
        // closes all the browser windows opened by web driver
        driver.quit();
    }
    
    public static void setWebDriverExe() {
    	String osName = System.getProperty("os.name").toLowerCase();
    	String Path =  System.getProperty("user.dir");
    	if (osName.contains("mac")) {
    		
    	}else if(osName.contains("win")){
    		System.setProperty("webdriver.chrome.driver", Path+ "\\src\\main\\resources\\webdriver\\chromedriver.exe");
    	}else {
    		System.setProperty("webdriver.chrome.driver", Path+ "\\src\\main\\resources\\webdriver\\chromedriver");
    	}
    }
}
