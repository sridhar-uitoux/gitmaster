package org.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
//Reusable Methods
	
	public static WebDriver driver;
	
	public static Alert al;
	
	public static String st;
	
	public static JavascriptExecutor js;
	
	public static Navigation n;
	
	
	public static void launchbrowser() 
	{
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		
	}
	public static void url(String url)
	{
		driver.get(url);
		
	}
	public static void maximize()
	{
		driver.manage().window().maximize();
		
	}
	public static void txtfill(WebElement element,String value)
	{
		element.sendKeys(value);
		
	}
	public static void gettxt(WebElement element)
	{
		element.getText();
		
	}
	public static void click(WebElement element)
	{
		element.click();
	}
	public static void jclick(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", element);
	}
	public static void window()
	{
		String parid=driver.getWindowHandle();
		System.out.println(parid);
		driver.switchTo().window(parid);
	}
	public static void screenshot(String snaps) throws IOException
	{
		TakesScreenshot ts =(TakesScreenshot)driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		File destination =new File("C:\\Users\\prem\\eclipse-workspace\\ESS\\screenshots\\"+snaps+".png");
		FileUtils.copyFile(source, destination);
	}
	public static void refresh()
	{
	  driver.navigate().refresh();
	}
	
	public static void acceptalert()
	{
		al=driver.switchTo().alert();
		al.accept();
	}
	public static void dismissalert()
	{
		al.dismiss();
	}
	
	public static String excelRead(int noofRows,int noofCells) throws IOException
	{
		File f =new File("C:\\Users\\prem\\eclipse-workspace\\ESS\\excelsheets\\sample_document_group_employee.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sh =w.getSheet("Sheet2");
		Row r = sh.getRow(noofRows);
		Cell c = r.getCell(noofCells);
		int type=c.getCellType();
		String value="";
		if(type==1) {
			value=c.getStringCellValue();
		}
		else if (DateUtil.isCellInternalDateFormatted(c)) {
			Date d= c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-mm-yyyy");
			value=String.valueOf(1);
		}
		return value;
	}
	
	
	public static String excelWrite(int noofRows,int noofCells) throws IOException
	{
		File f =new File("C:\\Users\\prem\\eclipse-workspace\\ESS\\excelsheets\\sample_document_group_employee.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(fin);
		Sheet sh =w.getSheet("Sheet2");
        Row r = sh.getRow(noofRows);
		Cell c = r.createCell(noofCells);
		c.setCellValue(st);
		FileOutputStream fout = new FileOutputStream(f);
		w.write(fout);
		System.out.println("Done");
		return null;
	}
	
	public static void implicitwait()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
	}

}
