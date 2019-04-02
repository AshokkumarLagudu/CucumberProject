package com.ToolsQA.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ToolsQA.BaseClass.BaseClass;

public class HomePage extends BaseClass {
	DemoSites demo_sites;
	@FindBy(xpath="//nav[@class='navigation']//ul[@id='primary-menu']/li[7]/ul/li[4]/a/span/span")
	WebElement windows;
	
	@FindBy(xpath="//nav[@class='navigation']//ul[@id='primary-menu']/li[7]/a/span/span")
	WebElement demo_site;
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public void demosite(){
		 //=driver.findElement(By.xpath("//nav[@class='navigation']//ul[@id='primary-menu']/li[7]/a/span/span"));
		
		Actions ac=new Actions(driver);
		ac.moveToElement(demo_site).build().perform();
	    ac.click(windows).build().perform();
	    
	    
	   
        
	}
	
	

}
