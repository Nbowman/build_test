package com.build.test.pages;


import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class basePage {


    public homePage navToHome {
        clickButton("home");
    }

    public cartPage navToCart() throws Exception {
        clickButton("cart");
    }

    public boolean loggedIn(String user) throws Exception {
        return checkText("username", user);
    }

    public productPage searchProduct(String product) throws Exception {

    }

    public brandPage SearchBrand(String brand) throws Exception {

    }

    public searchResultPage searchNonSpecific(String search) throws Exception {
        typeText("searchBox", search);
        clickButton("search");

    }




    WebDriver selObj = new RemoteWebDriver();
    String locatorFile = "";
    Type mapType = new TypeToken<Map<String, Map>>() {
    }.getType();
    Map<String, String[]> locatorMap = new Gson().fromJson(locatorFile, mapType);

    String[] getLocator(String name) throws Exception {
        if (locatorMap.containsKey(name))
            return locatorMap.get(name);
        else
            throw new Exception(String.format("Couldn't find element %s in locator map", name));
    }

    WebElement getElement(String locatorName) throws Exception {
        String[] locator = getLocator(locatorName);
        WebElement elementToFind = null;
        switch (locator[1]) {
            case "id":
                elementToFind = selObj.findElement(By.id(locator[2]));
                break;
            case "name":
                elementToFind = selObj.findElement(By.name(locator[2]));
                break;
            case "xPath":
                elementToFind = selObj.findElement(By.xpath(locator[2]));
                break;
            default:
                throw new Exception(String.format("Couldn't find element %s on page", locatorName));
        }
        return elementToFind;
    }

    List<WebElement> getElementList(String locatorName) throws Exception {
        String[] locator = getLocator(locatorName);
        List<WebElement> elementsToFind = null;
        switch (locator[1]) {
            case "id":
                elementsToFind = selObj.findElements(By.id(locator[2]));
                break;
            case "name":
                elementsToFind = selObj.findElements(By.name(locator[2]));
                break;
            case "xPath":
                elementsToFind = selObj.findElements(By.xpath(locator[2]));
                break;
            default:
                throw new Exception(String.format("Couldn't find elements by %s on page", locatorName));
        }
        return elementsToFind;
    }

    boolean typeText(String name, String text) throws Exception {
        WebElement txtBox = getElement(name);
        txtBox.sendKeys(text);
        return (txtBox.getText() == text);
    }

    void clickButton(String name) throws Exception {
        getElement(name).click();
    }

    boolean checkText(String name, String text) throws Exception {
        String checkText = getElement(name).getText();
        return (checkText == text);
    }
}
