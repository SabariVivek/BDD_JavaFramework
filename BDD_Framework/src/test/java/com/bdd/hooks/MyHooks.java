package com.bdd.hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.bdd.reusablecomponents.Utils;
import com.bdd.reporting.ExtentManager;
import com.bdd.utilities.ConfigLoader;
import io.cucumber.java.*;

import java.util.HashMap;

public class MyHooks extends Utils {

    public static ExtentReports extent;
    private static final ThreadLocal<ExtentTest> parentTestThreadLocal = new ThreadLocal<>();
    public static final HashMap<String, ExtentTest> extentMap = new HashMap<>();
    public static ThreadLocal<ExtentTest> child = new ThreadLocal<>();

    @BeforeAll
    public static void beforeAll() {
        extent = ExtentManager.getInstance();
    }

    @Before
    public void beforeScenario(Scenario scenario) {
        parentTestThreadLocal.set(extent.createTest(getClass().getSimpleName()));
        extentMap.put(getClass().getSimpleName(), parentTestThreadLocal.get());
        child.set(extentMap.get(getClass().getSimpleName()).createNode(scenario.getName()));

        chooseAndLaunchBrowser(ConfigLoader.getInstance().getBrowserType());
        driver.get().get(ConfigLoader.getInstance().getURL());
        info("<b><<<< Execution Started >>>>></b>");
        pass("URL : " + ConfigLoader.getInstance().getURL());
    }

    @After
    public void afterScenario(Scenario scenario) {
        driver.get().close();
        info("<b><<<< Execution Ended >>>>></b>");
    }

    @AfterAll
    public static void afterAll() {
        addInformationToExtentReport();
        extent.flush();
    }

    public static void addInformationToExtentReport() {
        try {
            extent.setSystemInfo("OS : ", System.getProperty("os.name"));
            extent.setSystemInfo("OS Architecture : ", System.getProperty("os.arch"));
            extent.setSystemInfo("User Name : ", System.getProperty("user.name"));
            extent.setSystemInfo("Machine Name : ", System.getProperty("machine.name"));
            extent.setSystemInfo("IP Address : ", System.getProperty("machine.address"));
            extent.setSystemInfo("Java Version : ", System.getProperty("java.version"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void info(String description) {
        MyHooks.child.get().info(description);
    }

    public static void fail(String Description) {
        MyHooks.child.get().fail(Description);
    }

    public static void warning(String Description) {
        MyHooks.child.get().warning(Description);
    }

    public static void pass(String description) {
        MyHooks.child.get().pass(description);
    }
}