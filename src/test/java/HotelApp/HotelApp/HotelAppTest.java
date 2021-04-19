package HotelApp.HotelApp;

import java.nio.channels.SelectableChannel;

import org.apache.poi.poifs.filesystem.FilteringDirectoryNode;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class HotelAppTest extends AbstractTest {

	private String City= "Paris";

	@Before
	public void setup() {
		selectBrowser(browser);
		System.out.println("setup");
	}

	@Test
	public void testHotel() {

		driver.get("http://192.168.1.95:8080/HotelWebapp/");


		WebElement selectType = driver.findElement(By.xpath("//select"));
		Select select = new Select(selectType);
		select.selectByValue(City);


		WebElement searchButton=driver.findElement(By.xpath("//button"));
		searchButton.click();

		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[.='Hôtels disponibles à "+ City +" ']"))));




	}

}