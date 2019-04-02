package com.ToolsQA.Utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

public class ImageDisableOptions {
	
	public static void disableImageChrome(ChromeOptions options){
		Map<String,Object> images=new HashMap<String,Object>();
		images.put("images", 2);
		Map<String,Object> prefer=new HashMap<String,Object>();
        prefer.put("profile.default_content_setting_values",images);
        options.setExperimentalOption("prefer", prefer);
	}
	
	
	public static void disableImageFirfox(FirefoxOptions options){
		
		FirefoxProfile prof=new FirefoxProfile();
	    prof.setPreference("permissions.default.image", 2);
	    options.setProfile(prof);
	    options.setCapability(FirefoxDriver.PROFILE, prof);
		  
	}

}
