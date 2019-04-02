package StepDefinitionWindow;

import java.awt.Window;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.rmi.CORBA.Util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.os.WindowsUtils;
import org.testng.Assert;

import com.ToolsQA.BaseClass.BaseClass;
import com.ToolsQA.Pages.DemoSites;
import com.ToolsQA.Pages.HomePage;
import com.ToolsQA.Utils.Utils;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class TestWindowHandling extends BaseClass {
	
	HomePage homepage;
	DemoSites demo_sites;
	String parent;
	
	@Given("^Launch browser$")
	public void Launch_browser()  {
		initialisation();
		homepage=new HomePage();
		demo_sites=new DemoSites();
	    parent=driver.getWindowHandle();
	}

	@When("^Goto DemoSites$")
	public void Goto_DemoSites()  {
		
		homepage.demosite();
    
	}
	   
	@Then("^Select practice swich windows$")
	public void Select_practice_swich_windows() {
	String actualText=	driver.findElement(By.xpath("//*[@id='page']/div[4]/div/div[1]/h1")).getText();
		try {
			Assert.assertEquals(actualText, "Automation Practice Switch Windows");
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

	@Then("^Click on New Browser Window (\\d+) times$")
	public void Click_on_New_Browser_Window_times(int nTimes)  {
        demo_sites.clickWindow(nTimes);
		String parent=driver.getWindowHandle();
		Set<String> windows=driver.getWindowHandles();
		 System.out.println("No Of Windows are "+windows.size());
		int i=0;
		
		for(String child:windows){
			if(!parent.equalsIgnoreCase(child)){
			if(i==4){
		   driver.switchTo().window(child);
		   driver.manage().window().maximize();
			System.out.println("child no "+i+"->"+child);
			}
			driver.switchTo().window(child);
			driver.close();
			i++;
		}
			
		}
		driver.switchTo().window(parent); 
	}
	
	@Then("^Click on New Message Window$")
	public void Click_on_New_Message_Window()  {
	     
		demo_sites.clickMessWindow();
		Utils.switchWindows();
	}

	@Then("^Validate message$")
	public void Validate_message(DataTable data) throws InterruptedException {
	    // Express the Regexp above with the code you wish you had
	    // For automatic conversion, change DataTable to List<YourType>
		
		String text=demo_sites.getMessWindowText();
		System.out.println(text);
		for(Map<String,String> map: data.asMaps()){
			
			Assert.assertEquals(text, map.get("message"));
			
		}
		driver.close();
		driver.switchTo().window(parent);
		
		String str1=demo_sites.randomId();
		
		String d=driver.findElement(By.xpath("//div[@id='content']//p[@id='"+str1+"']")).getText();
		System.out.println("Before refresh :"+d);
		driver.navigate().refresh();
		String str=demo_sites.randomId();
		String rData=driver.findElement(By.xpath("//div[@id='content']//p[@id='"+str+"']")).getText();
		System.out.println("After refress :"+rData);
		
		for(int i=0;i<10;i++){
			Utils.changeElemntColor(driver, demo_sites.button1(), "rgb(0,200,0)");
			
			Thread.sleep(1000);
			Utils.changeElemntColor(driver, demo_sites.button1(), "rgb(0,0,500)");
			
		}
		
		
	    
	}



}
