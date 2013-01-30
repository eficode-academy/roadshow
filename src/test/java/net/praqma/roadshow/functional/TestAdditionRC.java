package net.praqma.roadshow.functional;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestAdditionRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8081/");
		selenium.start();
	}

	@Test
	public void testAddition() throws Exception {
		selenium.open("/RoadShow/Calculator");
		selenium.type("name=value", "2");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");
		selenium.type("name=value", "3");
		selenium.click("name=plus");
		selenium.waitForPageToLoad("30000");		
		assertEquals("5.0", selenium.getValue("name=result"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
