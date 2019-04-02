package com.ToolsQA.Pages;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ToolsQA.BaseClass.BaseClass;

public class DemoSites extends BaseClass {
	public static Actions ac=new Actions(driver);
	
	@FindBy(xpath="//div[@id='content']//p//button[@id='button1']")
	WebElement newWindow;
	
	@FindBy(xpath="//div[@id='content']/p[3]/button")
    WebElement newMessWindow;
	
	@FindBy(tagName="body")
	WebElement message;
	
	@FindBy(xpath="//div[@id='content']/p[5]")
	WebElement randomID;
	
	@FindBy(xpath="//*[@id='colorVar']")
	WebElement button1;
	
	
	
	public DemoSites(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickWindow(int ntimes){
		
		int i=0;
		while(i<ntimes){
			ac.click(newWindow).build().perform();
			i++;
		}
	}
	
	public void clickMessWindow(){
		ac.click(newMessWindow).build().perform();	
	}
	
	public String getMessWindowText(){
		
		String str=message.getText();
		return str;
	}
	
	public String randomId(){
		String str=randomID.getAttribute("id");
		return str;
	}
	
	public WebElement button1(){
		return button1;
	}

}
