package com.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {

	private WebDriver driver = null;
	private By employersLink = By.xpath("//a[normalize-space()='EdAssist Solutions for Employers']");
	private By learnMoreLink = By.xpath("//a[@class='button home_lazy_edassist'][normalize-space()='Learn More']");
	private By popUpWindow = By.xpath("//div[@class='ot-sdk-row']");
	private By acceptBtn = By.xpath("//button[@id='onetrust-accept-btn-handler']");
	private By numberOfcomments = By.xpath("//div[@class='slick-slide']");
	private By numberOfDots = By.xpath("//li[@role='presentation']/button");
	private By searchIcon = By.xpath("//a[@href='#subnav-search-desktop-top']//span[@class='icon-search bhc-icon-search-rounded']");
	private By seachTextField = By.xpath("//nav[@id='subnav-search-desktop-top']//input[@id='search-field']");
	private By firstTitle = By.xpath("(//h3[@class='title'])[1]");
	String data = "Employee Education in 2018: Strategies to Watch";
	private By searchButton = By.xpath("//nav[@id='subnav-search-desktop-top']//button[@type='submit'][normalize-space()='Search']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	
	public boolean navigateAndClickEmployerLearnMoreLink() {
		boolean bool =false;
		String UrlData=null;
	if(driver.findElement(popUpWindow).isDisplayed()) {
		driver.findElement(acceptBtn).click();
	}
		driver.findElement(employersLink).click();
		System.out.println("clicked employers link");
		if(driver.findElement(employersLink).isDisplayed()) {
			driver.findElement(learnMoreLink).click();
			 UrlData =driver.getCurrentUrl();
			 System.out.println(UrlData);
		}
			 if(UrlData.contains("edassist-solutions")){
				 bool = true;
			 }
		return bool;
	}
		
	
	
	public boolean verifyUrlContent() {
		boolean bool = false;
		List<WebElement> noOfCommentsData =driver.findElements(numberOfcomments);
		System.out.println("This is size of Comments:"+noOfCommentsData.size());
		List<WebElement> noOfDotsCount = driver.findElements(numberOfDots);
		System.out.println("This is size of Dots:"+noOfDotsCount.size());
		if(noOfCommentsData.size()==noOfDotsCount.size()) {
			bool= true;
		}
		return bool;

	}
	
	public boolean validateSearchField() {
		boolean bool= false;
		driver.findElement(searchIcon).click();
		if(driver.findElement(seachTextField).isDisplayed()) {
			bool = true;
		}
		return bool;
	}
	
	public String validateFirstSearchedData() {
		driver.findElement(seachTextField).sendKeys(data);
		driver.findElement(searchButton).click();
		
		try {
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String expectedTextTitle =driver.findElement(firstTitle).getText();
		return expectedTextTitle;
		
	}
	
	

}
