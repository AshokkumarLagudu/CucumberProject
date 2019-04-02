package com.ToolsQA.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	
	public static WebDriver driver;
	public static Properties properties;
	
	public BaseClass(){
		properties=new Properties();
		try {
			FileInputStream fis=new FileInputStream("C:\\Users\\ASHOK\\workspace\\CucumberPractice\\src\\main\\java\\com\\ToolQA\\config\\config.properties");
		
		     properties.load(fis);
		     
		     
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	    
	}
	
	public void initialisation() {
        
		String browsername=properties.getProperty("browser");
		if(browsername.equals("chrome")){
			
			System.setProperty("webdriver.chrome.driver", "E:\\SeleniumPract\\Chromedriver\\chromedriver.exe");
            driver=new ChromeDriver();           			
		}
		else if(browsername.equals("firefox")){
			
			System.setProperty("webdriver.gecko.driver","E:\\SeleniumPract\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver=new FirefoxDriver();
			
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		driver.get(properties.getProperty("url"));
		
		
		
	}

}
