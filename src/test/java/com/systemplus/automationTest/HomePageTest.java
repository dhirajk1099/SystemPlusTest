package com.systemplus.automationTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.BaseTest.BaseTest;
import com.pageObject.HomePage;

public class HomePageTest {

	private WebDriver driver;

	 @BeforeMethod
	    public void setUp() {
	        // Setup WebDriver (assuming ChromeDriver in this example)
	    	String projectPath = System.getProperty("user.dir");
	        System.setProperty("webdriver.chrome.driver", projectPath+"/Driver/chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();  // Optional: Maximize the browser window
	    }
	@Test(priority=0)
	public void navigateToLearnMoreAndVerifyUrlContent() {
			SoftAssert softassert = new SoftAssert();
	        BaseTest basetest = new BaseTest(driver);
	        basetest.navigateTo("https://www.brighthorizons.com/");
	        HomePage homepage = new HomePage(driver);
	        boolean bool =homepage.navigateAndClickEmployerLearnMoreLink();
	        softassert.assertTrue(bool,"Learn More Link is not clickable");
	        softassert.assertAll();

	}
	
	@Test(priority=1)
	public void verifyNoOfCOmmentsAndDots() {
			SoftAssert softassert = new SoftAssert();
	        BaseTest basetest = new BaseTest(driver);
	        basetest.navigateTo("https://www.brighthorizons.com/");
	        HomePage homepage = new HomePage(driver);
	        homepage.navigateAndClickEmployerLearnMoreLink();
	        boolean bool =homepage.verifyUrlContent();
	        softassert.assertTrue(bool,"Comments and dots count didn't matched");
	        softassert.assertAll();

	        
	}
	
	@Test(priority=2)
	public void verifySearchTextandIcon() {
		SoftAssert softassert = new SoftAssert();
        BaseTest basetest = new BaseTest(driver);
        basetest.navigateTo("https://www.brighthorizons.com/");
        HomePage homepage = new HomePage(driver);
        homepage.navigateAndClickEmployerLearnMoreLink();
        boolean bool =homepage.validateSearchField();
        softassert.assertTrue(bool,"Search Text Field is displayed");
        String data =homepage.validateFirstSearchedData();
        Assert.assertEquals(data, "Employee Education in 2018: Strategies to Watch");
	}
	
	@AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
