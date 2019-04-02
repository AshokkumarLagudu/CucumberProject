package com.ToolsQA.Utils;

import java.util.Properties;

public class ConfigFileReader {
	static Properties prop =new Properties();
	public static String getConfigReportPath(){
		
		String path=prop.getProperty("extentConfigPath");
		if(path!=null){
			return path;
		}else throw new RuntimeException("Path not found at given location :"+path);
		 
		
	}

}
