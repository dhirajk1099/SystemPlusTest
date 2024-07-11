package com.BaseTest;

import org.openqa.selenium.WebDriver;



public class BaseTest {

    public WebDriver driver;

    public BaseTest(WebDriver driver) {
        this.driver = driver;
    }
    
   

    
    public void navigateTo(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    
    
//    public WebDriver initializeDriver() throws IOException {
//        FileInputStream fil = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/data.properties");
//        Properties prop = new Properties();
//        prop.load(fil);
//        System.out.println(prop.getProperty("browser"));
//        String browserName = System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
//        WebDriverManager.chromedriver().setup();
//        if (browserName.contains("chrome")) {
//            ChromeOptions options = new ChromeOptions();
//            if (browserName.contains("headless")) {
//                options.addArguments("headless");
//                driver.manage().window().setSize(new Dimension(1440, 900));
//            }
//            driver = new ChromeDriver(options);
//        } else if (browserName.equalsIgnoreCase("firefox")) {
//            WebDriverManager.firefoxdriver().setup();
//            driver = new FirefoxDriver();
//        }
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().window().maximize();
//        driver.get(prop.getProperty("url"));
//        return driver;
//    }
//
//    @BeforeClass(alwaysRun = true)
//    public void launchApplication() throws IOException {
//        driver = initializeDriver();
//      
//    }
//
//    @AfterClass(alwaysRun = true)
//    public void tearDown() {
//        driver.close();
//
//    }

}
