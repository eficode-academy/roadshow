package net.praqma.roadshow.functional;

import com.thoughtworks.selenium.*;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestAdditionRC {
	private Selenium selenium;
    private static final String TOMCAT_URL_AND_PORT = System.getenv("TOMCAT_URL_AND_PORT") != null ? System.getenv("TOMCAT_URL_AND_PORT") : "http://roadshowtomcatserver:8080/";
    private static final String DEPLOY_CONTEXT = System.getenv("DEPLOY_CONTEXT") != null ? System.getenv("DEPLOY_CONTEXT") : "RC";
    private static final String DEPLOY_PATH = StringUtils.isNotBlank(System.getenv("DEPLOY_PATH")) ? System.getenv("DEPLOY_PATH") : String.format("RoadShow-%s", DEPLOY_CONTEXT);
    private static final String APP_NAME = String.format("/%s/Calculator", DEPLOY_PATH);
    
	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("roadshowseleniumserver", 44444 ,"*firefox", String.format(TOMCAT_URL_AND_PORT));
		selenium.start();
	}

	@Test
	public void testAddition() throws Exception {
		selenium.open(APP_NAME);
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
		selenium.open(APP_NAME);
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
