package com.ToolsQA.Utils;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.ToolsQA.BaseClass.BaseClass;

public class Utils extends BaseClass {
	
	public static String switchWindows(){
		 String str="";
		 String parent=driver.getWindowHandle();
		Set<String> child=driver.getWindowHandles();
		for(String ch:child){
			if(!parent.equalsIgnoreCase(ch)){
			     str =driver.switchTo().window(ch).getPageSource();
			    
			}
		}
		
		return str;
	}
	
	public static void changeElemntColor(WebDriver driver,WebElement element,String colour){
		
		JavascriptExecutor je=(JavascriptExecutor)driver;
		je.executeScript("arguments[0].setAttribute('style','color: "+colour+"');", element);
		
		
		
	}

}
