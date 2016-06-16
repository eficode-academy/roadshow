package net.praqma.roadshow.functional;

import com.thoughtworks.selenium.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestAdditionRC {
	private Selenium selenium;
    // These are set by the project configuration in build.gradle, so not checking for existense
    private static final String TOMCAT_URL_AND_PORT = System.getProperty("tomcatUrlAndPort");
    private static final String DEPLOY_PATH = System.getProperty("deployPath");
    private static final String SELENIUM_HOSTNAME = System.getProperty("seleniumHostname");
    private static final String SELENIUM_PORT = System.getProperty("seleniumPort");
    
	@Before
	public void setUp() throws Exception {
	System.out.println("TestAdditionRC functional test using selenium server");
        System.out.println("TestAdditionRC functional test using selenium server");
        System.out.println("*** Tomcat url and port for Test " + TOMCAT_URL_AND_PORT);
        System.out.println("*** Deploy url (where '/Calculator' is found: " + DEPLOY_PATH);
        System.out.println("*** Selenium server:" + SELENIUM_HOSTNAME);
        System.out.println("*** Selenium port:" + SELENIUM_PORT);
	selenium = new DefaultSelenium(SELENIUM_HOSTNAME,Integer.parseInt(SELENIUM_PORT) ,"*firefox", TOMCAT_URL_AND_PORT);
    selenium.start();
	}

	@Test
	public void testAddition() throws Exception {
		selenium.open(DEPLOY_PATH + "/Calculator");
		selenium.type("name=value", "2");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=value", "3");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");
		assertEquals("5.0", selenium.getValue("name=result"));
	}

    @Test
	public void testSubtract() throws Exception {
		selenium.open(DEPLOY_PATH + "/Calculator");
		selenium.type("name=value", "7");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=value", "6");
		selenium.click("name=minus");
		selenium.waitForPageToLoad("30000");
		assertEquals("1.0", selenium.getValue("name=result"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
