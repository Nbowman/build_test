import com.google.gson.Gson;
import com.google.common.reflect.TypeToken;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Type;
import java.util.Map;

import static java.awt.SystemColor.text;

private class wdHelper {

	String locatorFile = "";
    Type mapType = new TypeToken<Map<String, Map>>(){}.getType();
    Map<String, String[]> locatorMap = new Gson().fromJson(locatorFile, mapType);


	String[] getLocator(String name) {
		if (locatorMap.containsKey(name))
			return locatorMap.get(name);
		else
			return false;
	}

	WebElement getElement(locatorName) {
		if (getLocator(locatorName))
			String[] locator = getLocator(locatorName);
		WebElement elementToFind = null;
		switch (locator[1]) {
			case "id":
				elementToFind = selObj.getElementByID(locator[2]);
				break;
			case "xPath":
				elementToFind = selObj.getElementByXpath(locator[2]);
				break;
			default:
				return false;
		}
		return elementToFind;
	}

	boolean typeText(String name, String text) {
		WebElement txtBox = getElement(name);
		txtBox.type(text);
		if (txtBox.getText() == text)
			return true;
		else
			return false;

	}

	boolean clickButton(String name, String text) {
		getElement(name).click();
		if ()
			return true;
		else
			return false;
	}

	boolean checkText(String name, String text) {
		String checkText = getElement(name).getText();
		if(checkText == text)
			return true;
		else if (checkText == "")

	}


}


