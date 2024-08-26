package Keywords;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;

public class validationKeywrods extends GenericKeywords {

	
	public void validateTitle(String ExpectedTitle) {
		
		System.out.println("Title found : "+ ExpectedTitle);
	Assert.assertEquals(driver.getTitle(), ExpectedTitle);
	}
}
