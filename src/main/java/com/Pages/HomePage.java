package com.Pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.simpleTests.NewTest;


public class HomePage extends NewTest {
	@FindBy(css = "#sidebar a")
	List<WebElement> sedeBar;
	@FindBy(css = "#main-message > h1")
	WebElement message;
	@FindBy(className = "post")
	List<WebElement> post;
	@FindBy(css = "div >.post p:nth-of-type(1)")
	WebElement p1;
	@FindBy(css = "div >.post p:nth-of-type(2)")
	WebElement p2;
	@FindBy(css = "div >.post p:nth-of-type(2)")
	WebElement testLocator;
	

	public String isNovigateSuccess() {

		System.out.println("======  text is   =======" + message.getText().toString());

		return message.getText().toString();
	}

	public void selectMenuItem(int index) {
		System.out.println("======size is =======" + sedeBar.size());
		System.out.println(sedeBar.get(index).getText().toString());
		sedeBar.get(index).click();

	}
	
	public String selectPostByTytle(int index){
		System.out.println("=======Post size is========"+post.size());
		
		return post.get(index).getText().toString();
		
		
	}

	public String getParagraphByIndex(int index) {
		if(index==1){
			System.out.println("=====p1 text is======"+p1.getText().toString());
			return p1.getText().toString();
			
		}
		else if(index==2){
			System.out.println("=====p1 text is======"+p2.getText().toString());
			return p2.getText().toString();
			
		}
		return "";
		
		
	}

}
