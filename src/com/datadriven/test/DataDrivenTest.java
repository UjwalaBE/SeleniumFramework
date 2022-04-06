package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.utility.Xls_Reader;


public class DataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
		
		
		System.setProperty("webdriver.chrome.driver","C:\\C\\admin\\eclipse\\eclipse-java-2021-06-R-win32-x86_64\\chromedriver(2).exe");
			
		
		WebDriver driver= new ChromeDriver();
		
			driver.manage().window().maximize();
		   
			driver.manage().deleteAllCookies();
			
			driver.get("https://nxtgenaiacademy.com/demo-site/");
			
			
			
			//reading data from EXcel called data driven pattern 
			
			Xls_Reader reader=new Xls_Reader("C:\\Users\\DELL\\eclipse-workspace\\java-Selenium\\SeleniumFramework\\src\\com\\testdata\\Test_Data.xlsx");
			
	       int rowCount=reader.getRowCount("TestData");
	       
	       reader.addColumn("Testdata", "remark");
	       
	       
	       //Parameterizaton 
		
		for(int rowNum=2;rowNum<=rowCount;rowNum++ ) {
			
			 String firstname=reader.getCellData("TestData", "firstname", rowNum);
				
			    System.out.println(firstname);
			    
			    
			    String lastname=reader.getCellData("TestData", "lastname", rowNum);
				
			    System.out.println(lastname);
			    
			    
			    String address1=reader.getCellData("TestData", "address1", rowNum);
				
			    System.out.println(address1);
			    
			    
			    String address2=reader.getCellData("TestData", "address2", rowNum);
				
			    System.out.println(address2);
			    
			    
			    String city=reader.getCellData("TestData", "city", rowNum);
				
			    System.out.println(city);
			    
			   
			    String state=reader.getCellData("TestData", "state", rowNum);
				
			    System.out.println(state);
			    
			    
			    String emailaddress=reader.getCellData("TestData", "emailaddress", rowNum);
				
			    System.out.println(emailaddress);
			    
			    System.out.println("--------------------------------");
			    
			    
			    
			    
		//webdriver code	
		
        driver.findElement(By.xpath("//input[@type='text']")).clear();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(firstname);
		
		
		driver.findElement(By.xpath("//input[@id='vfb-7']")).clear();
	    driver.findElement(By.xpath("//input[@id='vfb-7']")).sendKeys(lastname);
		
		driver.findElement(By.xpath("//input[@id='vfb-13-address']")).clear();
		driver.findElement(By.xpath("//input[@id='vfb-13-address']")).sendKeys(address1);
		
		driver.findElement(By.xpath("//input[@id='vfb-13-address-2']")).clear();
		driver.findElement(By.xpath("//input[@id='vfb-13-address-2']")).sendKeys(address2);
		
		driver.findElement(By.xpath("//input[@id='vfb-13-zip']")).clear();
		driver.findElement(By.xpath("//input[@id='vfb-13-zip']")).sendKeys(city);
		
		Thread.sleep(2000);
		
		Select sel=new Select(driver.findElement(By.xpath("//select[@id='vfb-13-country']")));
		sel.selectByVisibleText(state);
		
		
		
		
		
		driver.findElement(By.xpath("//input[@type='email']")).clear();
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys(emailaddress);
		
		
			reader.setCellData("TestData", "remark", rowNum, "Done");		
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		}	
					
					
					
					
	}

}
