package com.ToolsQA.Utils;

public class XpathGeneration {
	
	public static String createXpath(String xpath,Object ...arg){
		
		for(int i=0;i<arg.length;i++){
			xpath=xpath.replace("{"+i+"}", (CharSequence)arg[i]);
		}
		
		return xpath;
		
	}
	
	public static void main(String args[]){
		XpathGeneration xgen=new XpathGeneration();
		String x1=createXpath("//input[@id='{0}']", "test");
		System.out.println(x1);
		String x2=createXpath("//input[@id='{0}']//div[@name='{1}']", "test","button");
		System.out.println(x2);
	}

}
