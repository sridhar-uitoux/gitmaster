package org.stepdefinition;
import java.io.IOException;
import java.time.Duration;

import org.baseclass.Baseclass;
import org.loc.POJO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends Baseclass{
	POJO P;

     @Given("Open a chrome browser")
     public void open_a_chrome_browser() {
    	 launchbrowser();
    	         
     }

     @Given("Launch the DEMS website")
     public void launch_the_DEMS_website() {
    	 url("https://uat-dems.uitoux.in/login");
    	 maximize();
    	 String titleOfUrl = driver.getTitle();
 		 System.out.println(titleOfUrl);
 		implicitwait();
     }

     @When("I entered the valid username {string} and password {string}")
     public void i_entered_the_valid_username_and_password(String Uname, String PW) {
    	P=new POJO(); 
        txtfill(P.getUname(),Uname);
        txtfill(P.getPW(),PW);
       
     }

     @Then("Click on login button")
     public void click_on_login_button() {
    	 P=new POJO();
    	 click(P.getLogin());
     }
     @Given("Click on Add new button")
     public void click_on_Add_new_button() {
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[@class='anticon'])[2]")));
    	 driver.findElement(By.xpath("(//span[@class='anticon'])[2]")).click();
    	 w.until(ExpectedConditions
 				.visibilityOfElementLocated(By.cssSelector(".ant-btn.css-26rdvq.ant-btn-primary.btn.btn-with-icon")));
 		driver.findElement(By.cssSelector(".ant-btn.css-26rdvq.ant-btn-primary.btn.btn-with-icon")).click();
     }

     @Given("Enter the Purpose {string} of trip")
     public void enter_the_Purpose_of_trip(String Purpose) {
    		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(30));
    	 w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='purpose_id']")));

 		driver.findElement(By.xpath("//input[@id='purpose_id']")).click();

 		driver.findElement(By.xpath("//input[@id='purpose_id']")).sendKeys(Purpose);

 		w.until(ExpectedConditions.textToBe(By.xpath("//div[@class='ant-select-item-option-content']"), Purpose));

 		driver.findElement(By.xpath("//div[@class='ant-select-item-option-content']")).click();
     }

     @Given("Select the Start date and End Date")
     public void select_the_Start_date_and_End_Date() {
    	 driver.findElement(By.xpath("//div[@class='ant-col ant-col-12 css-26rdvq']")).click();

 		driver.findElement(By.xpath("//input[@id='start_date']")).click();

 		driver.findElement(By.xpath("//td[@title='2023-07-27']")).click();

 		driver.findElement(By.xpath("//input[@id='end_date']")).click();
 		driver.findElement(By.xpath("(//td[@title='2023-07-27'])[2]")).click();
     }

     @Given("Enter the Description {string}")
     public void enter_the_Description(String Description) {
    	WebElement des= driver.findElement(By.xpath("//textarea[@id='description']"));
        txtfill(des,Description);
        driver.findElement(By.xpath("(//button[@class='ant-btn css-26rdvq ant-btn-primary'])[1]")).click();

     }

     @When("Select the trip type")
     public void select_the_trip_type() {
    	 driver.findElement(By.xpath("//span[normalize-space()='Single']")).click();
 		driver.findElement(By.xpath("(//span[@class='ant-select-selection-search'])[2]")).click();
     }

     @Then("Select from and To city")
     public void select_from_and_To_city(){
    	 String location = "Coimbatore";
    	 driver.findElement(By.xpath("//input[@id='visits_0_to_city_id']")).click();
    	 driver.findElement(By.xpath("//input[@id='visits_0_to_city_id']")).sendKeys(location, Keys.ENTER);
     }

     @Then("Select the travel mode {string} and trip type {string}")
     public void select_the_travel_mode_and_trip_type(String Travel_mode, String Trip_type) {
    	// String travelMode = "bus";

 		driver.findElement(By.xpath("(//span[@class='ant-select-selection-search'])[3]")).click();

 		driver.findElement(By.xpath("//input[@id='visits_0_travel_mode_id']")).sendKeys(Travel_mode, Keys.ENTER);

 		//String tripType = "overnight";

 		driver.findElement(By.xpath("(//span[@class='ant-select-selection-search'])[4]")).click();
 		driver.findElement(By.xpath("//input[@id='visits_0_trip_mode_id']")).sendKeys(Trip_type, Keys.ENTER);


     }

     @Then("click on trip save button")
     public void click_on_trip_save_button() {
    	 driver.findElement(By.xpath("//button[@class='ant-btn css-26rdvq ant-btn-primary']")).click();
     }




}

