package Keywords;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.ProfilesIni;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericKeywords {

	public WebDriver driver = null;
	public Properties prop = null;

	public void OpenBrowser(String browserKey) {
		String browserName = prop.getProperty(browserKey);
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized", "--disable-infobars");
			options.addArguments("--disable-extensions");
			options.addArguments("--incognito");
			options.addArguments("--disable-notifications");
			options.addArguments("ignore-certificate-errors");

			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
			FirefoxOptions options = new FirefoxOptions();

			ProfilesIni profiles = new ProfilesIni();
			FirefoxProfile ffprofile = profiles.getProfile("TestUser");
			ffprofile.setPreference("dom.webnotifications.enabled", false);
			ffprofile.setAcceptUntrustedCertificates(true);
			ffprofile.setAssumeUntrustedCertificateIssuer(false);
			options.setProfile(ffprofile);
			driver = new FirefoxDriver(options);
		} else if (browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		} else if (browserName.equalsIgnoreCase("safari")) {
			driver = new SafariDriver();
		} else {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver();
		}

		// Maximize Browser Window
		driver.manage().window().maximize();

	}

	public void OpenURL(String URLkey) {
		System.out.println("Opening Web URL : " + prop.getProperty(URLkey));
		driver.get(prop.getProperty(URLkey));

	}

	public void ClickServiceDropDown(String locatorkey) {
		System.out.println("clicking on Dropdown :" + getElement(locatorkey));
		getElement(locatorkey).click();

	}

	public void ClickCSA(String locatorkey) {

		System.out.println("Clicking on CSA :" + getElement(locatorkey));
//		WebElement optionToSelect = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
		WebElement optionToSelect = getElement(locatorkey);
		optionToSelect.click();

	}

	public WebElement getElement(String locatorKey) {
		// Element is Present
		if (!isElementPresent(locatorKey)) {
			// Report Error
			System.out.println("Element is not Present :" + locatorKey);
		}
		// Element is Visible
		if (!isElementVisible(locatorKey)) {
			// Report Error
			System.out.println("Element is not Visible :" + locatorKey);

		}
		if (!isElementToBeClickable(locatorKey)) {
			// Report Error
			System.out.println("Element is not Clickable :" + locatorKey);

		}

		// Create WebElement and Return Webelement
		WebElement element = driver.findElement(getLocator(locatorKey));
		return element;

	}

	public List<WebElement> getElements(String locatorKey) {

		// Create WebElement and Return Webelement

		List<WebElement> element = driver.findElements(getLocator(locatorKey));
		return element;

	}

	public boolean isElementPresent(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(getLocator(locatorKey)));

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}

	public boolean isElementVisible(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(getLocator(locatorKey)));

		} catch (Exception e) {
			e.printStackTrace();
			return false;

		}
		return true;
	}

	public boolean isElementToBeClickable(String locatorKey) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			wait.until(ExpectedConditions.elementToBeClickable(getLocator(locatorKey)));

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
			e.printStackTrace();
			return false;

		}
		return true;
	}

	public By getLocator(String locatorkey) {

		By by = null;

		if (locatorkey.endsWith("_id")) {
			by = By.id(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_xpath")) {
			by = By.xpath(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_linkText")) {
			by = By.linkText(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_css")) {
			by = By.cssSelector(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_PartialLinkText")) {
			by = By.partialLinkText(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_name")) {
			by = By.name(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_classname")) {
			by = By.className(prop.getProperty(locatorkey));
		} else if (locatorkey.endsWith("_tagName")) {
			by = By.tagName(prop.getProperty(locatorkey));
		}
		return by;
	}

	public void ClickEnroll(String locatorkey) {
		getElement(locatorkey).click();

	}

	public void ClickFarmdropdown(String locatorkey) {
		getElement(locatorkey).click();

	}

	public void ChooseFarm(String locatorkey) {

		System.out.println("Farm Choosen :" + locatorkey);
//		WebElement optionToSelect = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
//		WebElement optionToSelect = getElement(locatorkey);
//		optionToSelect.click();

		WebElement option = getElement(locatorkey);
		option.click();

	}

	public void ClickNextButton1(String locatorkey) {
		try {
			Thread.sleep(5000);
			System.out.println("Next Button Clicked Successfully");
			getElement(locatorkey).click();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	public void typevalues(String locatorkey, String value) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getElement(locatorkey).sendKeys(value);
//		getElement(locatorkey).click();

	}

	public void clickradiobutton(String locatorkey) {
		System.out.println("Radio Button Clicked Succesfully");
		getElement(locatorkey).click();
	}

	public void ClickNextButton2(String locatorkey) {

		WebElement nextButton = getElement(locatorkey);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextButton);

		// Optionally, add a small delay to ensure the element is in view
		try {
			Thread.sleep(5000); // Wait for 500 milliseconds
			nextButton.click();
			System.out.println("Next Button Clicked Successfully");
		} catch (InterruptedException e) {
			System.out.println("Next Button not Clicked" + e.getMessage());
			e.printStackTrace();
		}
		// Click the "Next" button
		
//		try {
//			Thread.sleep(10000);
//			getElement(locatorkey).click();
//
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Next Button not Clicked :" + e.getMessage());
//
//			e.printStackTrace();
//
//		}

	}

	public void ClickcheckBox(String locatorkey) {
//		getElement(locatorkey).click();
//		try {
//			Thread.sleep(5000);
//			getElement(locatorkey).click();
//
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			System.out.println("Radio button not Clicked" + e.getMessage());
//			e.printStackTrace();
//		}

		WebElement nextButton = getElement(locatorkey);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextButton);

		// Optionally, add a small delay to ensure the element is in view
		try {
			Thread.sleep(3000); // Wait for 500 milliseconds
			nextButton.click();
			System.out.println("Checkbox Clicked successfully");
		} catch (InterruptedException e) {
			System.out.println("Checkbox not Clicked" + e.getMessage());
			e.printStackTrace();
		}
		// Click the "Next" button

	}

	public void ClickNextButton3(String locatorkey) {
//		try {
//			Thread.sleep(5000);
//			getElement(locatorkey).click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println();
//		}
//		getElement(locatorkey).click();

		WebElement nextButton = getElement(locatorkey);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextButton);

		// Optionally, add a small delay to ensure the element is in view
		try {
			Thread.sleep(3000); // Wait for 500 milliseconds
			nextButton.click();
			System.out.println("Next Button Clicked Successfully");
		} catch (InterruptedException e) {
			e.printStackTrace();
			System.out.println("Next Button not Clicked" + e.getMessage());

		}

		// Click the "Next" button
	}

	public void clickradiobutton2(String locatorkey) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getElement(locatorkey).click();
	}

	public void ChooseLocation(String locatorkey) {

		System.out.println("Choose Location :" + getElement(locatorkey));
//		WebElement optionToSelect = driver.findElement(By.xpath(prop.getProperty(locatorkey)));
		WebElement optionToSelect = getElement(locatorkey);
		optionToSelect.click();
	}

	public void clickradiobutton3(String locatorkey) {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getElement(locatorkey).click();
	}

	public void ClickNextButton4(String locatorkey) {
//		try {
//			Thread.sleep(5000);
//			getElement(locatorkey).click();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println();
//		}
//		getElement(locatorkey).click();

		WebElement nextButton = getElement(locatorkey);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", nextButton);

		// Optionally, add a small delay to ensure the element is in view
		try {
			Thread.sleep(3000); // Wait for 500 milliseconds
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Click the "Next" button
		nextButton.click();
	}
	
	
	public void ClickTermsCheckbox(String locatorkey) {
		try {
			Thread.sleep(3000);
			getElement(locatorkey).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ClickSubmitButton(String locatorkey) {
		try {
			Thread.sleep(3000);
			System.out.println("Enroll Application successfull");
			getElement(locatorkey).click();

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void quitDriver() {
		try {
			Thread.sleep(5000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();
	}
}
