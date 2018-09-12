package com.simpleTests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.Pages.HomePage;

public class NewTest {
	protected static WebDriver driver;

	@Test
	public void testSelectMenuItems() {
		String message = "Your file was not found";

		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

		homePage.selectMenuItem(0);
		assertEquals(homePage.isNovigateSuccess(), message);
		driver.navigate().back();
		homePage.selectMenuItem(1);
		assertEquals(homePage.isNovigateSuccess(), message);
		driver.navigate().back();
		homePage.selectMenuItem(2);
		assertEquals(homePage.isNovigateSuccess(), message);
		driver.navigate().back();
		homePage.selectMenuItem(3);
		assertEquals(homePage.isNovigateSuccess(), message);
		driver.navigate().back();

	}

	@Test
	public void testPostTitle() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		assertTrue(homePage.selectPostByTytle(0).contains("Post Title"));
		assertTrue(homePage.selectPostByTytle(1).contains("Post Title"));

	}

	@Test
	public void TestPostContent() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		String paragrh1 = homePage.getParagraphByIndex(1);
		assertTrue(paragrh1.contains("Slava"));
		String paragraf2 = homePage.getParagraphByIndex(2);
		assertTrue(paragraf2.contains("Starusev"));

	}
	

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/com/chromeWebdriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///C:/Users/Slava/Documents/Html%20pages/testPage1.html");

	}

	@AfterClass
	public void afterClass() {
		 driver.quit();
	}

}
