package org.automation.core.base;


import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;



public class TestBase {



    private static Logger LOGGER = LoggerFactory.getLogger(TestBase.class);

    protected static Properties prop;
    protected static Map<String, String> testData = null;

    private static WebDriver driver = null;


    private static ThreadLocal<WebDriver> driverThreadLocal = new ThreadLocal<>();


    public TestBase() {
        try {
            prop = new Properties();
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            File file = new File(Objects.requireNonNull(classLoader.getResource("config.properties")).getFile());
            FileInputStream fin = new FileInputStream(file);
            prop.load(fin);
        } catch (Exception e) {
            LOGGER.error("Error while loading property", e);
        }
    }

    public static void initialization(String browser) {
        //String browserName = prop.getProperty("browser",browser);
        String browserName = browser.toLowerCase();
        //driver = null;


//        ChromeOptions options = new ChromeOptions();
//        options.setExperimentalOption("useAutomationExtension", false);
        switch (browserName.toLowerCase()){
            case "chrome":
                setChromeDriver();
                break;
            case "firefox":
                setFirefoxDriver();
                break;
            case "edge":
                setEdgeDriver();
                break;
            default:
                throw new IllegalArgumentException(String.format("Incorrect browser name was provided : %s",browserName));

        }


    }


    static void setChromeDriver(){
        if (driverThreadLocal.get() == null) {
            driver = new ChromeDriver();
            driverThreadLocal.set(driver);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public static void setFirefoxDriver(){
        if (driverThreadLocal.get() == null) {
            driver = new FirefoxDriver();
            driverThreadLocal.set(driver);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public static void setEdgeDriver(){
        if (driverThreadLocal.get() == null) {
            driver = new EdgeDriver();
            driverThreadLocal.set(driver);
        }
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
    }

    public static WebDriver getDriver(){
        //driver.get().manage().window().maximize();
        //return driver;
        return driverThreadLocal.get();
    }


    @Parameters({"browserName"})
    @BeforeMethod(alwaysRun = true)
    public static void setUp(String browser) {
        initialization(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {

        if (getDriver() != null) {
            getDriver().quit();
            driverThreadLocal.remove();
        }

    }




















}

