package com.ToolsQA.Runner;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.ToolsQA.Utils.ConfigFileReader;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features="\\Users\\ASHOK\\workspace\\CucumberPractice\\src\\test\\java\\"
		                   + "com\\ToolsQA\\Features\\windowsFeature.feature"                  
                  , glue="StepDefinitionWindow"
                  ,format = {"pretty", "com.cucumber.listener.ExtentCucumberFormatter:target//cucumber-reports//extentreport.html"}
                  
                  ,monochrome=true,
                  dryRun=false
                  
		        )
                   
public class TestRunner {
 @AfterClass
 public static void writeExtentReport(){
	Reporter.loadXMLConfig(ConfigFileReader.getConfigReportPath()); 
 }
}
//format={"pretty","html:target/Freecrm-report","junit:XmlReports/FreeCRM.xml",
//"json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},