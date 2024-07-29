package org.loc;


import org.baseclass.Baseclass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class POJO extends Baseclass
{
	public POJO ()
	{
	PageFactory.initElements(driver,this);
}
@FindBy(xpath="//input[@id='username']")
private WebElement uname;

@FindBy(xpath="//input[@id='password']")
private WebElement pw;

@FindBy(xpath="//button[@type='submit']")
private WebElement login;

public WebElement getUname() 
{
	return uname;
	
}
public WebElement getPW() 
{
	return pw;
	
}
public WebElement getLogin() 
{
	return login;
	
}

}