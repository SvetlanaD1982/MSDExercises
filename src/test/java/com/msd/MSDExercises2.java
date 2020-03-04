package com.msd;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;

public class MSDExercises2 {

	@Test
	public void testAmazon() {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.amazon.com");

		driver.findElement(By.xpath("//*[@id=\'nav-xshop\']/a[1]")).click();
		driver.findElement(By.xpath("//*[@id=\'widgetFilters\']/div[1]/div[2]/span[6]/div/label/input")).click();
		driver.findElement(By.xpath("//*[@id=\'FilterItemView_sortOrder_dropdown\']/div/span[2]/span/span/span/span"))
				.click();

		driver.findElement(By.linkText("Price - High to Low")).click();
		List<WebElement> items = driver.findElements(By.cssSelector("span.a-button-inner"));

		for (int i = 1; i < 3; i++) {
			items.get(i).click();
		}

		driver.findElement(By.id("nav-cart")).click();

		assertEquals(driver.findElement(By.xpath("//*[@id=\'sc-subtotal-label-buybox\']")).getText(),
				"Subtotal (2 items):");

		driver.findElement(By.xpath("//*[@id=\"sc-buy-box-ptc-button\"]/span/input")).click();
		driver.close();
	}

}
