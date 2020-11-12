package test.java.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import main.java.Base.TestBase;
import main.java.Pages.CashDispensedPage;
import main.java.Pages.HomePage;

public class Governer_TC extends TestBase {
	HomePage homepage;
	CashDispensedPage cashDispense;

	public Governer_TC() throws IOException {
		super();
	}

	@BeforeMethod
	public void setUp() throws IOException {
		driverInit();
		homepage = new HomePage();
	}

	@Test
	public void btn_red_Test() throws IOException {
		String color = homepage.getBtnColor();
		//String[] firstSplit = color.split("(");
		String firstPart = color.substring(color.indexOf('(')+1,color.indexOf(')'));
		//String[] secondSplit = firstSplit[1].split(",");
		String[] secondSplit = firstPart.split(",");
		int colorCode = Integer.parseInt(secondSplit[0]);
		Assert.assertTrue(colorCode > 200);
		// Assert.assertTrue(color.equalsIgnoreCase("rgba(220, 53, 69, 1)"));
	}

	@Test
	public void text_DispenseNowTest() {
		String text = homepage.getDispenseNowBtnText();
		Assert.assertEquals(text, "Dispense Now");
	}

	@Test
	public void VeriyCashDispensedTest() throws IOException {
		cashDispense = homepage.clickDispenseNow();
		Assert.assertTrue(cashDispense.displayTextPage());
	}

	@AfterMethod
	public void tearDown(){
		teardown();
	}
}
