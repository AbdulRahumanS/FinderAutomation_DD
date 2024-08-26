package Keywords;

import java.io.FileInputStream;
import java.util.Properties;

public class ApplicationKeywords extends validationKeywrods{

	public ApplicationKeywords() {
		System.out.println("Calling from Application Constructor");
		prop = new Properties();
		try {
			FileInputStream FS = new FileInputStream(System.getProperty("user.dir")+ "\\src\\test\\resources\\Project.properties");
			prop.load(FS);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void login() {
		
	}
	public void selectDate() {
		
	}
}
