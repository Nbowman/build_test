package com.build.test;

import com.google.common.collect.ObjectArrays;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Map;

public class exampleBuildTest extends buildTest {


    @DataProvider(name="exampleTestData")
    public Object[][] createData1() {
        String testData = "";
        Type mapType = new TypeToken<Array>() {
        }.getType();
        Array[][] locatorMap = new Gson().fromJson(testData, mapType);
        return locatorMap;
    }

    @Test(dataProvider = "exampleTestData")
    public void exampleTest() {






    }
}
